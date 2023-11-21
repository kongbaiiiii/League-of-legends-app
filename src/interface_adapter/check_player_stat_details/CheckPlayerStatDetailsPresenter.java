package interface_adapter.check_player_stat_details;

import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputBoundary;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputdata;

public class CheckPlayerStatDetailsPresenter implements CheckPlayerStatPlotOutputBoundary {
    private final CheckPlayerStatDetailsViewModel viewModel;

    public CheckPlayerStatDetailsPresenter(CheckPlayerStatDetailsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void prepareSuccessView(CheckPlayerStatPlotOutputdata outputData) {
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
