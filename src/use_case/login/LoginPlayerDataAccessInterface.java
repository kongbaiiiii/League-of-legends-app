package use_case.login;

import entity.Player;

public interface LoginPlayerDataAccessInterface {
    boolean validPlayerID(String playerID);

    void save(Player player);

    String getPuuid(String playerID);

}
