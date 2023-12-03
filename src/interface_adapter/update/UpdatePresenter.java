package interface_adapter.update;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.update.UpdateOutputBoundary;
import use_case.update.UpdateOutputData;

import javax.swing.*;

public class UpdatePresenter implements UpdateOutputBoundary {
    private final UpdateViewModel updateViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private final ViewManagerModel viewManagerModel;

    public UpdatePresenter(UpdateViewModel updateViewModel, LoggedInViewModel loggedInViewModel,
                           ViewManagerModel viewManagerModel) {
        this.updateViewModel = updateViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpdateOutputData updateOutputData) {
        LoggedInState currentState = loggedInViewModel.getState();
        currentState.setPlayerID(updateOutputData.getPlayerID());
        currentState.setAssistsList(updateOutputData.getAssistsList());
        currentState.setDeathsList(updateOutputData.getDeathsList());
        currentState.setKillsList(updateOutputData.getKillsList());
        currentState.setChampionIdList(updateOutputData.getChampionIdList());
        currentState.setWinList(updateOutputData.getWinList());
        currentState.setMatchIDList(updateOutputData.getMatchIDList());
        loggedInViewModel.setState(currentState);
        loggedInViewModel.firePropertyChanged();

        JOptionPane.showMessageDialog(null, updateViewModel.getUPDATE_SUCCESSFUL_MESSAGE());
        viewManagerModel.setActiveView(updateViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
