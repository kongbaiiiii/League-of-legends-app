package use_case.CheckMatch;

import data_access.MatchDataAccessObject;
import entity.Match;
import entity.MatchFactory;


public class CheckMatchInteractor implements CheckMatchInputBoundary {
    final CheckMatchOutputBoundary matchPresenter;
    final MatchDataAccessObject matchDataAccessObject;
    final MatchFactory matchFactory;

    public CheckMatchInteractor( CheckMatchOutputBoundary matchPresenter,
                                MatchDataAccessObject matchDataAccessObject, MatchFactory matchFactory){
        this.matchPresenter = matchPresenter;
        this.matchDataAccessObject = matchDataAccessObject;
        this.matchFactory = matchFactory;
    }

    @Override
    public void execute(String matchId){
        Match match = matchDataAccessObject.getMatch(matchId);
        CheckMatchOutputdata checkMatchOutputdata = new CheckMatchOutputdata(match);
        matchPresenter.prepareSuccessView();

    }
}
