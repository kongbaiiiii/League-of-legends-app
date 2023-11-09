package entity;

import java.util.ArrayList;

public class NormalMatchFactory implements MatchFactory {
    @Override
    public Match create(ArrayList<String> puuidList, ArrayList<String> summonerNameList,
                        ArrayList<Long> assistsList, ArrayList<Long> deathsList,
                        ArrayList<Long> killsList, ArrayList<String> championIdList,
                        ArrayList<String> championNameList, ArrayList<Long> item0List,
                        ArrayList<Long> item1List, ArrayList<Long> item2List,
                        ArrayList<Long> item3List, ArrayList<Long> item4List,
                        ArrayList<Long> item5List, ArrayList<Long> item6List,
                        ArrayList<Long> totalDamageDealtList, ArrayList<Long> totalDamageTakenList,
                        ArrayList<Long> levelList, ArrayList<Long> csList, ArrayList<Boolean> winList,
                        String matchId, ArrayList<Double> kdaList,
                        ArrayList<Long> goldEarnedList, String gamemode) {
        return new MatchData(puuidList, summonerNameList, assistsList, deathsList,
                killsList, championIdList, championNameList, item0List, item1List, item2List,
                item3List, item4List, item5List, item6List, totalDamageDealtList, totalDamageTakenList,
                levelList, csList, winList, matchId, kdaList, goldEarnedList, gamemode);
    }
}
