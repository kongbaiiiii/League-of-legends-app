package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MatchData implements Match {

    private String matchid;

    MatchData(String matchid, List<String> teamMateUserID,Map<String, List<Float>> kda, Map<String, String> champions, Map<String, Integer> damagedealt, Map<String, Integer> gold, Map<String, Integer> damagetaken, String gamemode, Long gameduration, Map<String, Integer> level, Map<String, Integer> cs) {
        this.matchid = matchid;
        this.teamMateUserID = teamMateUserID;
        this.kda = kda;
        this.champions = champions;
        this.damagedealt = damagedealt;
        this.gold = gold;
        this.damagetaken = damagetaken;
        this.gamemode = gamemode;
        this.gameduration = gameduration;
        this.level = level;
        this.cs = cs;
    }

    @Override
    public String getMatchID() {
        return null;
    }

    private List<String> teamMateUserID = new ArrayList<>();

    private final List<String> opponentuserid = new ArrayList<>();

    private Map<String, List<Float>> kda = new HashMap<>();

    private Map<String, String> champions = new HashMap<>();

    private Map<String, Integer> damagedealt = new HashMap<>();

    private Map<String, Integer> gold = new HashMap<>();

    private Map<String, Integer> damagetaken = new HashMap<>();

    private String gamemode;

    private Long gameduration;

    private Map<String, Integer> level = new HashMap<>();

    private Map<String, Integer> cs = new HashMap<>();
}


