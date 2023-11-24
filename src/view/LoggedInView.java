package view;

import interface_adapter.check_match.CheckMatchController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.update.UpdateController;
import interface_adapter.update.UpdateState;
import interface_adapter.update.UpdateViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "LOL.GH";

    private final LoggedInViewModel loggedInViewModel;

    private final UpdateController updateController;

    private final UpdateViewModel updateViewModel;

    private final CheckMatchController checkMatchController;



//    TODO: Add CheckPlayerDetailController and LogoutController.
//    private final LogoutController logoutController;
//    private final CheckPlayerDetailController checkPlayerDetailController;

    private final JButton update;

    private final JButton checkMatch1;

    private ImageIcon icon1 = new ImageIcon("images/stat1.png");
    private ImageIcon icon2 = new ImageIcon("images/stat2.png");
    private ImageIcon icon3 = new ImageIcon("images/stat3.png");
//TODO There will be 20 checkMatch buttons in total, and each button should correspond to a specific matchID.

//    private final JButton logout;
//    private final JButton checkPlayerStatsDetail;


    public LoggedInView(LoggedInViewModel loggedInViewModel, UpdateController updateController, UpdateViewModel updateViewModel, CheckMatchController checkMatchController) {
        this.loggedInViewModel = loggedInViewModel;
        this.updateController = updateController;
        this.updateViewModel = updateViewModel;
        this.checkMatchController = checkMatchController;

        update = new JButton(loggedInViewModel.UPDATA_STAT_BUTTON_LABEL);
        checkMatch1 = new JButton(loggedInViewModel.CHECK_MATCH_DETAIL_BUTTON_LABEL);
        update.setPreferredSize(new Dimension(150, 50));
        checkMatch1.setPreferredSize(new Dimension(150, 50));

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File playerFile = new File("player.csv");
                String playerID;
                try (BufferedReader reader = new BufferedReader(new FileReader(playerFile))) {
                    playerID = reader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                loggedInViewModel.setLoggedInPlayer(playerID);
                LoggedInState loggedInState = loggedInViewModel.getState();
                loggedInState.setPlayerID(playerID);
                loggedInViewModel.setState(loggedInState);
                UpdateState updateState = updateViewModel.getState();
                updateState.setUsername(playerID);
                updateViewModel.setState(updateState);
                if (e.getSource().equals(update)) {
                    updateController.execute(playerID, "kills", "deaths", "assists", "cs", "goldEarned");
                    icon1 = new ImageIcon("images/stat1.png");
                    icon2 = new ImageIcon("images/stat2.png");
                    icon3 = new ImageIcon("images/stat3.png");
                    repaint();
                }
                }
            });

        checkMatch1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(checkMatch1)){
                    checkMatchController.execute("NA1_4829676591");
                    //TODO, substitute the matchID with an actual one. This matchID is just for demo.
                }
            }
        });

        this.setPreferredSize(new Dimension(900, 650));
        this.setLayout(new BorderLayout());

        JPanel rightPanel = createPanel(600, 650);
        this.add(rightPanel, BorderLayout.EAST);

        JPanel leftPanel = new JPanel(new GridLayout(2, 1));
        JPanel leftTopSubPanel = createPanel(300, 300);
        JPanel leftBottomSubPanel = createPanel(300, 350);

        leftTopSubPanel.add(update);
        JScrollPane matchesScrollPane = new JScrollPane();
        matchesScrollPane.setPreferredSize(new Dimension(280, 310));

        JPanel matchPanel = new JPanel();
        matchPanel.setLayout(new BoxLayout(matchPanel, BoxLayout.Y_AXIS));

        // Add sub-panels with text to the main panel
        for (int i = 1; i <= 20; i++) {
            JPanel subPanel = createSubPanel("Text in Panel " + i);
            matchPanel.add(subPanel);
        }

        // Add the main panel to the JScrollPane
        matchesScrollPane.setViewportView(matchPanel);

        leftBottomSubPanel.add(matchesScrollPane);
        leftPanel.add(leftTopSubPanel);
        leftPanel.add(leftBottomSubPanel);
        this.add(leftPanel, BorderLayout.WEST);

        JLabel label1 = new JLabel(icon1);
        JLabel label2 = new JLabel(icon2);
        JLabel label3 = new JLabel(icon3);
        rightPanel.add(label1);
        rightPanel.add(label2);
        rightPanel.add(label3);
        rightPanel.add(checkMatch1);

        leftTopSubPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        leftBottomSubPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add panels to the frame
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(900, 600));
        this.setMaximumSize(new Dimension(900, 600));


    }

    private static JPanel createPanel(int width, int height) {
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
