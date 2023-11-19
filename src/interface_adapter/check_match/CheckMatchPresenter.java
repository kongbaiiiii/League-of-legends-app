package interface_adapter.check_match;

import interface_adapter.ViewManagerModel;
import use_case.CheckMatch.CheckMatchOutputBoundary;

public class CheckMatchPresenter implements CheckMatchOutputBoundary {
    private final CheckMatchViewModel checkMatchViewModel;
    private ViewManagerModel viewManagerModel;

    public CheckMatchPresenter(CheckMatchViewModel checkMatchViewModel, ViewManagerModel viewManagerModel){
        this.viewManagerModel = viewManagerModel;
        this.checkMatchViewModel = checkMatchViewModel;
    }

    @Override
    public void prepareSuccessView(){
        viewManagerModel.setActiveView(checkMatchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){

    }
}
