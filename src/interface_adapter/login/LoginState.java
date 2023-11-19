package interface_adapter.login;

public class LoginState {
    private String playerID = "";
    private String playerIDError = null;

    public LoginState(LoginState copy) {
        playerID=copy.playerID;
        playerIDError=copy.playerIDError;
    }

    public LoginState() {}

    public String getPlayerID() {
        return playerID;
    }

    public String getPlayerIDError() {
        return playerIDError;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public void setPlayerIDError(String playerIDError) {
        this.playerIDError = playerIDError;
    }

}
