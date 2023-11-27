package view;

import entity.Match;
import interface_adapter.check_match.CheckMatchController;
import interface_adapter.check_match.CheckMatchState;
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
import java.util.ArrayList;
import java.util.Map;


public class CheckMatchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Check Match";

//    private final CheckMatchController checkMatchController;
    private final CheckMatchViewModel checkMatchViewModel;
    private final ReturnMainController returnMainController;
    private final LoggedInViewModel loggedInViewModel;

    private final JButton returnMain;

    private ImageIcon championIcon = new ImageIcon("images/teemo.png");

    public CheckMatchView(CheckMatchViewModel checkMatchViewModel, ReturnMainController returnMainController,
                          LoggedInViewModel loggedInViewModel){
        this.checkMatchViewModel = checkMatchViewModel;
        this.returnMainController = returnMainController;
        this.loggedInViewModel = loggedInViewModel;

        CheckMatchState checkMatchState = checkMatchViewModel.getState();
        Match match = checkMatchState.getMatch();

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
            JPanel subPanel = createSubPanel(i, match);
            lowerPanel.add(subPanel);
        }
        this.add(lowerPanel, BorderLayout.SOUTH);

        upperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lowerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setMinimumSize(new Dimension(900, 650));
        this.setMaximumSize(new Dimension(900, 650));


    }

    private static JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));

        return panel;
    }

    private static JPanel createSubPanel(int i, Match match) {
        Map<String, Object> playerData = match.getDataByPlayerIndex(i);
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Left Panel
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(150, 100));
        subPanel.add(leftPanel, BorderLayout.WEST);

        // Upper Panel inside Left Panel
        JPanel upperPanel = new JPanel();
        upperPanel.setPreferredSize(new Dimension(150, 30));
        leftPanel.add(upperPanel, BorderLayout.NORTH);
        upperPanel.add(new JLabel((String) playerData.get("championName")));

        // Bottom Panel inside Left Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(150, 70));
        leftPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(new JLabel(new ImageIcon("images/teemo.png"))); // Replace with the actual image path

        // Right Panel
        JPanel rightPanel = new JPanel(new GridLayout(3, 1));
        rightPanel.setPreferredSize(new Dimension(300, 100));
        subPanel.add(rightPanel, BorderLayout.CENTER);

        // Text Panel 1 inside Right Panel
        JPanel textPanel1 = new JPanel();
        textPanel1.add(new JLabel("Gold Earned:    "+ playerData.get("goldEarned")));
        rightPanel.add(textPanel1);

        // Text Panel 2 inside Right Panel
        JPanel textPanel2 = new JPanel();
        textPanel2.add(new JLabel("K: "+playerData.get("kills")+"D: "+playerData.get("deaths")+"A: "+playerData.get("assists")));
        rightPanel.add(textPanel2);

        // Text Panel 3 inside Right Panel
        JPanel textPanel3 = new JPanel();
        textPanel3.add(new JLabel("Damage Dealt:  "+playerData.get("totalDamageDealt")));
        rightPanel.add(textPanel3);

        return subPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
