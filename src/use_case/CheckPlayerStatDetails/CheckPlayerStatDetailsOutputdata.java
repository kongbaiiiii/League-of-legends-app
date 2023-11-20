package use_case.CheckPlayerStatDetails;

import entity.PlayerStats;

import java.util.List;

public class CheckPlayerStatDetailsOutputdata {
    private final String playerStats;

    public CheckPlayerStatDetailsOutputdata(String playerStats) {
        this.playerStats = playerStats;
    }

    public List<PlayerStats> getPlayerStats() {
        return playerStats;
    }
}
