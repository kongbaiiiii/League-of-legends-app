package view;

import entity.Match;
import interface_adapter.check_match.CheckMatchState;
import interface_adapter.check_match.CheckMatchViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.return_mainpage.ReturnMainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;


public class CheckMatchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Check Match";

//    private final CheckMatchController checkMatchController;
    private final CheckMatchViewModel checkMatchViewModel;
    private final ReturnMainController returnMainController;
    private final LoggedInViewModel loggedInViewModel;

    private final JButton returnMain;

    private Match match;

    private static ImageIcon championIcon = new ImageIcon("images/teemo.png");

    public CheckMatchView(CheckMatchViewModel checkMatchViewModel, ReturnMainController returnMainController,
                          LoggedInViewModel loggedInViewModel){
        this.checkMatchViewModel = checkMatchViewModel;
        this.returnMainController = returnMainController;
        this.loggedInViewModel = loggedInViewModel;

        CheckMatchState checkMatchState = checkMatchViewModel.getState();
        this.match = checkMatchState.getMatch();

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

        JPanel upperPanel = createPanel(900, 50);
        upperPanel.setLayout(new BorderLayout());
        this.add(upperPanel, BorderLayout.NORTH);

        upperPanel.add(returnMain, BorderLayout.WEST);

        Object gamemode = match.getDataByPlayerIndex(1).get("gamemode");
        JLabel gamelabel = new JLabel("Game Mode:  "+gamemode);
        Font customFont = new Font("Arial", Font.BOLD, 16);
        gamelabel.setFont(customFont);
        upperPanel.add(gamelabel, BorderLayout.EAST);

        JPanel lowerPanel = new JPanel(new GridLayout(1, 2));
        lowerPanel.setPreferredSize(new Dimension(900, 600));
        JPanel leftColumnPanel = new JPanel(new GridLayout(5, 1));
        JPanel rightColumnPanel = new JPanel(new GridLayout(5, 1));

        for (int i = 0; i < 10; i++) {
            JPanel subPanel = createSubPanel(i, match);
            if (i < 5) {
                leftColumnPanel.add(subPanel);
            } else {
                rightColumnPanel.add(subPanel);
            }
        }
        lowerPanel.add(leftColumnPanel);
        lowerPanel.add(rightColumnPanel);
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
        JPanel subPanel = new JPanel(new GridLayout(1, 2));
        subPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Left Panel
        JPanel leftPanel = new JPanel(new GridLayout(2, 1));
        leftPanel.setPreferredSize(new Dimension(150, 120));
        subPanel.add(leftPanel, BorderLayout.WEST);

        //Name Panel inside left Panel
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        upperPanel.setPreferredSize(new Dimension(150, 20));
        JLabel summonerName  = new JLabel((String) playerData.get("summonerName"));
        Font customFont = new Font("Arial", Font.BOLD, 13);
        summonerName.setFont(customFont);
        upperPanel.add(summonerName);
        upperPanel.add(new JLabel((String) playerData.get("championName")));
        leftPanel.add(upperPanel, BorderLayout.NORTH);
        setColour(i, upperPanel);



        // Upper Panel inside Left Panel
//        JPanel middlePanel = new JPanel();
//        middlePanel.setPreferredSize(new Dimension(150, 10));
//        middlePanel.add(new JLabel((String) playerData.get("championName")));
//        leftPanel.add(middlePanel, BorderLayout.CENTER);

        // Bottom Panel inside Left Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(150, 100));
        ImageIcon poroIcon = new ImageIcon(String.format("images/championicons/%s.png", playerData.get("championId")));
        Image scaledPoro = poroIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledPoroIcon = new ImageIcon(scaledPoro);
        JLabel poro = new JLabel(scaledPoroIcon);
        poro.setSize(50, 50);
//        bottomPanel.add(poro); // Replace with the actual image path
        bottomPanel.add(poro, BorderLayout.CENTER);
        leftPanel.add(bottomPanel, BorderLayout.SOUTH);
        setColour(i, bottomPanel);

        // Right Panel
        JPanel rightPanel = new JPanel(new GridLayout(3, 1));
        rightPanel.setPreferredSize(new Dimension(300, 120));
        subPanel.add(rightPanel, BorderLayout.EAST);

        // Text Panel 1 inside Right Panel
//        JPanel textPanel1 = new JPanel();
        rightPanel.add(new JLabel("Gold Earned:    "+ playerData.get("goldEarned")));
//        rightPanel.add(textPanel1);

        // Text Panel 2 inside Right Panel
//        JPanel textPanel2 = new JPanel();
        rightPanel.add(new JLabel("K: "+playerData.get("kills")+" D: "+playerData.get("deaths")+" A: "+playerData.get("assists")));
//        rightPanel.add(textPanel2);

        // Text Panel 3 inside Right Panel
//        JPanel textPanel3 = new JPanel();
        rightPanel.add(new JLabel("Damage Dealt:  "+playerData.get("totalDamageDealt")));
//        rightPanel.add(textPanel3);
        setColour(i, rightPanel);



        return subPanel;
    }

    private static void setColour(int i, JPanel subPanel){
        if (i<5){
            subPanel.setBackground(new Color(143, 206, 247));
        }else{
            subPanel.setBackground(new Color(245, 144, 144));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
