package view;

import interface_adapter.key_setup.KeySetupController;
import interface_adapter.key_setup.KeySetupState;
import interface_adapter.key_setup.KeySetupViewModel;
import interface_adapter.login.LogInViewModel;
import interface_adapter.login.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class KeySetupView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Key Setup";

    private final LogInViewModel logInViewModel;

    private final KeySetupViewModel keySetupViewModel;

    private final KeySetupController keySetupController;
    private final JTextField keyInputField = new JTextField(42);

    private final JButton submit;

    public KeySetupView(LogInViewModel logInViewModel, KeySetupViewModel keySetupViewModel, KeySetupController keySetupController) {
        this.logInViewModel = logInViewModel;
        this.keySetupViewModel = keySetupViewModel;
        this.keySetupController = keySetupController;
        keySetupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(KeySetupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel keyInfo = new LabelTextPanel(
                new JLabel(KeySetupViewModel.SETUP_KEY_LABEL), keyInputField);

        JPanel buttons = new JPanel();
        submit = new JButton(KeySetupViewModel.SETUP_KEY_BUTTON_LABEL);
        buttons.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(submit)){
                    KeySetupState currentState = keySetupViewModel.getState();

                    keySetupController.execute(currentState.getKey());
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(keyInfo);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        KeySetupState state = (KeySetupState) evt.getNewValue();
        if (state.getKeyError() != null) {
            JOptionPane.showMessageDialog(this, state.getKeyError());
        }
    }
}
