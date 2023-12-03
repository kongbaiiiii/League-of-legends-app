package interface_adapter.apply_selection;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.Apply_Selection.ApplySelectionOutputBoundary;
import use_case.Apply_Selection.ApplySelectionOutputData;
import javax.swing.*;

public class ApplySelectionPresenter implements ApplySelectionOutputBoundary {
    private final ApplySelectionViewModel applySelectionViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private final ViewManagerModel viewManagerModel;

    public ApplySelectionPresenter(ApplySelectionViewModel applySelectionViewModel, LoggedInViewModel loggedInViewModel,
                           ViewManagerModel viewManagerModel) {
        this.applySelectionViewModel = applySelectionViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ApplySelectionOutputData applySelectionOutputData) {
        LoggedInState currentState = loggedInViewModel.getState();
        loggedInViewModel.setState(currentState);
        loggedInViewModel.firePropertyChanged();

        JOptionPane.showMessageDialog(null, applySelectionViewModel.getAPPLY_SELECTION_SUCCESSFUL_MESSAGE());
        viewManagerModel.setActiveView(applySelectionViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
