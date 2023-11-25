package app;

import data_access.PlayerDataAccessObject;
import entity.MatchFactory;
import entity.NormalMatchFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.check_match.CheckMatchController;
import interface_adapter.check_match.CheckMatchPresenter;
import interface_adapter.check_match.CheckMatchViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LogInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.update.UpdateController;
import interface_adapter.update.UpdatePresenter;
import interface_adapter.update.UpdateViewModel;
import use_case.CheckMatch.CheckMatchDataAccessInterface;
import use_case.CheckMatch.CheckMatchInteractor;
import use_case.CheckMatch.CheckMatchOutputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.update.UpdateDataAccessInterface;
import use_case.update.UpdateInputBoundary;
import use_case.update.UpdateInteractor;
import use_case.update.UpdateOutputBoundary;
import view.LoggedInView;

public class LoggedInViewFactory {

    public static LoggedInView create(ViewManagerModel viewManagerModel,
                                      UpdateViewModel updateViewModel,
                                      LoggedInViewModel loggedInViewModel,
                                      LogInViewModel loginViewModel,
                                      CheckMatchViewModel checkMatchViewModel,
                                      UpdateDataAccessInterface allPurposeDataAccessObject,
                                      CheckMatchDataAccessInterface checkMatchDataAccessObject,
                                      PlayerDataAccessObject playerDataAccessObject){

        UpdateController updateController = createUpdateUseCase(viewManagerModel, updateViewModel, loggedInViewModel, allPurposeDataAccessObject);
        CheckMatchController checkMatchController = createCheckMatchUseCase(checkMatchViewModel, viewManagerModel, checkMatchDataAccessObject);
        LogoutController logoutController = createLogoutUseCase(viewManagerModel, loginViewModel, playerDataAccessObject);
        return new LoggedInView(loggedInViewModel, updateController, updateViewModel, checkMatchController, logoutController);
    }

    private static UpdateController createUpdateUseCase(ViewManagerModel viewManagerModel,
                                                        UpdateViewModel updateViewModel,
                                                        LoggedInViewModel loggedInViewModel,
                                                        UpdateDataAccessInterface allPurposeDataAccessObject){
        UpdateOutputBoundary updateOutputBoundary = new UpdatePresenter(updateViewModel, loggedInViewModel, viewManagerModel);

        UpdateInputBoundary updateInteractor = new UpdateInteractor(allPurposeDataAccessObject, updateOutputBoundary);

        return new UpdateController(updateInteractor);
    }

    private static CheckMatchController createCheckMatchUseCase(CheckMatchViewModel checkMatchViewModel, ViewManagerModel viewManagerModel, CheckMatchDataAccessInterface checkMatchDataAccessObject){

        CheckMatchOutputBoundary checkMatchOutputBoundary = new CheckMatchPresenter(checkMatchViewModel, viewManagerModel);

        MatchFactory matchFactory = new NormalMatchFactory();

        CheckMatchInteractor checkMatchInteractor = new CheckMatchInteractor(checkMatchOutputBoundary, checkMatchDataAccessObject, matchFactory);
        return new CheckMatchController(checkMatchInteractor);
    }

    private static LogoutController createLogoutUseCase(ViewManagerModel viewManagerModel, LogInViewModel loginViewModel, PlayerDataAccessObject playerDataAccessObject){
        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel, loginViewModel);
        LogoutInteractor logoutInteractor = new LogoutInteractor(playerDataAccessObject, logoutOutputBoundary);
        return new LogoutController(logoutInteractor);
    }
}
