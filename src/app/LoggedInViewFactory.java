package app;

import data_access.PlayerDataAccessObject;
import entity.MatchFactory;
import entity.NormalMatchFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.apply_selection.ApplySelectionViewModel;
import interface_adapter.check_match.CheckMatchController;
import interface_adapter.check_match.CheckMatchPresenter;
import interface_adapter.check_match.CheckMatchViewModel;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsController;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsPresenter;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.key_setup.KeySetupViewModel;
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
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotInputBoundary;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotInteractor;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputBoundary;
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
                                      CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel,
                                      CheckMatchViewModel checkMatchViewModel,
                                      UpdateDataAccessInterface allPurposeDataAccessObject,
                                      CheckMatchDataAccessInterface checkMatchDataAccessObject,
                                      PlayerDataAccessObject playerDataAccessObject,
                                      KeySetupViewModel keySetupViewModel, ApplySelectionViewModel applySelectionViewModel){

        UpdateController updateController = createUpdateUseCase(viewManagerModel, updateViewModel, loggedInViewModel, allPurposeDataAccessObject);
        CheckMatchController checkMatchController = createCheckMatchUseCase(checkMatchViewModel, viewManagerModel, checkMatchDataAccessObject, loggedInViewModel);
        LogoutController logoutController = createLogoutUseCase(viewManagerModel, loginViewModel, playerDataAccessObject, keySetupViewModel);
        CheckPlayerStatDetailsController checkPlayerStatDetailsController = createCheckPlayerStatDetailUseCase(checkPlayerStatDetailsViewModel, loggedInViewModel, viewManagerModel);
        return new LoggedInView(loggedInViewModel, updateController, updateViewModel, checkPlayerStatDetailsViewModel, checkPlayerStatDetailsController, checkMatchController, logoutController);
    }

    private static UpdateController createUpdateUseCase(ViewManagerModel viewManagerModel,
                                                        UpdateViewModel updateViewModel,
                                                        LoggedInViewModel loggedInViewModel,
                                                        UpdateDataAccessInterface allPurposeDataAccessObject){
        UpdateOutputBoundary updateOutputBoundary = new UpdatePresenter(updateViewModel, loggedInViewModel, viewManagerModel);

        UpdateInputBoundary updateInteractor = new UpdateInteractor(allPurposeDataAccessObject, updateOutputBoundary);

        return new UpdateController(updateInteractor);
    }

    private static CheckMatchController createCheckMatchUseCase(CheckMatchViewModel checkMatchViewModel, ViewManagerModel viewManagerModel, CheckMatchDataAccessInterface checkMatchDataAccessObject, LoggedInViewModel loggedInViewModel){

        CheckMatchOutputBoundary checkMatchOutputBoundary = new CheckMatchPresenter(checkMatchViewModel, loggedInViewModel, viewManagerModel);

        MatchFactory matchFactory = new NormalMatchFactory();

        CheckMatchInteractor checkMatchInteractor = new CheckMatchInteractor(checkMatchOutputBoundary, checkMatchDataAccessObject, matchFactory);
        return new CheckMatchController(checkMatchInteractor);
    }

    private static LogoutController createLogoutUseCase(ViewManagerModel viewManagerModel, LogInViewModel loginViewModel, PlayerDataAccessObject playerDataAccessObject, KeySetupViewModel keySetupViewModel){
        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel, loginViewModel, keySetupViewModel);
        LogoutInteractor logoutInteractor = new LogoutInteractor(playerDataAccessObject, logoutOutputBoundary);
        return new LogoutController(logoutInteractor);
    }

    private static CheckPlayerStatDetailsController createCheckPlayerStatDetailUseCase(CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel){
        CheckPlayerStatPlotOutputBoundary checkPlayerStatPlotOutputBoundary = new CheckPlayerStatDetailsPresenter(checkPlayerStatDetailsViewModel, loggedInViewModel, viewManagerModel);
        CheckPlayerStatPlotInputBoundary checkPlayerStatPlotInteractor = new CheckPlayerStatPlotInteractor(checkPlayerStatPlotOutputBoundary);
        return new CheckPlayerStatDetailsController(checkPlayerStatPlotInteractor);
    }
}
