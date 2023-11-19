package interface_adapter.update;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.update.UpdateOutputBoundary;
import use_case.update.UpdateOutputData;

import javax.swing.*;

public class UpdatePresenter implements UpdateOutputBoundary {
    private final UpdateViewModel updateViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public UpdatePresenter(UpdateViewModel updateViewModel, LoggedInViewModel loggedInViewModel,
                           ViewManagerModel viewManagerModel) {
        this.updateViewModel = updateViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpdateOutputData updateOutputData) {
        JOptionPane.showMessageDialog(null, updateViewModel.getUPDATE_SUCCESSFUL_MESSAGE());
        viewManagerModel.setActiveView(updateViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        //TODO: update the loggedInView
    }
}
