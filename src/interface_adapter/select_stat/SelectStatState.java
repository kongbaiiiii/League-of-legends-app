package interface_adapter.select_stat;

import interface_adapter.logged_in.LoggedInState;

import java.util.ArrayList;

public class SelectStatState {
    private String playerID = "";

    private int numberOfSelection = 0;

    private ArrayList<String> selectionLablesList = new ArrayList<>();

    private ArrayList<String> selectionValuesList = new ArrayList<>();

    public SelectStatState(SelectStatState copy) {
        playerID = copy.playerID;
    }

    public SelectStatState() {
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public ArrayList<String> getSelectionValuesList() {
        return selectionValuesList;
    }

    public ArrayList<String> getSelectionLablesList() {
        return selectionLablesList;
    }

    public int getNumberOfSelection() {
        return numberOfSelection;
    }

    public void addSelection(String checkBoxLabel, String checkBoxValue) {
        this.selectionLablesList.add(checkBoxLabel);
        this.selectionValuesList.add(checkBoxValue);
        this.numberOfSelection++;
    }

    public void removeSelection(String checkBoxLabel, String checkBoxValue){
        this.selectionLablesList.remove(checkBoxLabel);
        this.selectionValuesList.remove(checkBoxValue);
        this.numberOfSelection--;
    }
}
