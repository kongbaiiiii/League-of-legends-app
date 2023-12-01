package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.select_stat.SelectStatController;
import interface_adapter.return_mainpage.ReturnMainController;
import interface_adapter.return_mainpage.ReturnMainPresenter;
import use_case.return_mainpage.ReturnMainInputBoundary;
import use_case.return_mainpage.ReturnMainInteractor;
import use_case.return_mainpage.ReturnMainOutputBoundary;
import view.PlayerPlotView;
import interface_adapter.logged_in.LoggedInViewModel;

public class PlayerPlotViewFactory {

    public static PlayerPlotView create(ViewManagerModel viewManagerModel, CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel,
                                        SelectStatController selectStatController, LoggedInViewModel loggedInViewModel){
        ReturnMainController returnMainController = createReturnMainUseCase(viewManagerModel, loggedInViewModel);
        return new PlayerPlotView(checkPlayerStatDetailsViewModel, returnMainController);
    }

    private static ReturnMainController createReturnMainUseCase(ViewManagerModel viewManagerModel,
                                                                LoggedInViewModel loggedInViewModel){
        ReturnMainOutputBoundary returnMainOutputBoundary = new ReturnMainPresenter(loggedInViewModel, viewManagerModel);
        ReturnMainInputBoundary returnMainInteractor = new ReturnMainInteractor(returnMainOutputBoundary);

        return new ReturnMainController(returnMainInteractor);
    }
}