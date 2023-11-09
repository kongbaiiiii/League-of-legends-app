package use_case.CheckMatch;

import entity.Match;
import org.json.JSONArray;

public interface CheckMatchPlayerDataAccessInterface {
    Match getMatch(String matchId);
}
