package interface_adapter.check_match;

import use_case.CheckMatch.CheckMatchInputBoundary;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckMatchController {
    final CheckMatchInputBoundary CheckMatchUseCaseInteractor;
    public CheckMatchController(CheckMatchInputBoundary CheckMatchUseCaseInteractor){
        this.CheckMatchUseCaseInteractor = CheckMatchUseCaseInteractor;
    }

    public void execute(){CheckMatchUseCaseInteractor.execute();}
}
