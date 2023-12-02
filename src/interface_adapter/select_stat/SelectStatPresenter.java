package interface_adapter.select_stat;

import interface_adapter.ViewManagerModel;
import use_case.select_stat.SelectStatOutputBoundary;

public class SelectStatPresenter implements SelectStatOutputBoundary {
    private final SelectStatViewModel selectStatViewModel;

    private final ViewManagerModel viewManagerModel;

    public SelectStatPresenter(SelectStatViewModel selectStatViewModel, ViewManagerModel viewManagerModel) {
        this.selectStatViewModel = selectStatViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        this.viewManagerModel.setActiveView(selectStatViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
