package interface_adapter.apply_stats;

import use_case.ApplyStats.ApplyStatsOutputBoundary;
import use_case.ApplyStats.ApplyStatsOutputData;

public class ApplyStatsPresenter implements ApplyStatsOutputBoundary {
    private final ApplyStatsViewModel applyStatsViewModel;

    public ApplyStatsPresenter(ApplyStatsViewModel applyStatsViewModel) {
        this.applyStatsViewModel = applyStatsViewModel;
    }

    @Override
    public void prepareSuccessView(ApplyStatsOutputData applyStatsOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
