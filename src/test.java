import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class test {
    public static void main(String[] args) {
        String MatchID = "NA1_4821455786";
        String authoKey = "RGAPI-c6939f7a-5124-47b9-992f-bf3d71cff68c";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://americas.api.riotgames.com/lol/match/v5/matches/%s", MatchID))
                .addHeader("X-Riot-Token", authoKey)
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONObject info = responseBody.getJSONObject("info");
            JSONArray participant = info.getJSONArray("participants");
            for (int i = 0; i < participant.length(); i++) {
                System.out.println(participant.getJSONObject(i).getString("summonerName"));
                System.out.println(participant.getJSONObject(i).getString("championName"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
