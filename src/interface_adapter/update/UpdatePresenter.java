package interface_adapter.update;

import interface_adapter.logged_in.LoggedInViewModel;
import use_case.update.UpdateOutputBoundary;
import use_case.update.UpdateOutputData;

public class UpdatePresenter implements UpdateOutputBoundary {
    private final UpdateViewModel updateViewModel;

    private final LoggedInViewModel loggedInViewModel;

    public UpdatePresenter(UpdateViewModel updateViewModel, LoggedInViewModel loggedInViewModel) {
        this.updateViewModel = updateViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(UpdateOutputData updateOutputData) {

    }
}
