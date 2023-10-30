package entity;

import java.util.*;

public class MatchesData implements Matches{
    private Map<String,Match> matches = new HashMap<>();

    public MatchesData(List<Match> matches) {
        for (Match match:matches){
            this.matches.put(match.getMatchID(),match);
        }
    }

    @Override
    public List<Match> getAllMatches() {
        return (List<Match>) matches.values();
    }

    @Override
    public Match getMatchByID(String matchid) {
        return matches.get(matchid);
    }
}
