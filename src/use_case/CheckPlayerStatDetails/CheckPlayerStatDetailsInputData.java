package use_case.CheckPlayerStatDetails;

public class CheckPlayerStatDetailsInputData {
    private final String playerId;

    public CheckPlayerStatDetailsInputData(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

}
