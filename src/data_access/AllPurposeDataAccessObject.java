package data_access;

import entity.*;
import use_case.Apply_Selection.ApplySelectionDataAccessInterface;
import use_case.update.UpdateDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;

public class AllPurposeDataAccessObject implements UpdateDataAccessInterface, ApplySelectionDataAccessInterface {
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

    @Override
    public void plotStats(String stat1, String stat2, String stat3, String stat4, String stat5) {
        statPlotDataAccessObject.plotStats(stat1, stat2, stat3, stat4, stat5);
    }


    @Override
    public void updateMatchesFile(String puuid) {
        matchDataAccessObject.updateMatchesFile(puuid);
    }

    @Override
    public Matches getMatches() {
        return matchDataAccessObject.getMatches();
    }

    @Override
    public String getPuuid(String playerID) {
        return playerDataAccessObject.getPuuid(playerID);
    }

    public void updateStatPlotDataAccessObject(){
        Matches matches = matchDataAccessObject.getMatches();
        Player player = playerDataAccessObject.getPlayer();
        this.statPlotDataAccessObject = new StatPlotDataAccessObject(matches, player);
    }
}

