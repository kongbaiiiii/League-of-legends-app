package use_case;

import interface_adapter.ViewManagerModel;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsController;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsPresenter;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.select_stat.SelectStatViewModel;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotInputData;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotInteractor;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputBoundary;
import use_case.CheckPlayerStatDetails.CheckPlayerStatPlotOutputdata;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckPlayerStatDetailsTest {

    @Test
    public void successTest() {
        CheckPlayerStatPlotOutputBoundary checkPlayerStatPlotOutputBoundary = new CheckPlayerStatPlotOutputBoundary() {
            @Override
            public void prepareSuccessView(CheckPlayerStatPlotOutputdata checkPlayerStatPlotOutputdata) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel = new CheckPlayerStatDetailsViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SelectStatViewModel selectStatViewModel = new SelectStatViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        CheckPlayerStatDetailsPresenter presenter = new CheckPlayerStatDetailsPresenter(checkPlayerStatDetailsViewModel, loggedInViewModel, selectStatViewModel, viewManagerModel);
        CheckPlayerStatPlotInteractor interactor = new CheckPlayerStatPlotInteractor(presenter);
        CheckPlayerStatPlotInputData inputData = new CheckPlayerStatPlotInputData("wrnmbb");
        interactor.execute(inputData);
        assertNotNull(viewModel.getState());
    }
}