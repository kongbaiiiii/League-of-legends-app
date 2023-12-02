package use_case.CheckPlayerStatDetails;

public class CheckPlayerStatPlotInteractor implements CheckPlayerStatPlotInputBoundary{
    final CheckPlayerStatPlotOutputBoundary playerStatDetailsPresenter;

    public CheckPlayerStatPlotInteractor(CheckPlayerStatPlotOutputBoundary playerStatDetailsPresenter) {
        this.playerStatDetailsPresenter = playerStatDetailsPresenter;
    }

    @Override
    public void execute(CheckPlayerStatPlotInputData checkPlayerStatPlotInputData) {
        playerStatDetailsPresenter.prepareSuccessView();
    }
}

