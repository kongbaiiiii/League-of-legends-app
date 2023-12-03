package interface_adapter.apply_selection;

import app.Main;
import app.PlayerPlotViewFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.select_stat.SelectStatViewModel;
import use_case.Apply_Selection.ApplySelectionOutputBoundary;
import view.PlayerPlotView;

import javax.swing.*;

public class ApplySelectionPresenter implements ApplySelectionOutputBoundary {
    private final ApplySelectionViewModel applySelectionViewModel;

    private final CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private final SelectStatViewModel selectStatViewModel;

    private final ViewManagerModel viewManagerModel;

    public ApplySelectionPresenter(ApplySelectionViewModel applySelectionViewModel, ViewManagerModel viewManagerModel,
                                   CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel,
                                   LoggedInViewModel loggedInViewModel, SelectStatViewModel selectStatViewModel) {
        this.applySelectionViewModel = applySelectionViewModel;
        this.checkPlayerStatDetailsViewModel = checkPlayerStatDetailsViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.selectStatViewModel = selectStatViewModel;
    }

    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, applySelectionViewModel.getAPPLY_SELECTION_SUCCESSFUL_MESSAGE());
        PlayerPlotView playerPlotView = PlayerPlotViewFactory.create(viewManagerModel,checkPlayerStatDetailsViewModel,loggedInViewModel, selectStatViewModel);
        Main.views.add(playerPlotView, playerPlotView.viewName);
        viewManagerModel.setActiveView(checkPlayerStatDetailsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
