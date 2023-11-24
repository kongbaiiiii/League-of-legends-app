package interface_adapter.return_mainpage;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.return_mainpage.ReturnMainDataOutputBoundary;

public class ReturnMainPresenter implements ReturnMainDataOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public ReturnMainPresenter(LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel){
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
