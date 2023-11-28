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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class KeySetupView extends JPanel implements ActionListener, PropertyChangeListener {

    public static boolean PanelClose = false;

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
                    currentState.setKey(keyInputField.getText());
                    keySetupController.execute(currentState.getKey());
                    PanelClose = true;
                    java.awt.Container container = SwingUtilities.getWindowAncestor(KeySetupView.this);
                    if (container instanceof JFrame) {
                        // If it is, dispose of the JFrame, effectively closing the application
                        ((JFrame) container).dispose();
                    } else {
                        // If it's not a JFrame, remove the panel from its parent
                        container.remove(KeySetupView.this);
                        // Repaint the parent container to reflect the changes
                        container.revalidate();
                        container.repaint();
                    }
                }
            }
        });

//        keyInputField.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                KeySetupState currentState = keySetupViewModel.getState();
//                currentState.setKey(keyInputField.getText() + e.getKeyChar());
//                keySetupViewModel.setState(currentState);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });

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
