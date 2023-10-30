package entity;

import java.util.List;
import java.util.Map;

public class NormalPlayerStats implements PlayerStats{
    private Matches recentMatches;

    @Override
    public Map<String, List<Float>> getKDAOvertime() {
        return null;
    }

    @Override
    public Map<String, Integer> getDamageOvertime() {
        return null;
    }

    @Override
    public Map<String, Integer> getGoldOvertime() {
        return null;
    }

    @Override
    public Map<String, Integer> getCSOvertime() {
        return null;
    }
}
