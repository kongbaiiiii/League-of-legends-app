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
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        for (Match match : matchList) {
            int playerIndex = match.getPlayerIndexByPlayerID(player.getPlayerID());
            Map<String, Object> matchData = match.getDataByPlayerIndex(playerIndex);
            gameStartTimeList.add(ConvertTimeStampToString((Long) matchData.get("gameStartTimestamp")));
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

    private void plot(ArrayList<String> gameStartTimeList, ArrayList<Object> dataList, String outputName) {
        int width = 600;
        int height = 200;
        String backgroundColor = "rgb(20, 20, 20)";

        Map<String, Object> data = setUpDataMap(dataList, gameStartTimeList);

        Map<String, Object> scales = setUpScalesMap();
        Map<String, Object> title = setUpTitleMap(outputName);
        Map<String, Object> legend = setUpLegendMap();
        Map<String, Object> options = setUpOptionsMap(legend, scales, title);

        Map<String, Object> chartData = new HashMap<>();
        chartData.put("type", "line");
        chartData.put("data", data);
        chartData.put("options", options);

        String chartDataAsString = new JSONObject(chartData).toString();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format(
                        "https://quickchart.io/chart?bkg=%s&w=%d&h=%d&format=base64&chart=%s&devicePixelRatio=1",
                        backgroundColor, width, height, chartDataAsString))
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            String request_body = response.body().string();
            byte[] decodedData = Base64.getDecoder().decode(request_body);

            // Specify the output image file path
            String outputPath = String.format("src/images/%s.png", outputName);

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

    private Map<String, Object> setUpDataMap(ArrayList<Object> dataList, ArrayList<String> gameStartTimeList) {
        String lineColor = "rgb(75, 192, 192)";
        int lineWidth = 2;
        Map<String, Object> data = new HashMap<>();
        ArrayList<Object> datasets = new ArrayList<>();
        Map<String, Object> dataSet1 = new HashMap<>();
        dataSet1.put("type", "line");
        dataSet1.put("label", "Dataset 1");
        dataSet1.put("borderColor", lineColor);
        dataSet1.put("borderWidth", lineWidth);
        dataSet1.put("fill", false);
        dataSet1.put("data", dataList);
        datasets.add(dataSet1);
        data.put("labels", gameStartTimeList);
        data.put("datasets", datasets);
        return data;
    }

    private Map<String, Object> setUpScalesMap() {
        Map<String, Object> scales = new HashMap<>();
        ArrayList<Map<String, Object>> xAxesStyle = new ArrayList<>();
        Map<String, Object> ticksX = new HashMap<>();
        Map<String, Object> fontStyleX = new HashMap<>();
        fontStyleX.put("fontSize", 10);
        ticksX.put("ticks", fontStyleX);
        xAxesStyle.add(ticksX);
        scales.put("xAxes", xAxesStyle);
        ArrayList<Map<String, Object>> yAxesStyle = new ArrayList<>();
        Map<String, Object> ticksY = new HashMap<>();
        Map<String, Object> fontStyleY = new HashMap<>();
        fontStyleY.put("fontSize", 10);
        ticksY.put("ticks", fontStyleY);
        yAxesStyle.add(ticksY);
        scales.put("yAxes", yAxesStyle);
        return scales;
    }

    private Map<String, Object> setUpTitleMap(String outputName) {
        String fontColor = "rgb(75, 192, 192)";
        Map<String, Object> title = new HashMap<>();
        title.put("display", true);
        title.put("text", outputName.toUpperCase(Locale.ROOT));
        title.put("fontSize", 16);
        title.put("fontColor", fontColor);
        return title;
    }

    private Map<String, Object> setUpLegendMap() {
        Map<String, Object> legend = new HashMap<>();
        legend.put("display", false);
        return legend;
    }

    private Map<String, Object> setUpOptionsMap(Map<String, Object> legend, Map<String, Object> scales, Map<String, Object> title) {
        Map<String, Object> options = new HashMap<>();
        options.put("legend", legend);
        options.put("scales", scales);
        options.put("title", title);
        return options;
    }

    private String ConvertTimeStampToString(Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Format the LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy:HH");
        return localDateTime.format(formatter);
    }
}
