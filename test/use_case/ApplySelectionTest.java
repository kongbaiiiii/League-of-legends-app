package use_case;

import data_access.AllPurposeDataAccessObject;
import data_access.MatchDataAccessObject;
import data_access.PlayerDataAccessObject;
import data_access.StatPlotDataAccessObject;
import entity.*;
import org.junit.jupiter.api.Test;
import use_case.Apply_Selection.ApplySelectionDataAccessInterface;
import use_case.Apply_Selection.ApplySelectionInputData;
import use_case.Apply_Selection.ApplySelectionInteractor;
import use_case.Apply_Selection.ApplySelectionOutputBoundary;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplySelectionTest {
    boolean executed = false;



    @Test
    public void successTest() throws IOException {
        ApplySelectionOutputBoundary applySelectionOutputBoundary = new ApplySelectionOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                executed = true;
            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        ApplySelectionDataAccessInterface applySelectionDataAccessInterface = new AllPurposeDataAccessObject("matchdata.csv", new NormalMatchFactory(), new NormalMatchesFactory(), "player.csv", new NormalPlayerFactory());
        ApplySelectionInteractor interactor = new ApplySelectionInteractor(applySelectionDataAccessInterface, applySelectionOutputBoundary);
        ApplySelectionInputData inputData = new ApplySelectionInputData("wrnmbb", "kills", "deaths", "assists", "cs", "goldEarned");
        interactor.execute(inputData);
        assertTrue(executed); //Assert that prepareSuccessView is called properly
    }
}
