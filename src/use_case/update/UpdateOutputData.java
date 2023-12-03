package use_case.update;

import entity.Match;
import entity.Matches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class UpdateOutputData {
    private final Matches matches;

    private String playerID = "";

    ArrayList<Long> assistsList = new ArrayList<Long>();
    ArrayList<Long> deathsList = new ArrayList<Long>();
    ArrayList<Long> killsList = new ArrayList<Long>();

    ArrayList<String> championIdList = new ArrayList<String>();

    ArrayList<Boolean> winList = new ArrayList<Boolean>();

    ArrayList<String> matchIDList = new ArrayList<String>();

    public UpdateOutputData(Matches matches, String playerID) {
        this.matches = matches;
        this.playerID = playerID;
        ArrayList<Match> matchArrayList = matches.getAllMatches();
        for (Match match: matchArrayList) {
            int playerIndex = match.getPlayerIndexByPlayerID(playerID);
            Map<String, Object> dataMap = match.getDataByPlayerIndex(playerIndex);
            assistsList.add((Long)dataMap.get("assists"));
            deathsList.add((Long) dataMap.get("deaths"));
            killsList.add((Long) dataMap.get("kills"));
            championIdList.add((String) dataMap.get("championId"));
            winList.add((Boolean) dataMap.get("win"));
            matchIDList.add(match.getMatchID());
        }
    }

    public Matches getMatches(){
        return this.matches;
    }

    public String getPlayerID() {
        return playerID;
    }

    public ArrayList<Long> getAssistsList() {
        return assistsList;
    }


    public ArrayList<Long> getDeathsList() {
        return deathsList;
    }


    public ArrayList<Long> getKillsList() {
        return killsList;
    }


    public ArrayList<Boolean> getWinList() {
        return winList;
    }


    public ArrayList<String> getChampionIdList() {
        return championIdList;
    }

    public ArrayList<String> getMatchIDList() {return matchIDList;}
}
