package use_case.logout;

public class Logoutinteractor implements LogoutInputBoundary {

    final LogoutPlayerDataAccessInterface playerDataAccessObject;

    final LogoutOutputBoundary playerPresenter;

    public Logoutinteractor(LogoutPlayerDataAccessInterface playerDataAccessObject,
                            LogoutOutputBoundary playerPresenter) {
        this.playerDataAccessObject = playerDataAccessObject;
        this.playerPresenter = playerPresenter;
    }

    @Override
    public void execute() {
        playerDataAccessObject.logout();
        playerPresenter.prepareSuccessView();
    }
}
