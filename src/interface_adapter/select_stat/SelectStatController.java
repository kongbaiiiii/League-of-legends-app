package interface_adapter.select_stat;

import use_case.select_stat.SelectStatInputData;
import use_case.select_stat.SelectStatInteractor;

public class SelectStatController {
    private final SelectStatInteractor selectStatUseCaseInteractor;

    public SelectStatController(SelectStatInteractor selectStatUseCaseInteractor) {
        this.selectStatUseCaseInteractor = selectStatUseCaseInteractor;
    }

    public void execute(){
        selectStatUseCaseInteractor.execute();
    }
}
