package use_case.update;

import entity.Match;
import entity.Matches;

import java.util.ArrayList;

public interface UpdateDataAccessInterface {

    public void plotStats(String stat1, String stat2, String stat3, String stat4, String stat5);


    public void updateMatchesFile(String puuid);

    public Matches getMatches();

}
