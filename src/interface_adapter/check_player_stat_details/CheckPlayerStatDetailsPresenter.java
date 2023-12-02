package interface_adapter.check_player_stat_details;

import app.Main;
import app.PlayerPlotViewFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.select_stat.SelectStatController;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputBoundary;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputdata;
import view.PlayerPlotView;

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
        this.loggedInViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(checkPlayerStatDetailsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        checkPlayerStatDetailsViewModel.setError(error);
        checkPlayerStatDetailsViewModel.setSuccess(false);
    }
}
