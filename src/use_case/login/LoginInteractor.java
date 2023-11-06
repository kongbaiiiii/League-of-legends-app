package use_case.login;

import entity.Player;
import entity.PlayerFactory;

public class LoginInteractor implements LoginInputBoundary {
    final LoginPlayerDataAccessInterface playerDataAccessObject;
    final LoginOutputBoundary playerPresenter;

    final PlayerFactory playerFactory;

    public LoginInteractor(LoginPlayerDataAccessInterface playerDataAccessObject,
                           LoginOutputBoundary playerPresenter,
                           PlayerFactory playerFactory) {
        this.playerDataAccessObject = playerDataAccessObject;
        this.playerPresenter = playerPresenter;
        this.playerFactory = playerFactory;
    }

    @Override
    public void execute(LoginInputdata loginInputData) {
        if (!playerDataAccessObject.validPlayerID(loginInputData.getPlayerID())) {
            playerPresenter.prepareFailView("PlayerID not valid.");
        } else {
            String puuid = playerDataAccessObject.getPuuid(loginInputData.getPlayerID());
            Player player = playerFactory.create(loginInputData.getPlayerID(), puuid);
            playerDataAccessObject.save(player);

            LoginOutputdata loginOutputdata = new LoginOutputdata(player.getPlayerID(), false);
            playerPresenter.prepareSuccessView(loginOutputdata);
        }
    }
}
