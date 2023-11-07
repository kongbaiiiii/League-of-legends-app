package use_case.CheckMatch;

import entity.Match;
import entity.MatchData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class CheckMatchInteractor implements CheckMatchInputBoundary {
    final CheckMatchOutputBoundary matchPresenter;
    final MatchDataAccessObject matchDataAccessObject;
    final String matchId;

    private final ArrayList<String> puuidList = new ArrayList<String>();

    private final ArrayList<String> summonerNameList = new ArrayList<String>();

    private final ArrayList<Long> assistsList = new ArrayList<Long>();

    private final ArrayList<Long> deathsList = new ArrayList<Long>();
    private final ArrayList<Long> killsList = new ArrayList<Long>();
    private final ArrayList<Double> kdaList = new ArrayList<Double>();
    private final ArrayList<String> championIdList = new ArrayList<String>();

    private final ArrayList<String> championNameList = new ArrayList<String>();

    private final ArrayList<Long> item0List = new ArrayList<Long>();

    private final ArrayList<Long> item1List = new ArrayList<Long>();

    private final ArrayList<Long> item2List = new ArrayList<Long>();

    private final ArrayList<Long> item3List = new ArrayList<Long>();

    private final ArrayList<Long> item4List = new ArrayList<Long>();

    private final ArrayList<Long> item5List = new ArrayList<Long>();

    private final ArrayList<Long> item6List = new ArrayList<Long>();

    private final ArrayList<Long> totalDamageDealtList = new ArrayList<Long>();

    private final ArrayList<Long> goldEarnedList = new ArrayList<Long>();

    private final ArrayList<Long> totalDamageTakenList = new ArrayList<Long>();
    private final ArrayList<Long> levelList = new ArrayList<Long>();
    private final ArrayList<Long> csList = new ArrayList<Long>();
    private final ArrayList<Boolean> winList = new ArrayList<Boolean>();

    private String gamemode;

    public CheckMatchInteractor(String matchId, CheckMatchOutputBoundary matchPresenter,
                                MatchDataAccessObject matchDataAccessObject){
        this.matchPresenter = matchPresenter;
        this.matchId = matchId;
        this.matchDataAccessObject = matchDataAccessObject;
    }

    @Override
    public void execute(){
        try {
            JSONArray zipmatch = matchDataAccessObject.getzipmatch(matchId);
            for (int i = 0; i < zipmatch.length(); i++) {
                puuidList.add(zipmatch.getJSONObject(i).getString("puuid"));
                summonerNameList.add(zipmatch.getJSONObject(i).getString("summonerName"));
                assistsList.add(zipmatch.getJSONObject(i).getLong("assists"));
                deathsList.add(zipmatch.getJSONObject(i).getLong("deaths"));
                killsList.add(zipmatch.getJSONObject(i).getLong("kills"));
                championIdList.add(zipmatch.getJSONObject(i).getString("championId"));
                championNameList.add(zipmatch.getJSONObject(i).getString("championName"));
                item0List.add(zipmatch.getJSONObject(i).getLong("item0"));
                item1List.add(zipmatch.getJSONObject(i).getLong("item1"));
                item2List.add(zipmatch.getJSONObject(i).getLong("item2"));
                item3List.add(zipmatch.getJSONObject(i).getLong("item3"));
                item4List.add(zipmatch.getJSONObject(i).getLong("item4"));
                item5List.add(zipmatch.getJSONObject(i).getLong("item5"));
                item6List.add(zipmatch.getJSONObject(i).getLong("item6"));
                totalDamageDealtList.add(zipmatch.getJSONObject(i).getLong("totalDamageDealtToChampions"));
                totalDamageTakenList.add(zipmatch.getJSONObject(i).getLong("totalDamageTaken"));
                levelList.add(zipmatch.getJSONObject(i).getLong("champLevel"));
                csList.add(zipmatch.getJSONObject(i).getLong("totalMinionsKilled")+zipmatch.getJSONObject(i).getLong("totalAllyJungleMinionsKilled"));
                winList.add(zipmatch.getJSONObject(i).getBoolean("win"));
                kdaList.add(zipmatch.getJSONObject(i).getDouble("kda"));
                goldEarnedList.add(zipmatch.getJSONObject(i).getLong("goldEarned"));


            }
            gamemode = zipmatch.getJSONObject(0).getString("gameMode");
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        MatchData  match= new MatchData(puuidList, summonerNameList, assistsList, deathsList,
                killsList, championIdList, championNameList, item0List, item1List, item2List,
                item3List, item4List, item5List, item6List, totalDamageDealtList, totalDamageTakenList,
                levelList, csList, winList, matchId, kdaList, goldEarnedList, gamemode);
        CheckMatchOutputdata checkMatchOutputdata = new CheckMatchOutputdata(match);
        matchPresenter.prepareSuccessView();


    }
}
