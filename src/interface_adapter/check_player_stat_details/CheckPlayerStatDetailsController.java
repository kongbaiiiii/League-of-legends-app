package interface_adapter.check_player_stat_details;

import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotInputBoundary;

public class CheckPlayerStatDetailsController {
    private final CheckPlayerStatPlotInputBoundary interactor;

    public CheckPlayerStatDetailsController(CheckPlayerStatPlotInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String playerId) {
        interactor.execute(playerId);
    }
}
