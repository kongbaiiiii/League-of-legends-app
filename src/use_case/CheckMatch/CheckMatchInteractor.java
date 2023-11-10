package use_case.CheckMatch;

import data_access.MatchDataAccessObject;
import entity.Match;
import entity.MatchFactory;


public class CheckMatchInteractor implements CheckMatchInputBoundary {
    final CheckMatchOutputBoundary matchPresenter;
    final MatchDataAccessObject matchDataAccessObject;
    final MatchFactory matchFactory;
    final String matchId;

    public CheckMatchInteractor(String matchId, CheckMatchOutputBoundary matchPresenter,
                                MatchDataAccessObject matchDataAccessObject, MatchFactory matchFactory){
        this.matchPresenter = matchPresenter;
        this.matchId = matchId;
        this.matchDataAccessObject = matchDataAccessObject;
        this.matchFactory = matchFactory;
    }

    @Override
    public void execute(){
        Match match = matchDataAccessObject.getMatch(matchId);
        CheckMatchOutputdata checkMatchOutputdata = new CheckMatchOutputdata(match);
        matchPresenter.prepareSuccessView();

    }
}
