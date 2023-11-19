package interface_adapter.logged_in;

public class LoggedInState {
    private String playerID = "";

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
}

