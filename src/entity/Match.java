package entity;

import java.util.Map;

public interface Match {

    public String getMatchID();

    public Map<String, Object> getDataByPlayerIndex(int i);

    public int getPlayerIndexByPlayerID(String PlayerID);
}
