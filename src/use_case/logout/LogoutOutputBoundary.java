package use_case.logout;

import use_case.login.LoginOutputdata;

public interface LogoutOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
