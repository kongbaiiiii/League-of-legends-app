package entity;

import java.util.List;
import java.util.Map;

public interface PlayerStats {
    Map<String, List<Float>> getKDAOvertime();

    Map<String, Integer> getDamageOvertime();

    Map<String, Integer> getGoldOvertime();

    Map<String, Integer> getCSOvertime();

}
