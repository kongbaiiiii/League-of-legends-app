package interface_adapter.check_match;

import app.CheckMatchViewFactory;
import app.Main;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.CheckMatch.CheckMatchOutputBoundary;
import use_case.CheckMatch.CheckMatchOutputdata;
import view.CheckMatchView;

public class CheckMatchPresenter implements CheckMatchOutputBoundary {
    private final CheckMatchViewModel checkMatchViewModel;

    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public CheckMatchPresenter(CheckMatchViewModel checkMatchViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel){
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.checkMatchViewModel = checkMatchViewModel;
    }

    @Override
    public void prepareSuccessView(CheckMatchOutputdata checkMatchOutputdata){
        CheckMatchState checkMatchState = checkMatchViewModel.getState();
        checkMatchState.setMatch(checkMatchOutputdata.getMatch());
        CheckMatchView checkMatchView = CheckMatchViewFactory.create(viewManagerModel,checkMatchViewModel,loggedInViewModel);
        Main.views.add(checkMatchView, checkMatchView.viewName);
        viewManagerModel.setActiveView(checkMatchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){

    }
}
