package app;

import entity.NormalPlayerFactory;
import entity.PlayerFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LogInViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginPlayerDataAccessInterface;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LogInViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel,
            LoginPlayerDataAccessInterface playerDataAccessObject) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, loggedInViewModel, playerDataAccessObject);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LogInViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel,
            LoginPlayerDataAccessInterface playerDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);

        PlayerFactory playerFactory = new NormalPlayerFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(playerDataAccessObject, loginOutputBoundary,playerFactory);

        return new LoginController(loginInteractor);
    }
}
