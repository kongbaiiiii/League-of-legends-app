package view;

import interface_adapter.select_stat.SelectStatViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectDataView extends JPanel implements ActionListener, PropertyChangeListener {
    final SelectStatViewModel selectStatViewModel;

    final JButton apply;
    public final String viewName = "select data view";

    public SelectDataView(SelectStatViewModel selectStatViewModel) {
        this.selectStatViewModel = selectStatViewModel;

        this.apply = new JButton(SelectStatViewModel.APPLY_STAT_BUTTON_LABEL);

        this.setLayout(new GridLayout(14, 1));
        String[] checkBoxLabels = {
                SelectStatViewModel.KILLS_CHECK_BOX_LABEL,
                SelectStatViewModel.DEATHS_CHECK_BOX_LABEL,
                SelectStatViewModel.ASSISTS_CHECK_BOX_LABEL,
                SelectStatViewModel.KDA_CHECK_BOX_LABEL,
                SelectStatViewModel.CS_CHECK_BOX_LABEL,
                SelectStatViewModel.GOLD_EARNED_CHECK_BOX_LABEL,
                SelectStatViewModel.BOUNTY_LEVEL_CHECK_BOX_LABEL,
                SelectStatViewModel.DAMAGE_DEALT_CHECK_BOX_LABEL,
                SelectStatViewModel.DAMAGE_TAKEN_CHECK_BOX_LABEL,
                SelectStatViewModel.GAME_WON_CHECK_BOX_LABEL,
                SelectStatViewModel.EARLY_SURRENDER_CHECK_BOX_LABEL,
                SelectStatViewModel.LONGEST_LIVING_TIME_CHECK_BOX_LABEL,
                SelectStatViewModel.TIME_CC_OTHERS_CHECK_BOX_LABEL,
                SelectStatViewModel.TOTAL_DEAD_TIME_CHECK_BOX_LABEL
        };
        String[] checkBoxValues = {
                SelectStatViewModel.KILLS_CHECK_BOX_VALUE,
                SelectStatViewModel.DEATHS_CHECK_BOX_VALUE,
                SelectStatViewModel.ASSISTS_CHECK_BOX_VALUE,
                SelectStatViewModel.KDA_CHECK_BOX_VALUE,
                SelectStatViewModel.CS_CHECK_BOX_VALUE,
                SelectStatViewModel.GOLD_EARNED_CHECK_BOX_VALUE,
                SelectStatViewModel.BOUNTY_LEVEL_CHECK_BOX_VALUE,
                SelectStatViewModel.DAMAGE_DEALT_CHECK_BOX_VALUE,
                SelectStatViewModel.DAMAGE_TAKEN_CHECK_BOX_VALUE,
                SelectStatViewModel.GAME_WON_CHECK_BOX_VALUE,
                SelectStatViewModel.EARLY_SURRENDER_CHECK_BOX_VALUE,
                SelectStatViewModel.LONGEST_LIVING_TIME_CHECK_BOX_VALUE,
                SelectStatViewModel.TIME_CC_OTHERS_CHECK_BOX_VALUE,
                SelectStatViewModel.TOTAL_DEAD_TIME_CHECK_BOX_VALUE
        };
        ArrayList<String> checkBoxLabelsList = new ArrayList<>(Arrays.asList(checkBoxLabels));
        ArrayList<String> checkBoxValuesList = new ArrayList<>(Arrays.asList(checkBoxValues));
        for (int i = 0; i < 13; i++) {
            JPanel subPanel = createSubPanel(checkBoxLabelsList.get(i), checkBoxValuesList.get(i));
            this.add(subPanel);
        }
    }

    private JPanel createSubPanel(String label, String value){
        JPanel subPanel = new JPanel();

        return subPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
