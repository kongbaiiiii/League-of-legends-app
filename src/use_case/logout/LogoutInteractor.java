package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary {

    final LogoutPlayerDataAccessInterface playerDataAccessObject;

    final LogoutOutputBoundary playerPresenter;

    public LogoutInteractor(LogoutPlayerDataAccessInterface playerDataAccessObject,
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
