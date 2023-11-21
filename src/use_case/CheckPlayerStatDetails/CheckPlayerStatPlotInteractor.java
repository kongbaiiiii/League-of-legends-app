package use_case.CheckPlayerStatDetails;

public class CheckPlayerStatPlotInteractor {
    final CheckPlayerStatPlotOutputBoundary playerStatDetailsPresenter;

    public CheckPlayerStatPlotInteractor(String playerId, CheckPlayerStatPlotOutputBoundary playerStatDetailsPresenter) {
        this.playerStatDetailsPresenter = playerStatDetailsPresenter;
    }

    public void execute() {
        playerStatDetailsPresenter.prepareSuccessView();
    }
}

