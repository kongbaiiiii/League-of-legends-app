import data_access.MatchDataAccessObject;
import data_access.PlayerDataAccessObject;
//import data_access.StatPlotDataAccessObject;
import data_access.StatPlotDataAccessObject;
import entity.*;

import java.io.IOException;


public class test {
    public static void main(String[] args) throws IOException {
        PlayerFactory playerFactory = new NormalPlayerFactory();
        PlayerDataAccessObject playerDataAccessObject = new PlayerDataAccessObject("player.csv", playerFactory);
        String playerpuuid = playerDataAccessObject.getPuuid("wrnmbb");
        Player player = playerFactory.create("wrnmbb", playerpuuid);

        MatchFactory matchFactory = new NormalMatchFactory();
        MatchesFactory matchesFactory = new NormalMatchesFactory();

        MatchDataAccessObject matchDataAccessObject = new MatchDataAccessObject("matchdata.csv", matchFactory, matchesFactory);

        Matches matches = matchesFactory.create(matchDataAccessObject.getMatchesList());
        StatPlotDataAccessObject statPlotDataAccessObject = new StatPlotDataAccessObject(matches, player);
        statPlotDataAccessObject.plotStats("totalMinionsKilled", "goldEarned", "assists", "kills", "deaths");


    }
}