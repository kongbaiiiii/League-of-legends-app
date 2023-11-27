package interface_adapter.apply_stats;

import use_case.ApplyStats.ApplyStatsInputBoundary;
import use_case.ApplyStats.ApplyStatsInputData;

public class ApplyStatsController {
    private final ApplyStatsInputBoundary applyStatsInteractor;

    public ApplyStatsController(ApplyStatsInputBoundary applyStatsInteractor) {
        this.applyStatsInteractor = applyStatsInteractor;
    }
    public void execute(String stat1, String stat2, String stat3, String stat4, String stat5) {
        ApplyStatsInputData applyStatsInputData = new ApplyStatsInputData(stat1, stat2, stat3, stat4, stat5);
        applyStatsInteractor.execute(applyStatsInputData);
    }
}
