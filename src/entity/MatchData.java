package entity;

import java.util.ArrayList;

class MatchData implements Match {

    private final ArrayList<String> puuidList;

    private final ArrayList<String> summonerNameList;

    private final ArrayList<Long> assistsList;

    private final ArrayList<Long> deathsList;
    private final ArrayList<Long> killsList;
    private final ArrayList<Double> kdaList;
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
              String matchid, ArrayList<Double> kdaList,
              ArrayList<Long> goldEarnedList, String gamemode) {
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

        this.gamemode = gamemode;
        this.matchid = matchid;



    }

    @Override
    public String getMatchID() {
        return null;
    }

    @Override
    public ArrayList<Object> getDataByPlayerIndex(int i) {
        ArrayList<Object> PlayerData = new ArrayList<>();
        PlayerData.add(puuidList.get(i));
        PlayerData.add(summonerNameList.get(i));
        PlayerData.add(championIdList.get(i));
        PlayerData.add(championNameList.get(i));
        PlayerData.add(item0List.get(i));
        PlayerData.add(item1List.get(i));
        PlayerData.add(item2List.get(i));
        PlayerData.add(item3List.get(i));
        PlayerData.add(item5List.get(i));
        PlayerData.add(item6List.get(i));
        PlayerData.add(totalDamageDealtList.get(i));
        PlayerData.add(totalDamageTakenList.get(i));
        PlayerData.add(levelList.get(i));
        PlayerData.add(csList.get(i));
        PlayerData.add(winList.get(i));
        PlayerData.add(goldEarnedList.get(i));
        PlayerData.add(assistsList.get(i));
        PlayerData.add(deathsList.get(i));
        PlayerData.add(killsList.get(i));
        PlayerData.add(kdaList.get(i));

        return PlayerData;
    }


}



