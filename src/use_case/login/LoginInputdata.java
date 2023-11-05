package use_case.login;

public class LoginInputdata {
    final private String playerID;

    final private String puuid;

    public LoginInputdata(String playerID, String puuid) {
        this.playerID = playerID;
        this.puuid = puuid;
    }

    String getPlayerID() {
        return playerID;
    }

    String getPuuid(){return puuid;}
}
