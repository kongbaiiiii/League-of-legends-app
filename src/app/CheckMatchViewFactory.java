package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.check_match.CheckMatchViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.return_mainpage.ReturnMainController;
import interface_adapter.return_mainpage.ReturnMainPresenter;
import use_case.return_mainpage.ReturnMainInputBoundary;
import use_case.return_mainpage.ReturnMainInteractor;
import use_case.return_mainpage.ReturnMainOutputBoundary;
import view.CheckMatchView;

public class CheckMatchViewFactory {

    public static CheckMatchView create(ViewManagerModel viewManagerModel, CheckMatchViewModel checkMatchViewModel,
                                        LoggedInViewModel loggedInViewModel){
        ReturnMainController returnMainController = createReturnMainUseCase(viewManagerModel, loggedInViewModel);
        return new CheckMatchView(checkMatchViewModel, returnMainController, loggedInViewModel);
    }

    private static ReturnMainController createReturnMainUseCase(ViewManagerModel viewManagerModel,
                                                                LoggedInViewModel loggedInViewModel){
        ReturnMainOutputBoundary returnMainOutputBoundary = new ReturnMainPresenter(loggedInViewModel, viewManagerModel);
        ReturnMainInputBoundary returnMianInteractor = new ReturnMainInteractor(returnMainOutputBoundary);

        return new ReturnMainController(returnMianInteractor);
    }
}
