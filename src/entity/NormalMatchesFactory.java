package entity;

import java.util.ArrayList;

public class NormalMatchesFactory implements MatchesFactory{

    @Override
    public Matches create(ArrayList<Match> matches) {
        return new MatchesData(matches);
    }
}
