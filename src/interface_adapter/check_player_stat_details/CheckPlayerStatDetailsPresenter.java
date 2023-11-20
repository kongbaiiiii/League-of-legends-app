package interface_adapter.check_player_stat_details;

import use_case.CheckPlayerStatDetails.CheckPlayerStatDetailsOutputBoundary;
import interface_adapter.ViewManagerModel;
import use_case.CheckPlayerStatDetails.CheckPlayerStatDetailsOutputdata;

public class CheckPlayerStatDetailsPresenter implements CheckPlayerStatDetailsOutputBoundary {
    private final CheckPlayerStatDetailsViewModel viewModel;

    public CheckPlayerStatDetailsPresenter(CheckPlayerStatDetailsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void prepareSuccessView(CheckPlayerStatDetailsOutputdata outputData) {
        viewModel.setPlayerStats(outputData.getPlayerStats());
        viewModel.setSuccess(true);
    }

    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailView(String error) {
        viewModel.setError(error);
        viewModel.setSuccess(false);
    }
}
