//package interface_adapter.logout;
//
//import interface_adapter.ViewManagerModel;
//import interface_adapter.logged_in.LoggedInViewModel;
//import interface_adapter.login.LoginState;
//import interface_adapter.login.LoginViewModel;
//import use_case.logout.LogoutOutputBoundary;
//
//public class LogoutPresenter implements LogoutOutputBoundary {
//
//    private final ViewManagerModel viewManagerModel;
//
//    private final LoginViewModel loginViewModel;
//
//    private final keySetUpViewModel keySetUpViewModel;
//
//    public LogoutPresenter(, ViewManagerModel viewManagerModel, LoginViewModel loginViewModel) {
//        this.viewManagerModel = viewManagerModel;
//        this.loginViewModel = loginViewModel;
//    }
//
//    @Override
//    public void prepareSuccessView() {
//        LoginState state = loginViewModel.getState();
//        state.setPlayerID("");
//        state.setPlayerIDError(null);
//        loginViewModel.setState(state);
//        loginViewModel.firePropertyChanged();
//
//        viewManagerModel.setActiveView(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//
//    }
//}
