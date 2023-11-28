package view;

import interface_adapter.check_match.CheckMatchController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.update.UpdateController;
import interface_adapter.update.UpdateState;
import interface_adapter.update.UpdateViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.ArrayList;

import static java.awt.Font.PLAIN;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "LOL.GH";

    private final LoggedInViewModel loggedInViewModel;

    private final UpdateController updateController;

    private final UpdateViewModel updateViewModel;

    private final CheckMatchController checkMatchController;

    private final LogoutController logoutController;

//    private final LogoutController logoutController;


//    TODO: Add CheckPlayerDetailController and LogoutController.
//    private final LogoutController logoutController;
//    private final CheckPlayerDetailController checkPlayerDetailController;

    private final JButton update;

    private final JButton logout;

    private final JButton checkPlayerPlot;

    private BufferedImage stat1Image;
    private BufferedImage stat2Image;
    private BufferedImage stat3Image;
    private JPanel stat1Panel;
    private JPanel stat2Panel;
    private JPanel stat3Panel;

    private String playerID;

    private ArrayList<String> matchIDList = new ArrayList<>();

    private ImageIcon poroIcon = new ImageIcon("images/poro.png");

//TODO There will be 20 checkMatch buttons in total, and each button should correspond to a specific matchID.

    public LoggedInView(LoggedInViewModel loggedInViewModel, UpdateController updateController,
                        UpdateViewModel updateViewModel, CheckMatchController checkMatchController,
                        LogoutController logoutController) {
        this.loggedInViewModel = loggedInViewModel;
        this.updateController = updateController;
        this.updateViewModel = updateViewModel;
        this.checkMatchController = checkMatchController;
        this.logoutController = logoutController;
        loggedInViewModel.addPropertyChangeListener(this);

        update = new JButton(LoggedInViewModel.UPDATA_STAT_BUTTON_LABEL);
        logout = new JButton(LoggedInViewModel.LOGOUT_BUTTON_LABEL);
        checkPlayerPlot = new JButton(LoggedInViewModel.CHECK_PLAYER_PLOT_BUTTON_LABEL);
        checkPlayerPlot.setPreferredSize(new Dimension(150, 50));
        update.setPreferredSize(new Dimension(150, 50));
        logout.setPreferredSize(new Dimension(150, 50));

        this.setPreferredSize(new Dimension(900, 650));
        this.setLayout(new BorderLayout());

        JPanel rightPanel = createPanel(600, 650);
        JPanel leftPanel = new JPanel(new GridLayout(2, 1));

        JPanel leftTopSubPanel = createPanel(300, 300);
        JPanel leftBottomSubPanel = createPanel(300, 350);
        JPanel rightTopSubPanel = createPanel(600, 570);
        JPanel rightBottomSubPanel = createPanel(600, 80);
        try {
            paintLeftTopSubPanel(leftTopSubPanel);
            paintLeftBottomSubPanel(leftBottomSubPanel);
            paintRightTopSubPanel(rightTopSubPanel);
            paintRightBottomSubPanel(rightBottomSubPanel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        leftPanel.add(leftTopSubPanel);
        leftPanel.add(leftBottomSubPanel);
        rightPanel.add(rightTopSubPanel);
        rightPanel.add(rightBottomSubPanel);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);


        // Add panels to the frame
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(900, 600));
        this.setMaximumSize(new Dimension(900, 600));

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
                    try {
                        repaintView(rightTopSubPanel, leftTopSubPanel, leftBottomSubPanel);
                    } catch (IOException d) {
                        d.printStackTrace();
                    }
                }
            }
        });


        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(logout)) {
                    logoutController.execute();
                }
            }
        });


    }

    private static JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));

        return panel;
    }

    private static JPanel createSubPanel(CheckMatchController checkMatchController, LoggedInState state, int i) {
        JPanel subPanel = new JPanel();

        String text = String.format("%d/%d/%d", state.getKillsList().get(i),
                state.getDeathsList().get(i), state.getAssistsList().get(i));
        JLabel label = new JLabel(text);

        JButton checkMatchButton = new JButton(LoggedInViewModel.CHECK_MATCH_DETAIL_BUTTON_LABEL);
        checkMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(checkMatchButton)) {
                    System.out.println(state.getMatchIDList().get(i));
                    checkMatchController.execute(state.getMatchIDList().get(i));
                }
            }
        });
        checkMatchButton.setPreferredSize(new Dimension(60, 50));
        subPanel.add(label);
        subPanel.add(checkMatchButton);
        subPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional: Add a border for better visibility
        subPanel.setPreferredSize(new Dimension(260, 60));

        return subPanel;
    }

    private JPanel createPanelByImage(BufferedImage image){
        return new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, this);
                }
            }
        };
    }

    private void repaintView(JPanel rightTopSubPanel, JPanel leftTopSubPanel, JPanel leftBottomSubPanel) throws IOException {
        paintRightTopSubPanel(rightTopSubPanel);
        paintLeftTopSubPanel(leftTopSubPanel);
        paintLeftBottomSubPanel(leftBottomSubPanel);
    }

    private void paintRightTopSubPanel(JPanel rightTopSubPanel) throws IOException {
        rightTopSubPanel.setLayout(new GridLayout(3, 1));
        stat1Image = ImageIO.read(new File("images/stat1.png"));
        stat2Image = ImageIO.read(new File("images/stat2.png"));
        stat3Image = ImageIO.read(new File("images/stat3.png"));
        stat1Panel = createPanelByImage(stat1Image);
        stat2Panel = createPanelByImage(stat2Image);
        stat3Panel = createPanelByImage(stat3Image);
        rightTopSubPanel.removeAll();
        rightTopSubPanel.add(stat1Panel);
        rightTopSubPanel.add(stat2Panel);
        rightTopSubPanel.add(stat3Panel);
        rightTopSubPanel.revalidate();
        rightTopSubPanel.repaint();
    }

    private void paintLeftTopSubPanel(JPanel leftTopSubPanel) throws IOException {
        leftTopSubPanel.removeAll();
        GridBagConstraints c = new GridBagConstraints();
        Image scaledPoro = poroIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledPoroIcon = new ImageIcon(scaledPoro);
        JLabel poro = new JLabel(scaledPoroIcon);
        poro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        poro.setSize(200, 200);
        leftTopSubPanel.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 1;
        leftTopSubPanel.add(poro, c);
        BufferedReader reader = new BufferedReader(new FileReader("player.csv"));
        playerID = reader.readLine();
        JLabel playerIDLabel = new JLabel(playerID);
        playerIDLabel.setFont(new Font("Lucida Grande", PLAIN, 15));
        c.gridx = 0;
        c.gridy = 2;
        leftTopSubPanel.add(playerIDLabel, c);
        JPanel updateAndLogout = new JPanel(new GridLayout(1, 2));
        updateAndLogout.setPreferredSize(new Dimension(300, 50));
        updateAndLogout.add(update);
        updateAndLogout.add(logout);
        c.gridx = 0;
        c.gridy = 3;
        leftTopSubPanel.add(updateAndLogout, c);
        leftTopSubPanel.revalidate();
        leftTopSubPanel.repaint();
    }

    private void paintLeftBottomSubPanel(JPanel leftBottomSubPanel) {
        File matchIDFile = new File("matchdata.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(matchIDFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                matchIDList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        leftBottomSubPanel.removeAll();
        JScrollPane matchesScrollPane = new JScrollPane();
        matchesScrollPane.setPreferredSize(new Dimension(280, 310));
        JPanel matchPanel = new JPanel();
        matchPanel.setLayout(new BoxLayout(matchPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < loggedInViewModel.getState().getWinList().size(); i++) {
            JPanel subPanel = createSubPanel(checkMatchController, loggedInViewModel.getState(), i);
            matchPanel.add(subPanel);

            matchesScrollPane.setViewportView(matchPanel);
            matchesScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            leftBottomSubPanel.add(matchesScrollPane);

            leftBottomSubPanel.revalidate();
            leftBottomSubPanel.repaint();
        }
    }

    private void paintRightBottomSubPanel(JPanel rightBottomSubPanel) {
        rightBottomSubPanel.add(checkPlayerPlot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
