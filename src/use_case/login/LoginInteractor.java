package use_case.login;

import entity.Player;
import entity.PlayerFactory;

public class LoginInteractor implements LoginInputBoundary{
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
        if (!playerDataAccessObject.validPlayerID(loginInputData.getPlayerID())){
            playerPresenter.prepareFailView("PlayerID not valid.");
        } else {
            Player player = playerFactory.create(loginInputData.getPlayerID(), loginInputData.getPuuid());
            playerDataAccessObject.save(player);

            LoginOutputdata loginOutputdata = new LoginOutputdata(player.getUserID(),false);
            playerPresenter.prepareSuccessView(loginOutputdata);
        }
    }
}
