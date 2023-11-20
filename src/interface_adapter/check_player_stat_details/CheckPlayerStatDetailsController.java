package interface_adapter.check_player_stat_details;

import use_case.CheckPlayerStatDetails.CheckPlayerStatDetailsInputBoundary;

public class CheckPlayerStatDetailsController {
    private final CheckPlayerStatDetailsInputBoundary interactor;

    public CheckPlayerStatDetailsController(CheckPlayerStatDetailsInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String playerId) {
        interactor.execute(playerId);
    }
}
