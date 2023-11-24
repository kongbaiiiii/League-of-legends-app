package view;

import interface_adapter.check_match.CheckMatchController;
import interface_adapter.check_match.CheckMatchViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.return_mainpage.ReturnMainController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class CheckMatchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "LOL.GH";

//    private final CheckMatchController checkMatchController;
    private final CheckMatchViewModel checkMatchViewModel;
    private final ReturnMainController returnMainController;
    private final LoggedInViewModel loggedInViewModel;

    private final JButton returnMain;

    public CheckMatchView(CheckMatchViewModel checkMatchViewModel, ReturnMainController returnMainController,
                          LoggedInViewModel loggedInViewModel){
        this.checkMatchViewModel = checkMatchViewModel;
        this.returnMainController = returnMainController;
        this.loggedInViewModel = loggedInViewModel;

        returnMain = new JButton(checkMatchViewModel.RETURN_MAIN_BUTTON_LABEL);
        returnMain.setPreferredSize(new Dimension(150, 50));

        returnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(returnMain)){
                    returnMainController.execute();
                }
            }
        });

        this.setPreferredSize(new Dimension(900, 650));
        this.setLayout(new BorderLayout());

        JPanel upperPanel = createPanel(900, 150);
        this.add(upperPanel, BorderLayout.NORTH);

        upperPanel.add(returnMain);

        JPanel lowerPanel = new JPanel(new GridLayout(5, 2));
        lowerPanel.setPreferredSize(new Dimension(900, 500));
        for (int i = 1; i <= 10; i++) {
            JPanel subPanel = createSubPanel("Text in Panel " + i);
            subPanel.add(subPanel);
            lowerPanel.add(subPanel);
        }
        this.add(lowerPanel, BorderLayout.SOUTH);

        // Add text fields to the panel
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 2; j++) {
//                JTextField textField = new JTextField();
//                panel.add(textField);
//            }
//        }

        upperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lowerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setMinimumSize(new Dimension(900, 650));
        this.setMaximumSize(new Dimension(900, 650));


    }

    static JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));

        return panel;
    }

    private static JPanel createSubPanel(String text) {
        JPanel subPanel = new JPanel();
        JLabel label = new JLabel(text);
        subPanel.add(label);
        subPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional: Add a border for better visibility
//        subPanel.setPreferredSize(new Dimension());
        return subPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
