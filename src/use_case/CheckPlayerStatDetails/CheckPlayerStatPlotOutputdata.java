package use_case.CheckPlayerStatDetails;

public class CheckPlayerStatPlotOutputdata {
    private final String playerId;

    public CheckPlayerStatPlotOutputdata(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
