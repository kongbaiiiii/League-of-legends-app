package interface_adapter.logged_in;

import java.util.ArrayList;

public class LoggedInState {
    private String playerID = "";

    ArrayList<Long> assistsList = new ArrayList<Long>();
    ArrayList<Long> deathsList = new ArrayList<Long>();
    ArrayList<Long> killsList = new ArrayList<Long>();

    ArrayList<Long> item0List = new ArrayList<Long>();
    ArrayList<Long> item1List = new ArrayList<Long>();
    ArrayList<Long> item2List = new ArrayList<Long>();
    ArrayList<Long> item3List = new ArrayList<Long>();
    ArrayList<Long> item4List = new ArrayList<Long>();
    ArrayList<Long> item5List = new ArrayList<Long>();
    ArrayList<Long> item6List = new ArrayList<Long>();

    ArrayList<String> championIdList = new ArrayList<String>();

    ArrayList<Boolean> winList = new ArrayList<Boolean>();

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

    public void setItem0List(ArrayList<Long> item0List) {
        this.item0List = item0List;
    }

    public ArrayList<Long> getItem0List() {
        return item0List;
    }

    public void setItem1List(ArrayList<Long> item1List) {
        this.item1List = item1List;
    }

    public ArrayList<Long> getItem1List() {
        return item1List;
    }

    public void setItem2List(ArrayList<Long> item2List) {
        this.item2List = item2List;
    }

    public ArrayList<Long> getItem2List() {
        return item2List;
    }


    public void setItem3List(ArrayList<Long> item3List) {
        this.item3List = item3List;
    }

    public ArrayList<Long> getItem3List() {
        return item3List;
    }

    public void setItem4List(ArrayList<Long> item4List) {
        this.item4List = item4List;
    }

    public ArrayList<Long> getItem4List() {
        return item4List;
    }

    public void setItem5List(ArrayList<Long> item5List) {
        this.item5List = item5List;
    }

    public ArrayList<Long> getItem5List() {
        return item5List;
    }

    public void setItem6List(ArrayList<Long> item6List) {
        this.item6List = item6List;
    }

    public ArrayList<Long> getItem6List() {
        return item6List;
    }
}

