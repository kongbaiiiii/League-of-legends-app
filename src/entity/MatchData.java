package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class MatchData implements Match {

    private final ArrayList<String> puuidList;

    private final ArrayList<String> summonerNameList;

    private final ArrayList<Long> assistsList;

    private final ArrayList<Long> deathsList;
    private final ArrayList<Long> killsList;
    private final ArrayList<Long> kdaList;
    private final ArrayList<String> championIdList;

    private final ArrayList<String> championNameList;

    private final ArrayList<Long> item0List;

    private final ArrayList<Long> item1List;

    private final ArrayList<Long> item2List;

    private final ArrayList<Long> item3List;

    private final ArrayList<Long> item4List;

    private final ArrayList<Long> item5List;

    private final ArrayList<Long> item6List;

    private final ArrayList<Long> totalDamageDealtList;

    private final ArrayList<Long> goldEarnedList;

    private final ArrayList<Long> totalDamageTakenList;
    private final ArrayList<Long> levelList;
    private final ArrayList<Long> csList;
    private final ArrayList<Boolean> winList;
    private String matchid;
    private final ArrayList<Long> gameStartTimestampList;
    private String gamemode;

    MatchData(ArrayList<String> puuidList, ArrayList<String> summonerNameList,
              ArrayList<Long> assistsList, ArrayList<Long> deathsList,
              ArrayList<Long> killsList, ArrayList<String> championIdList,
              ArrayList<String> championNameList, ArrayList<Long> item0List,
              ArrayList<Long> item1List, ArrayList<Long> item2List,
              ArrayList<Long> item3List, ArrayList<Long> item4List,
              ArrayList<Long> item5List, ArrayList<Long> item6List,
              ArrayList<Long> totalDamageDealtList, ArrayList<Long> totalDamageTakenList,
              ArrayList<Long> levelList, ArrayList<Long> csList, ArrayList<Boolean> winList,
              String matchid, ArrayList<Long> kdaList,
              ArrayList<Long> goldEarnedList, String gamemode,
              ArrayList<Long> gameStartTimestampList) {
        this.puuidList = puuidList;
        this.summonerNameList = summonerNameList;
        this.championIdList = championIdList;
        this.championNameList = championNameList;
        this.item0List = item0List;
        this.item1List = item1List;
        this.item2List = item2List;
        this.item3List = item3List;
        this.item4List = item4List;
        this.item5List = item5List;
        this.item6List = item6List;
        this.totalDamageDealtList = totalDamageDealtList;
        this.totalDamageTakenList = totalDamageTakenList;
        this.levelList = levelList;
        this.csList = csList;
        this.winList = winList;
        this.goldEarnedList = goldEarnedList;
        this.assistsList = assistsList;
        this.deathsList = deathsList;
        this.killsList = killsList;
        this.kdaList = kdaList;
        this.gameStartTimestampList = gameStartTimestampList;
        this.gamemode = gamemode;
        this.matchid = matchid;


    }

    public int getPlayerIndexByPlayerID(String PlayerID) {
        for (int i = 0; i < summonerNameList.size(); i++) {
            if (Objects.equals(PlayerID, summonerNameList.get(i))) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public String getMatchID() {

        return matchid;
    }

    @Override
    public Map<String, Object> getDataByPlayerIndex(int i) {
        Map<String, Object> Data = new HashMap<>();
        Data.put("puuid", puuidList.get(i));
        Data.put("summonerName", summonerNameList.get(i));
        Data.put("championId", championIdList.get(i));
        Data.put("championName", championNameList.get(i));
        Data.put("item0", item0List.get(i));
        Data.put("item1", item1List.get(i));
        Data.put("item2", item2List.get(i));
        Data.put("item3", item3List.get(i));
        Data.put("item4", item4List.get(i));
        Data.put("item5", item5List.get(i));
        Data.put("item6", item6List.get(i));
        Data.put("totalDamageDealt", totalDamageDealtList.get(i));
        Data.put("totalDamageTaken", totalDamageTakenList.get(i));
        Data.put("level", levelList.get(i));
        Data.put("cs", csList.get(i));
        Data.put("win", winList.get(i));
        Data.put("goldEarned", goldEarnedList.get(i));
        Data.put("assists", assistsList.get(i));
        Data.put("deaths", deathsList.get(i));
        Data.put("kills", killsList.get(i));
        Data.put("kda", kdaList.get(i));
        Data.put("gameStartTimestamp", gameStartTimestampList.get(i));
        Data.put("gamemode", gamemode);
        return Data;
    }
}



