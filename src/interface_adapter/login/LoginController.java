package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputdata;

public class LoginController {

    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void execute(String playerID) {
        LoginInputdata loginInputData = new LoginInputdata(playerID);
        loginUseCaseInteractor.execute(loginInputData);
    }
}
