package use_case.CheckMatch;

import data_access.MatchDataAccessObject;
import entity.Match;
import entity.MatchFactory;


public class CheckMatchInteractor implements CheckMatchInputBoundary {
    final CheckMatchOutputBoundary matchPresenter;
    final CheckMatchDataAccessInterface matchDataAccessObject;
    final MatchFactory matchFactory;

    public CheckMatchInteractor( CheckMatchOutputBoundary matchPresenter,
                                CheckMatchDataAccessInterface matchDataAccessObject, MatchFactory matchFactory){
        this.matchPresenter = matchPresenter;
        this.matchDataAccessObject = matchDataAccessObject;
        this.matchFactory = matchFactory;
    }

    @Override
    public void execute(CheckMatchInputData checkMatchInputData){
        String matchId = checkMatchInputData.getMatchId();
        Match match = matchDataAccessObject.getMatch(matchId);
        CheckMatchOutputdata checkMatchOutputdata = new CheckMatchOutputdata(match);
        matchPresenter.prepareSuccessView(checkMatchOutputdata);
    }
}
