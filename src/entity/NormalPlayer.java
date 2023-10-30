package entity;

public class NormalPlayer implements Player {
    private final String userid;
    private final String puuid;

    public NormalPlayer(String userid, String puuid) {
        this.userid = userid;
        this.puuid = puuid;
    }

    @Override
    public String getUserID() {
        return userid;
    }

    @Override
    public String getPuuiD() {
        return puuid;
    }
}
