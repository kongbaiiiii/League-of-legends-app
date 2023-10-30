package entity;

import java.util.List;

public interface Matches {
    List<Match> getAllMatches();

    Match getMatchByID(String matchid);
}
