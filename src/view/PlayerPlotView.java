package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerPlotView extends JPanel implements ActionListener{
    private JPanel playerDataPanel;
    private JPanel statPlotPanel;
    private JButton selectStatButton;
    private ArrayList<String> selectedStats;
    private Map<String, Object> playerData;

    public PlayerPlotView() {
        setLayout(new BorderLayout());
        selectedStats = new ArrayList<>();
        playerData = new HashMap<>();

        playerDataPanel = new JPanel();
        playerDataPanel.setLayout(new BoxLayout(playerDataPanel, BoxLayout.Y_AXIS));
        add(playerDataPanel, BorderLayout.WEST);

        statPlotPanel = new JPanel();
        add(statPlotPanel, BorderLayout.CENTER);

        selectStatButton = new JButton("Select Stat");
        selectStatButton.addActionListener(this);
        add(selectStatButton, BorderLayout.SOUTH);
        updateStatPlot();

    }
    private void updatePlayerDataPanel() {
        playerDataPanel.removeAll();
        playerDataPanel.revalidate();
        playerDataPanel.repaint();
    }

    private void updateStatPlot() {
        statPlotPanel.removeAll();
        statPlotPanel.revalidate();
        statPlotPanel.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectStatButton) {
            selectedStats.clear();
            selectedStats.add("Kills");
            selectedStats.add("Deaths");
//            ...
            updateStatPlot();

        }
    }
}
