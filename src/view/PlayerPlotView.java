package view;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.select_stat.SelectStatController;
import interface_adapter.return_mainpage.ReturnMainController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerPlotView extends JPanel implements ActionListener {
    public String viewName = "Check Player Stat Details";
    private JPanel playerDataPanel;
    private JPanel statPlotPanel;
    private JButton selectStatButton;
    private ArrayList<String> matchIDList = new ArrayList<>();
    private final SelectStatController selectStatController;
    private final ReturnMainController returnMainController;
    private final CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel;
    private final JButton returnMain;
    private BufferedImage stat1Image;
    private BufferedImage stat2Image;
    private BufferedImage stat3Image;
    private BufferedImage stat4Image;
    private BufferedImage stat5Image;
    private JPanel stat1Panel;
    private JPanel stat2Panel;
    private JPanel stat3Panel;
    private JPanel stat4Panel;
    private JPanel stat5Panel;

    public PlayerPlotView(SelectStatController selectStatController, CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel, ReturnMainController returnMainController) {
        this.selectStatController = selectStatController;
        this.checkPlayerStatDetailsViewModel = checkPlayerStatDetailsViewModel;
        this.returnMainController = returnMainController;

        returnMain = new JButton(CheckPlayerStatDetailsViewModel.RETURN_MAIN_BUTTON_LABEL);
        returnMain.setPreferredSize(new Dimension(150, 50));

        selectStatButton = new JButton(CheckPlayerStatDetailsViewModel.SELECT_STAT_BUTTON_LABEL);

        returnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(returnMain)){
                    returnMainController.execute();
                }
            }
        });

        selectStatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == selectStatButton) {
                    PlayerPlotView.this.selectStatController.execute();
                }
            }
        });

        this.setLayout(new BorderLayout());
        playerDataPanel = new JPanel();
        playerDataPanel.setLayout(new BoxLayout(playerDataPanel, BoxLayout.Y_AXIS));
        add(playerDataPanel, BorderLayout.WEST);
        JPanel upperPanel = createPanel(900, 50);
        upperPanel.setLayout(new BorderLayout());
        this.add(upperPanel, BorderLayout.NORTH);

        upperPanel.add(returnMain, BorderLayout.WEST);

        statPlotPanel = new JPanel();
        add(statPlotPanel, BorderLayout.CENTER);

        JPanel middlePanel = createPanel(900, 550);
        try {
            paintImage(middlePanel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.add(middlePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        Dimension buttonSize = selectStatButton.getPreferredSize();
        selectStatButton.setPreferredSize(new Dimension((int)(buttonSize.width * 1.2), (int)(buttonSize.height * 1.2)));

        buttonPanel.add(selectStatButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    private static JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));

        return panel;
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
    private void paintImage(JPanel imagePanel) throws IOException {
        imagePanel.setLayout(new GridLayout(3, 1));
        stat1Image = ImageIO.read(new File("images/stat1.png"));
        stat2Image = ImageIO.read(new File("images/stat2.png"));
        stat3Image = ImageIO.read(new File("images/stat3.png"));
        stat4Image = ImageIO.read(new File("images/stat4.png"));
        stat5Image = ImageIO.read(new File("images/stat5.png"));
        stat1Panel = createPanelByImage(stat1Image);
        stat2Panel = createPanelByImage(stat2Image);
        stat3Panel = createPanelByImage(stat3Image);
        stat4Panel = createPanelByImage(stat4Image);
        stat5Panel = createPanelByImage(stat5Image);
        imagePanel.removeAll();
        imagePanel.add(stat1Panel);
        imagePanel.add(stat2Panel);
        imagePanel.add(stat3Panel);
        imagePanel.add(stat4Panel);
        imagePanel.add(stat5Panel);
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}