package interface_adapter.check_player_stat_details;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputBoundary;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputdata;

public class CheckPlayerStatDetailsPresenter implements CheckPlayerStatPlotOutputBoundary {
    private final CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public CheckPlayerStatDetailsPresenter(CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel){
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.checkPlayerStatDetailsViewModel = checkPlayerStatDetailsViewModel;
    }


    @Override
    public void prepareSuccessView(CheckPlayerStatPlotOutputdata checkPlayerStatPlotOutputdata) {
        this.viewManagerModel.setActiveView(checkPlayerStatDetailsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        checkPlayerStatDetailsViewModel.setError(error);
        checkPlayerStatDetailsViewModel.setSuccess(false);
    }
}
