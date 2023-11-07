package use_case.login;

public class LoginInputdata {
    final private String playerID;

    public LoginInputdata(String playerID) {
        this.playerID = playerID;
    }

    String getPlayerID() {
        return playerID;
    }

}
