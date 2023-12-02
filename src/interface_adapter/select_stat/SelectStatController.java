package interface_adapter.select_stat;

import use_case.select_stat.SelectStatInputBoundary;

public class SelectStatController {
    private final SelectStatInputBoundary selectStatUseCaseInteractor;

    public SelectStatController(SelectStatInputBoundary selectStatUseCaseInteractor) {
        this.selectStatUseCaseInteractor = selectStatUseCaseInteractor;
    }

    public void execute(){
        selectStatUseCaseInteractor.execute();
    }
}
