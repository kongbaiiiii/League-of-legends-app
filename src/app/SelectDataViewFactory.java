package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.select_stat.SelectStatViewModel;
import view.SelectStatView;

public class SelectDataViewFactory {
    public static SelectStatView create(ViewManagerModel viewManagerModel, SelectStatViewModel selectStatViewModel){
        return new SelectStatView(selectStatViewModel);
    }
}
