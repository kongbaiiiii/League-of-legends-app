package data_access;

import entity.*;

import java.io.IOException;

public class AllPurposeDataAccessObject {
    PlayerDataAccessObject playerDataAccessObject;

    MatchDataAccessObject matchDataAccessObject;

    StatPlotDataAccessObject statPlotDataAccessObject;
    public AllPurposeDataAccessObject(String matchFilePath, MatchFactory matchFactory,
                                      MatchesFactory matchesFactory, String playerCSVPath,
                                      PlayerFactory playerFactory) throws IOException {
    this.playerDataAccessObject = new PlayerDataAccessObject(playerCSVPath, playerFactory);
    this.matchDataAccessObject = new MatchDataAccessObject(matchFilePath, matchFactory, matchesFactory);
    Matches matches = matchDataAccessObject.getMatches();
    Player player = playerDataAccessObject.getPlayer();
    this.statPlotDataAccessObject = new StatPlotDataAccessObject(matches, player);
    }
}
