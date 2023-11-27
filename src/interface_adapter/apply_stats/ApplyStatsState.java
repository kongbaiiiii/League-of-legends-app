package interface_adapter.apply_stats;

public class ApplyStatsState {
    private String errorMessage;

    public ApplyStatsState() {
    }
    public ApplyStatsState(ApplyStatsState other) {
        this.errorMessage = other.errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
