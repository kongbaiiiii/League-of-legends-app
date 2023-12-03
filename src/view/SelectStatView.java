package view;

import interface_adapter.apply_selection.ApplySelectionController;
import interface_adapter.select_stat.SelectStatViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectStatView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Select Stat View";
    final SelectStatViewModel selectStatViewModel;

    final ApplySelectionController applySelectionController;

    final JButton apply;

    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

    public SelectStatView(SelectStatViewModel selectStatViewModel, ApplySelectionController applySelectionController) {
        this.selectStatViewModel = selectStatViewModel;
        this.applySelectionController = applySelectionController;

        this.apply = new JButton(SelectStatViewModel.APPLY_STAT_BUTTON_LABEL);
        apply.setEnabled(false);

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
        this.setLayout(new GridLayout(1, 2));
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(14, 1));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
        this.add(leftPanel);
        this.add(rightPanel);

        ArrayList<String> checkBoxLabelsList = new ArrayList<>(Arrays.asList(checkBoxLabels));
        ArrayList<String> checkBoxValuesList = new ArrayList<>(Arrays.asList(checkBoxValues));
        for (int i = 0; i < 13; i++) {
            JPanel subPanel = createSubPanel(checkBoxLabelsList.get(i), checkBoxValuesList.get(i));
            leftPanel.add(subPanel);
        }

        rightPanel.add(apply);

        this.apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == apply) {
                    String playerID = selectStatViewModel.getState().getPlayerID();
                    String stat1 = selectStatViewModel.getState().getSelectionValuesList().get(0);
                    String stat2 = selectStatViewModel.getState().getSelectionValuesList().get(1);
                    String stat3 = selectStatViewModel.getState().getSelectionValuesList().get(2);
                    String stat4 = selectStatViewModel.getState().getSelectionValuesList().get(3);
                    String stat5 = selectStatViewModel.getState().getSelectionValuesList().get(4);
                    applySelectionController.execute(playerID, stat1, stat2, stat3, stat4, stat5);
                }
            }
        });
    }

    private JPanel createSubPanel(String label, String value){
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(1, 1));

        JCheckBox checkBox = new JCheckBox(label);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == checkBox){
                    if (checkBox.isSelected()){
                        selectStatViewModel.getState().addSelection(label, value);
                        disableOtherCheckBoxes();
                        enableApplyButton();
                    }else{
                        selectStatViewModel.getState().removeSelection(label, value);
                        enableOtherCheckBoxes();
                        disableApplyButton();
                    }
                }
            }
        });
        checkBoxes.add(checkBox);
        subPanel.add(checkBox);
        return subPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void disableOtherCheckBoxes(){
        if (selectStatViewModel.getState().getNumberOfSelection() == 5){
            ArrayList<String> selectedCheckBoxeLabels = selectStatViewModel.getState().getSelectionLablesList();
            for (JCheckBox checkBox: checkBoxes) {
                if (!(selectedCheckBoxeLabels.contains(checkBox.getText()))){
                    checkBox.setEnabled(false);
                }
            }
        }
    }

    public void enableOtherCheckBoxes(){
        if (selectStatViewModel.getState().getNumberOfSelection() == 4){
            for (JCheckBox checkBox: checkBoxes) {
                checkBox.setEnabled(true);
            }
        }
    }

    public void enableApplyButton(){
        if (selectStatViewModel.getState().getNumberOfSelection() == 5){
            apply.setEnabled(true);
        }
    }

    public void disableApplyButton(){
        if (selectStatViewModel.getState().getNumberOfSelection() == 4){
            apply.setEnabled(false);
        }
    }
}
