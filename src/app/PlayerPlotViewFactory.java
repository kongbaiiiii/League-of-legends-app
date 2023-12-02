package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.return_mainpage.ReturnMainController;
import interface_adapter.return_mainpage.ReturnMainPresenter;
import interface_adapter.select_stat.SelectStatController;
import interface_adapter.select_stat.SelectStatPresenter;
import interface_adapter.select_stat.SelectStatViewModel;
import use_case.return_mainpage.ReturnMainInputBoundary;
import use_case.return_mainpage.ReturnMainInteractor;
import use_case.return_mainpage.ReturnMainOutputBoundary;
import use_case.select_stat.SelectStatInputBoundary;
import use_case.select_stat.SelectStatInteractor;
import use_case.select_stat.SelectStatOutputBoundary;
import view.PlayerPlotView;
import interface_adapter.logged_in.LoggedInViewModel;

public class PlayerPlotViewFactory {

    public static PlayerPlotView create(ViewManagerModel viewManagerModel, CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel, LoggedInViewModel loggedInViewModel, SelectStatViewModel selectStatViewModel){
        ReturnMainController returnMainController = createReturnMainUseCase(viewManagerModel, loggedInViewModel);
        SelectStatController selectStatController = createSelectStateUseCase(viewManagerModel, selectStatViewModel);
        return new PlayerPlotView(selectStatController, checkPlayerStatDetailsViewModel, returnMainController);
    }

    private static ReturnMainController createReturnMainUseCase(ViewManagerModel viewManagerModel,
                                                                LoggedInViewModel loggedInViewModel){
        ReturnMainOutputBoundary returnMainOutputBoundary = new ReturnMainPresenter(loggedInViewModel, viewManagerModel);
        ReturnMainInputBoundary returnMainInteractor = new ReturnMainInteractor(returnMainOutputBoundary);

        return new ReturnMainController(returnMainInteractor);
    }

    private static SelectStatController createSelectStateUseCase(ViewManagerModel viewManagerModel, SelectStatViewModel selectStatViewModel){

        SelectStatOutputBoundary selectStatPresenter = new SelectStatPresenter(selectStatViewModel, viewManagerModel);
        SelectStatInputBoundary selectStatInteractor = new SelectStatInteractor(selectStatPresenter);
        return new SelectStatController(selectStatInteractor);
    }
}