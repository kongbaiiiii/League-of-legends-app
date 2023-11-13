package use_case.CheckMatch;

import entity.Match;

public interface CheckMatchDataAccessInterface {
    Match getMatch(String matchId);
}
