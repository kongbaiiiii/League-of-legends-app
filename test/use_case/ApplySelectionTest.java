package use_case;

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
        PlayerFactory playerFactory = new NormalPlayerFactory();
        Player player = playerFactory.create("wrnmbb", "7GZb-UDFr6NN7NKxd_8wbMUlXZhO7KbwcYT6PwvOjhEnAOM0C33tbBAwHGrwOkhI7zct11shKwt1yg");
        MatchDataAccessObject matchDataAccessObject = new MatchDataAccessObject("matchdata.csv", new NormalMatchFactory(), new NormalMatchesFactory());
        MatchesFactory matchesFactory = new NormalMatchesFactory();
        Matches matches = matchesFactory.create(matchDataAccessObject.getMatchesList());

        ApplySelectionDataAccessInterface applySelectionDataAccessInterface = new StatPlotDataAccessObject(matches, player);
        ApplySelectionInteractor interactor = new ApplySelectionInteractor(applySelectionDataAccessInterface, applySelectionOutputBoundary);
        ApplySelectionInputData inputData = new ApplySelectionInputData("wrnmbb", "kills", "deaths", "assists", "cs", "goldEarned");
        interactor.execute(inputData);
        assertTrue(executed); //Assert that prepareSuccessView is called properly
    }
}
