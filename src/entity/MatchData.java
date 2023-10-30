package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MatchData implements Match {

    private String matchid;

    MatchData(String matchid, String opponentuserid, String gamemode, Long gameduration) {
        this.matchid = matchid;
        this.opponentuserid = opponentuserid;
        this.gamemode = gamemode;
        this.gameduration = gameduration;
    }

    @Override
    public String getMatchID() {
        return null;
    }

    private final List<String> teamMateUserID = new ArrayList<>() {
    };

    private String opponentuserid;

    private final Map<String, List<Float>> kda = new HashMap<>() {
    };

    private final Map<String, String> champions = new HashMap<>();

    private final Map<String, Integer> gold = new HashMap<>();

    private final Map<String, Integer> damagetaken = new HashMap<>();

    private String gamemode;

    private Long gameduration;

    private final Map<String, Integer> level = new HashMap<>();

    private final Map<String, Integer> cs = new HashMap<>();
}


