package data_access;

import entity.Player;
import entity.PlayerFactory;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.key_setup.KeySetupDataAccessInterface;
import use_case.login.LoginPlayerDataAccessInterface;

import java.io.*;

import okhttp3.*;
import use_case.logout.LogoutPlayerDataAccessInterface;


public class PlayerDataAccessObject implements LoginPlayerDataAccessInterface, LogoutPlayerDataAccessInterface, KeySetupDataAccessInterface {
    private final File playerFile;

    private String authoKey;

    private Player player;

    private PlayerFactory playerFactory;

    public PlayerDataAccessObject(String playerCSVPath, PlayerFactory playerFactory) throws IOException {
        this.playerFactory = playerFactory;
        playerFile = new File(playerCSVPath);
        authoKey = getKey();

        if (playerFile.length() == 0) {
            savePlayer();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(playerFile))) {
                String playerID = reader.readLine();
                String puuid = reader.readLine();
                this.player = this.playerFactory.create(playerID, puuid);
            }
        }
    }

    private String getKey() throws IOException {
        File keyFile = new File("authoKey.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(keyFile))) {
            return reader.readLine();
        }
    }

    private void savePlayer() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(playerFile));
            writer.write(player.getPlayerID());
            writer.write(player.getPuuiD());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveKey() {
        BufferedWriter writer;
        File keyFile = new File("authoKey.csv");
        try {
            writer = new BufferedWriter(new FileWriter(keyFile));
            writer.write(authoKey);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validPlayerID(String playerID) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/NA1", playerID))
                .addHeader("X-Riot-Token", authoKey)
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            responseBody.getString("puuid");
            return true;
        } catch (IOException | JSONException e) {
            return false;
        }
    }

    @Override
    public void save(Player player) {
        this.player = player;
    }

    @Override
    public String getPuuid(String playerID) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/NA1", playerID))
                .addHeader("X-Riot-Token", authoKey)
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            return responseBody.getString("puuid");
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setKey(String userInputKey) {
        this.authoKey = userInputKey;
    }

    @Override
    public boolean validKey() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/wrnmbb/NA1")
                .addHeader("X-Riot-Token", authoKey)
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            responseBody.getInt("status_code");
            return false;
        } catch (IOException | JSONException e) {
            return true;
        }
    }

    @Override
    public void logout() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(playerFile));
            writer.write("");
            writer.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
