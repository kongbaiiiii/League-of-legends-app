package use_case.ApplyStats;

public interface ApplyStatsOutputBoundary {
    void prepareSuccessView(ApplyStatsOutputData applyStatsOutputData);

    void prepareFailView(String error);
}
