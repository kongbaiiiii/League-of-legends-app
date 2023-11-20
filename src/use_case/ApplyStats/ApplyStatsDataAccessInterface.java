package use_case.ApplyStats;

import entity.PlayerStats;

import java.util.List;

public interface ApplyStatsDataAccessInterface {
    List<PlayerStats> getPlayerSelectedStats();
}
