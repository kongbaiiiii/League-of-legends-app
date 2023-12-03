package interface_adapter.logged_in;

import javax.swing.*;
import java.util.ArrayList;

public class LoggedInState {
    private String playerID = "";

    ArrayList<Long> assistsList = new ArrayList<Long>();
    ArrayList<Long> deathsList = new ArrayList<Long>();
    ArrayList<Long> killsList = new ArrayList<Long>();

    ArrayList<String> championIdList = new ArrayList<String>();

    ArrayList<Boolean> winList = new ArrayList<Boolean>();

    ArrayList<String> matchIDList = new ArrayList<String>();

    public LoggedInState(LoggedInState copy) {
        playerID = copy.playerID;
    }

    public LoggedInState() {}

    public String getPlayerID() {
        return playerID;
    }
    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public void setAssistsList(ArrayList<Long> assistsList){
        this.assistsList = assistsList;
    }

    public ArrayList<Long> getAssistsList() {
        return assistsList;
    }

    public void setDeathsList(ArrayList<Long> deathsList) {
        this.deathsList = deathsList;
    }

    public ArrayList<Long> getDeathsList() {
        return deathsList;
    }

    public void setKillsList(ArrayList<Long> killsList) {
        this.killsList = killsList;
    }

    public ArrayList<Long> getKillsList() {
        return killsList;
    }

    public void setWinList(ArrayList<Boolean> winList) {
        this.winList = winList;
    }

    public ArrayList<Boolean> getWinList() {
        return winList;
    }

    public void setChampionIdList(ArrayList<String> championIdList) {
        this.championIdList = championIdList;
    }

    public ArrayList<String> getChampionIdList() {
        return championIdList;
    }

    public void setMatchIDList(ArrayList<String> matchIDList) {
        this.matchIDList = matchIDList;
    }

    public ArrayList<String> getMatchIDList() {
        return matchIDList;
    }
}

