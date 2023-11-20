package interface_adapter.apply_stats;

import entity.PlayerStats;

import java.util.List;

public class ApplyStatsState {
    private List<String> selectedStats;
    private PlayerStats graphData;
    private String errorMessage;

    public ApplyStatsState() {
    }
    public ApplyStatsState(ApplyStatsState other) {
        this.selectedStats = other.selectedStats;
        this.graphData = other.graphData;
        this.errorMessage = other.errorMessage;
    }

    public List<String> getSelectedStats() {
        return selectedStats;
    }

    public void setSelectedStats(List<String> selectedStats) {
        this.selectedStats = selectedStats;
    }

    public PlayerStats getGraphData() {
        return graphData;
    }

    public void setGraphData(PlayerStats graphData) {
        this.graphData = graphData;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
