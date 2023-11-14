package data_access;

import entity.Match;
import entity.Matches;
import entity.Player;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class StatPlotDataAccessObject {
    private final Matches matches;
    private final Player player;

    public StatPlotDataAccessObject(Matches matches, Player player) {
        this.matches = matches;
        this.player = player;
    }

    public void plotStats(String stat1, String stat2, String stat3, String stat4, String stat5) {
        ArrayList<String> gameStartTimeList = new ArrayList<>();
        ArrayList<Object> data1 = new ArrayList<>();
        ArrayList<Object> data2 = new ArrayList<>();
        ArrayList<Object> data3 = new ArrayList<>();
        ArrayList<Object> data4 = new ArrayList<>();
        ArrayList<Object> data5 = new ArrayList<>();
        List<Match> matchList = matches.getAllMatches();
        for (Match match: matchList){
            int playerIndex = match.getPlayerIndexByPlayerID(player.getPlayerID());
            Map<String, Object> matchData = match.getDataByPlayerIndex(playerIndex);
            gameStartTimeList.add((String) matchData.get("gameStartTime"));
            data1.add(matchData.get(stat1));
            data2.add(matchData.get(stat2));
            data3.add(matchData.get(stat3));
            data4.add(matchData.get(stat4));
            data5.add(matchData.get(stat5));
        }
        plot(gameStartTimeList, data1, stat1);
        plot(gameStartTimeList, data2, stat2);
        plot(gameStartTimeList, data3, stat3);
        plot(gameStartTimeList, data4, stat4);
        plot(gameStartTimeList, data5, stat5);
    }

    private void plot(ArrayList<String> gameStartTimeList, ArrayList<Object> dataList, String outputName){
        int width = 300;
        int height = 100;
        String backgroundColor = "rgb(20, 20, 20)";
        String lineColor = "rgb(75, 192, 192)";

        Map<String, Object> data = new HashMap<>();

        ArrayList<Object> datasets = new ArrayList<>();

        Map<String, Object> dataSet1 = new HashMap<>();
        dataSet1.put("type", "line");
        dataSet1.put("label", "Dataset 1");
        dataSet1.put("borderColor", lineColor);
        dataSet1.put("borderWidth", 2);
        dataSet1.put("fill", false);
        dataSet1.put("data", dataList);
        datasets.add(dataSet1);

        data.put("labels", gameStartTimeList);
        data.put("datasets", datasets);

        Map<String, Object> chartData = new HashMap<>();
        chartData.put("type", "line");
        chartData.put("data", data);

        String chartDataAsString = new JSONObject(chartData).toString();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://quickchart.io/chart?backgroundColor=%s&width=%d&height=%d&format=base64&chart=%s",
                        backgroundColor, width, height, chartDataAsString))
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            String request_body = response.body().string();
            System.out.println(request_body);
            byte[] decodedData = Base64.getDecoder().decode(request_body);

            // Specify the output image file path
            String outputPath = String.format("src/%s.png", outputName);

            // Write the decoded data to a PNG file
            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                fos.write(decodedData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
