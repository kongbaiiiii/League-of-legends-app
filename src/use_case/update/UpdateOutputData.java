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

    ArrayList<Long> item0List = new ArrayList<Long>();
    ArrayList<Long> item1List = new ArrayList<Long>();
    ArrayList<Long> item2List = new ArrayList<Long>();
    ArrayList<Long> item3List = new ArrayList<Long>();
    ArrayList<Long> item4List = new ArrayList<Long>();
    ArrayList<Long> item5List = new ArrayList<Long>();
    ArrayList<Long> item6List = new ArrayList<Long>();

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
            item0List.add((Long)dataMap.get("item0"));
            item1List.add((Long)dataMap.get("item1"));
            item2List.add((Long)dataMap.get("item2"));
            item3List.add((Long)dataMap.get("item3"));
            item4List.add((Long)dataMap.get("item4"));
            item5List.add((Long)dataMap.get("item5"));
            item6List.add((Long)dataMap.get("item6"));
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


    public ArrayList<Long> getItem0List() {
        return item0List;
    }


    public ArrayList<Long> getItem1List() {
        return item1List;
    }


    public ArrayList<Long> getItem2List() {
        return item2List;
    }


    public ArrayList<Long> getItem3List() {
        return item3List;
    }


    public ArrayList<Long> getItem4List() {
        return item4List;
    }


    public ArrayList<Long> getItem5List() {
        return item5List;
    }


    public ArrayList<Long> getItem6List() {
        return item6List;
    }

    public ArrayList<String> getMatchIDList() {return matchIDList;}
}
