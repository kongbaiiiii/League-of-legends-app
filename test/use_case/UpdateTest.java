package use_case;

import data_access.AllPurposeDataAccessObject;
import entity.NormalMatchFactory;
import entity.NormalMatchesFactory;
import entity.NormalPlayerFactory;
import org.junit.Test;
import use_case.update.*;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateTest {
    @Test
    public void successTest() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("images/stat1.png")) {
            fos.write(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter writer1;
        BufferedWriter writer2;
        try {
            writer1 = new BufferedWriter(new FileWriter("player.csv"));
            writer1.write("wrnmbb\n" +
                    "7GZb-UDFr6NN7NKxd_8wbMUlXZhO7KbwcYT6PwvOjhEnAOM0C33tbBAwHGrwOkhI7zct11shKwt1yg");
            writer1.close();

            writer2 = new BufferedWriter(new FileWriter("matchdata.csv"));
            writer2.write("");
            writer2.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        UpdateInputData updateInputData = new UpdateInputData("GADFAIV", "kills", "deaths", "assists", "cs", "goldEarned");
        UpdateDataAccessInterface updateDataAccessObject = new AllPurposeDataAccessObject("matchdata.csv", new NormalMatchFactory(),
                new NormalMatchesFactory(), "player.csv", new NormalPlayerFactory());
        UpdateOutputBoundary successPresenter = new UpdateOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateOutputData updateOutputData) {
                assertNotEquals(updateOutputData.getChampionIdList().size(), 0);
                assertNotEquals(updateOutputData.getDeathsList().size(), 0);
                assertNotEquals(updateOutputData.getAssistsList().size(), 0);
                assertNotEquals(updateOutputData.getKillsList().size(), 0);
                assertNotEquals(updateOutputData.getMatchIDList().size(), 0);
                assertNotEquals(updateOutputData.getWinList().size(), 0);
                assertNotNull(updateOutputData.getPlayerID());
                assertNotNull(updateOutputData.getMatches());
            }
        };

        UpdateInputBoundary interactor = new UpdateInteractor(updateDataAccessObject, successPresenter);
        interactor.execute(updateInputData);
    }
}
