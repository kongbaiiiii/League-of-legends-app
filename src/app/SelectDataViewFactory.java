package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.apply_selection.ApplySelectionController;
import interface_adapter.apply_selection.ApplySelectionPresenter;
import interface_adapter.apply_selection.ApplySelectionViewModel;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.select_stat.SelectStatViewModel;
import use_case.Apply_Selection.ApplySelectionDataAccessInterface;
import use_case.Apply_Selection.ApplySelectionInputBoundary;
import use_case.Apply_Selection.ApplySelectionInteractor;
import use_case.Apply_Selection.ApplySelectionOutputBoundary;
import view.SelectStatView;

public class SelectDataViewFactory {
    public static SelectStatView create(ViewManagerModel viewManagerModel, SelectStatViewModel selectStatViewModel,
                                        ApplySelectionViewModel applySelectionViewModel,
                                        CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel,
                                        ApplySelectionDataAccessInterface statPlotDataAccessObject,
                                        LoggedInViewModel loggedInViewModel){
        ApplySelectionController applySelectionController = create(applySelectionViewModel, viewManagerModel, statPlotDataAccessObject, checkPlayerStatDetailsViewModel, selectStatViewModel, loggedInViewModel);
        return new SelectStatView(selectStatViewModel, applySelectionController);
    }

        private static ApplySelectionController create(ApplySelectionViewModel applySelectionViewModel, ViewManagerModel viewManagerModel,
                                                       ApplySelectionDataAccessInterface statPlotDataAccessObject,
                                                       CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel,
                                                       SelectStatViewModel selectStatViewModel,
                                                       LoggedInViewModel loggedInViewModel){
            ApplySelectionOutputBoundary applySelectionPresenter = new ApplySelectionPresenter(applySelectionViewModel, viewManagerModel, checkPlayerStatDetailsViewModel,loggedInViewModel, selectStatViewModel );
            ApplySelectionInputBoundary applySelectionInteractor = new ApplySelectionInteractor(statPlotDataAccessObject, applySelectionPresenter);
            return new ApplySelectionController(applySelectionInteractor);
        }
}
