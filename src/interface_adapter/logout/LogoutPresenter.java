package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.key_setup.KeySetupState;
import interface_adapter.key_setup.KeySetupViewModel;
import interface_adapter.login.LogInViewModel;
import use_case.logout.LogoutOutputBoundary;

import javax.swing.*;
import java.security.Key;

public class LogoutPresenter implements LogoutOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    private final LogInViewModel loginViewModel;

    private final KeySetupViewModel keySetUpViewModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel, LogInViewModel loginViewModel, KeySetupViewModel keySetupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.keySetUpViewModel = keySetupViewModel;
    }

    @Override
    public void prepareSuccessView() {
//        LoginState state = loginViewModel.getState();
//        state.setPlayerID("");
//        state.setPlayerIDError(null);
//        loginViewModel.setState(state);
//        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
        KeySetupState state = keySetUpViewModel.getState();
        state.setKeyError(error);
        keySetUpViewModel.setState(state);
        keySetUpViewModel.firePropertyChanged();
        System.out.println("key error");
    }
}
