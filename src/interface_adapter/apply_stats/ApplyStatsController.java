package interface_adapter.apply_stats;

import use_case.ApplyStats.ApplyStatsInputBoundary;
import java.util.List;

public class ApplyStatsController {
    private final ApplyStatsInputBoundary applyStatsInteractor;

    public ApplyStatsController(ApplyStatsInputBoundary applyStatsInteractor) {
        this.applyStatsInteractor = applyStatsInteractor;
    }
    public void execute(List<String> selectedStats) {
        applyStatsInteractor.execute(selectedStats);
    }
}
