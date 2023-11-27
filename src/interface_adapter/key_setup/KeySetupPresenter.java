package interface_adapter.key_setup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LogInViewModel;
import use_case.key_setup.KeySetupOutputBoundary;

public class KeySetupPresenter implements KeySetupOutputBoundary {
    private KeySetupViewModel keySetupViewModel;

    private LogInViewModel logInViewModel;
    private ViewManagerModel viewManagerModel;

    public KeySetupPresenter(KeySetupViewModel keySetupViewModel, ViewManagerModel viewManagerModel,
                             LogInViewModel logInViewModel){
        this.keySetupViewModel = keySetupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.logInViewModel = logInViewModel;
    }

    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(logInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        KeySetupState keySetupState = keySetupViewModel.getState();
        keySetupState.setKeyError("Invalid Key");
        keySetupViewModel.firePropertyChanged();
    }
}
