package use_case.select_stat;

public class SelectStatInteractor implements SelectStatInputBoundary{

    private final SelectStatOutputBoundary userPresenter;

    public SelectStatInteractor(SelectStatOutputBoundary selectStatOutputBoundary){
        this.userPresenter = selectStatOutputBoundary;
    }
    @Override
    public void execute() {
        userPresenter.prepareSuccessView();
    }
}
