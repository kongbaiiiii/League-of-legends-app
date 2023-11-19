package use_case.CheckPlayerStatDetails;
import data_access.PlayerDataAccessObject;
import entity.PlayerFactory;

import java.util.List;

public class CheckPlayerStatDetailsInteractor {
    final CheckPlayerStatDetailsOutputBoundary playerStatDetailsPresenter;
    final PlayerDataAccessObject playerStatDetailsDataAccessObject;
    final PlayerFactory playerStatDetailsFactory;
    final String playerId;

    public CheckPlayerStatDetailsInteractor(String playerId, CheckPlayerStatDetailsOutputBoundary playerStatDetailsPresenter,
                                            PlayerDataAccessObject playerStatDetailsDataAccessObject,
                                            PlayerFactory playerStatDetailsFactory) {
        this.playerStatDetailsPresenter = playerStatDetailsPresenter;
        this.playerId = playerId;
        this.playerStatDetailsDataAccessObject = playerStatDetailsDataAccessObject;
        this.playerStatDetailsFactory = playerStatDetailsFactory;
    }

    public void execute() {
        String playerStats = playerStatDetailsDataAccessObject.getPuuid(playerId);
        CheckPlayerStatDetailsOutputdata checkPlayerStatDetailsOutputData = new CheckPlayerStatDetailsOutputdata(playerStats);
        playerStatDetailsPresenter.prepareSuccessView();
    }
}

