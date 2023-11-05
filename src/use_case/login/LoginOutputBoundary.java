package use_case.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputdata player);

    void prepareFailView(String error);
}
