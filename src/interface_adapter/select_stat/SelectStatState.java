package interface_adapter.select_stat;

import interface_adapter.logged_in.LoggedInState;

public class SelectStatState {
    private String playerID = "";

    public SelectStatState(SelectStatState copy) {
        playerID = copy.playerID;
    }

    public SelectStatState() {}

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }
}
