package use_case.CheckMatch;

import entity.Match;

public class CheckMatchOutputdata {
    private final Match match;
    public CheckMatchOutputdata(Match match) {
        this.match = match;
    }

    Match getMatch() {
        return match;
    }
}
