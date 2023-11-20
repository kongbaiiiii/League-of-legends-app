package use_case.ApplyStats;

import java.util.List;

public class ApplyStatsInputData {
    private final List<String> selectedStats;

    public ApplyStatsInputData(List<String> selectedStats) {
        this.selectedStats = selectedStats;
    }

    public List<String> getSelectedStats() {
        return selectedStats;
    }
}
