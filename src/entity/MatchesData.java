package entity;

import java.util.*;

public class MatchesData implements Matches{
    private ArrayList<Match> matches = new ArrayList();

    public MatchesData(ArrayList<Match> matches) {
        this.matches = matches;
    }

    @Override
    public ArrayList<Match> getAllMatches() {
        return this.matches;
    }
}
