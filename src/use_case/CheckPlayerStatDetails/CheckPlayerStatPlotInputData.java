package use_case.CheckPlayerStatDetails;

public class CheckPlayerStatPlotInputData {
    private final String playerId;

    public CheckPlayerStatPlotInputData(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

}
