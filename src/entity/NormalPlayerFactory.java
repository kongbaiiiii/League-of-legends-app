package entity;

public class NormalPlayerFactory implements PlayerFactory {

    @Override
    public Player create(String playerID, String puuid) {
        return new NormalPlayer(playerID, puuid);
    }
}
