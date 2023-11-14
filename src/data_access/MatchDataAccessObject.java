package data_access;

import entity.Match;
import entity.MatchFactory;
import entity.Matches;
import entity.MatchesFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.CheckMatch.CheckMatchDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchDataAccessObject implements CheckMatchDataAccessInterface {

    private final File matchFile;
    private String authoKey;

    private Matches matches;

    private ArrayList<Match> matchesList = new ArrayList<Match>();

    private MatchFactory matchFactory;

    private MatchesFactory matchesFactory;

    public MatchDataAccessObject(String matchFilePath, MatchFactory matchFactory, MatchesFactory matchesFactory) throws IOException {
        this.matchesFactory = matchesFactory;
        this.matchFactory = matchFactory;
        matchFile = new File(matchFilePath);
        authoKey = getKey();
        if (matchFile.length() == 0) {
            saveMatches();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(matchFile))) {
                String row;
                while ((row = reader.readLine()) != null) {
                    matchesList.add(getMatch(row));
                }
            }
        }
        matches = this.matchesFactory.create(matchesList);
    }

    private void saveMatches() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(matchFile));
            for (Match match : matchesList) {
                writer.write(match.getMatchID());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getKey() throws IOException {
        File keyFile = new File("authoKey.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(keyFile))) {
            return reader.readLine();
        }
    }

    public List<String> getMatchesID(String puuid) {
        ArrayList<String> matchesID = new ArrayList<String>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/%s/ids?start=0&count=20", puuid))
                .addHeader("X-Riot-Token", authoKey)
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            String input = response.body().string();
            String a = input.substring(1, input.length() - 1);
            String[] elements = a.split(",");
            List<String> arrayList = Arrays.asList(elements);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.set(i, arrayList.get(i).substring(1, arrayList.get(i).length() - 1));
            }
            return arrayList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Match getMatch(String matchId) {
        ArrayList<String> puuidList = new ArrayList<String>();
        ArrayList<String> summonerNameList = new ArrayList<String>();
        ArrayList<Long> assistsList = new ArrayList<Long>();
        ArrayList<Long> deathsList = new ArrayList<Long>();
        ArrayList<Long> killsList = new ArrayList<Long>();
        ArrayList<Long> kdaList = new ArrayList<Long>();
        ArrayList<String> championIdList = new ArrayList<String>();
        ArrayList<String> championNameList = new ArrayList<String>();
        ArrayList<Long> item0List = new ArrayList<Long>();
        ArrayList<Long> item1List = new ArrayList<Long>();
        ArrayList<Long> item2List = new ArrayList<Long>();
        ArrayList<Long> item3List = new ArrayList<Long>();
        ArrayList<Long> item4List = new ArrayList<Long>();
        ArrayList<Long> item5List = new ArrayList<Long>();
        ArrayList<Long> item6List = new ArrayList<Long>();
        ArrayList<Long> totalDamageDealtList = new ArrayList<Long>();
        ArrayList<Long> goldEarnedList = new ArrayList<Long>();
        ArrayList<Long> totalDamageTakenList = new ArrayList<Long>();
        ArrayList<Long> levelList = new ArrayList<Long>();
        ArrayList<Long> csList = new ArrayList<Long>();
        ArrayList<Boolean> winList = new ArrayList<Boolean>();
        ArrayList<Long> gameStartTimestampList = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://americas.api.riotgames.com/lol/match/v5/matches/%s", matchId))
                .addHeader("X-Riot-Token", authoKey)
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONObject info = responseBody.getJSONObject("info");
            JSONArray participants = info.getJSONArray("participants");
            for (int i = 0; i < participants.length(); i++) {
                puuidList.add(participants.getJSONObject(i).getString("puuid"));
                summonerNameList.add(participants.getJSONObject(i).getString("summonerName"));
                championIdList.add(Integer.toString(participants.getJSONObject(i).getInt("championId")));
                championNameList.add(participants.getJSONObject(i).getString("championName"));
                item0List.add(participants.getJSONObject(i).getLong("item0"));
                item1List.add(participants.getJSONObject(i).getLong("item1"));
                item2List.add(participants.getJSONObject(i).getLong("item2"));
                item3List.add(participants.getJSONObject(i).getLong("item3"));
                item4List.add(participants.getJSONObject(i).getLong("item4"));
                item5List.add(participants.getJSONObject(i).getLong("item5"));
                item6List.add(participants.getJSONObject(i).getLong("item6"));
                totalDamageDealtList.add(participants.getJSONObject(i).getLong("totalDamageDealtToChampions"));
                totalDamageTakenList.add(participants.getJSONObject(i).getLong("totalDamageTaken"));
                levelList.add(participants.getJSONObject(i).getLong("champLevel"));
                csList.add(participants.getJSONObject(i).getLong("totalMinionsKilled") + participants.getJSONObject(i).getLong("totalAllyJungleMinionsKilled"));
                winList.add(participants.getJSONObject(i).getBoolean("win"));
                goldEarnedList.add(participants.getJSONObject(i).getLong("goldEarned"));
                gameStartTimestampList.add(info.getLong("gameStartTimestamp"));
                long assists = participants.getJSONObject(i).getLong("assists");
                long deaths = participants.getJSONObject(i).getLong("deaths");
                long kills = participants.getJSONObject(i).getLong("kills");
                long kda = 0;
                if (deaths != 0) {
                    kda = (assists + kills) / deaths;
                }
                assistsList.add(assists);
                deathsList.add(deaths);
                killsList.add(kills);
                kdaList.add(kda);
            }
            String gamemode = info.getString("gameMode");
            return matchFactory.create(puuidList, summonerNameList, assistsList, deathsList,
                    killsList, championIdList, championNameList, item0List, item1List, item2List,
                    item3List, item4List, item5List, item6List, totalDamageDealtList, totalDamageTakenList,
                    levelList, csList, winList, matchId, kdaList, goldEarnedList, gamemode, gameStartTimestampList);
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Match> getMatchesList() {
        return matchesList;
    }
}
