package interface_adapter.return_mainpage;

import interface_adapter.ViewManagerModel;
import use_case.return_mainpage.ReturnMainDataOutputBoundary;

public class ReturnMainPresenter implements ReturnMainDataOutputBoundary {
    private final ReturnMainViewModel returnMainViewModel;
    private ViewManagerModel viewManagerModel;

    public ReturnMainPresenter(ReturnMainViewModel returnMainViewModel, ViewManagerModel viewManagerModel){
        this.viewManagerModel = viewManagerModel;
        this.returnMainViewModel = returnMainViewModel;
    }

    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(returnMainViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
