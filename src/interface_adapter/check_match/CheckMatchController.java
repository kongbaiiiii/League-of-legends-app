package interface_adapter.check_match;

import use_case.CheckMatch.CheckMatchInputBoundary;
import use_case.CheckMatch.CheckMatchInputData;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckMatchController {
    final CheckMatchInputBoundary CheckMatchUseCaseInteractor;
    public CheckMatchController(CheckMatchInputBoundary CheckMatchUseCaseInteractor){
        this.CheckMatchUseCaseInteractor = CheckMatchUseCaseInteractor;
    }

    public void execute(String matchId){
        CheckMatchInputData checkMatchInputData = new CheckMatchInputData(matchId);
        CheckMatchUseCaseInteractor.execute(checkMatchInputData);}
}
