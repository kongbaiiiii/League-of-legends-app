package interface_adapter.apply_stats;

import entity.PlayerStats;
import use_case.ApplyStats.ApplyStatsOutputBoundary;
import use_case.ApplyStats.ApplyStatsOutputData;
import interface_adapter.ViewModel;

public class ApplyStatsPresenter implements ApplyStatsOutputBoundary {
    private final ApplyStatsViewModel viewModel;

    public ApplyStatsPresenter(ApplyStatsViewModel viewModel) {
        this.viewModel = viewModel;
    }

//    @Override
//    public void updateGraph(ApplyStatsOutputData outputData) {
//        GraphViewModel graphData = convertToGraphViewModel(outputData);
//        viewModel.setGraphData(graphData);
//    }
//
//    @Override
//    public void handleFailure(String errorMessage) {
//        viewModel.setErrorMessage(errorMessage);
//    }
//
//    private GraphViewModel convertToGraphViewModel(ApplyStatsOutputData outputData) {
//        return new GraphViewModel();
//    }

    @Override
    public void prepareSuccessView(PlayerStats graphdata) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
