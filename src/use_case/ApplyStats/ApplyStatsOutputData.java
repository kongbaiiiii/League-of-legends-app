package use_case.ApplyStats;

import java.util.Map;

public class ApplyStatsOutputData {
    private final Map<String, Double> statsData;

    public ApplyStatsOutputData(Map<String, Double> statsData) {
        this.statsData = statsData;
    }

    public Map<String, Double> getStatsData() {
        return statsData;
    }
}
