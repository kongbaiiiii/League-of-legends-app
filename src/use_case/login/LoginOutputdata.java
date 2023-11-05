package use_case.login;

public class LoginOutputdata {
    private final String playerID;

    private boolean useCaseFailed;

    public LoginOutputdata(String playerID, boolean useCaseFailed) {
        this.playerID = playerID;
        this.useCaseFailed = useCaseFailed;
    }

    String getPlayerID() {
        return playerID;
    }

}
