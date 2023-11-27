package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.key_setup.KeySetupController;
import interface_adapter.key_setup.KeySetupPresenter;
import interface_adapter.key_setup.KeySetupViewModel;
import interface_adapter.login.LogInViewModel;
import use_case.key_setup.KeySetupDataAccessInterface;
import use_case.key_setup.KeySetupInteractor;
import use_case.key_setup.KeySetupOutputBoundary;
import view.KeySetupView;

public class KeySetupUseCaseFactory {

    private KeySetupUseCaseFactory(){}

    public static KeySetupView create(LogInViewModel logInViewModel, KeySetupViewModel keySetupViewModel, ViewManagerModel viewManagerModel,
                                      KeySetupDataAccessInterface playerDataAccessObject){
        KeySetupController keySetupController = createKeySetupUseCase(keySetupViewModel, viewManagerModel, playerDataAccessObject);
        KeySetupView keySetupView = new KeySetupView(logInViewModel, keySetupViewModel, keySetupController);
        return keySetupView;
    }

    private static KeySetupController createKeySetupUseCase(KeySetupViewModel keySetupViewModel, ViewManagerModel viewManagerModel,
                                                     KeySetupDataAccessInterface playerDataAccessObject){

        KeySetupOutputBoundary keySetupOutputBoundary = new KeySetupPresenter(keySetupViewModel, viewManagerModel);

        KeySetupInteractor keySetupInteractor = new KeySetupInteractor(playerDataAccessObject, keySetupOutputBoundary);
        KeySetupController keySetupController = new KeySetupController(keySetupInteractor);
        return keySetupController;
    }
}
