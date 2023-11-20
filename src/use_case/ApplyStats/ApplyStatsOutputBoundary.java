package use_case.ApplyStats;

import entity.PlayerStats;

public interface ApplyStatsOutputBoundary {
    void prepareSuccessView(PlayerStats graphdata);

    void prepareFailView(String error);
}
