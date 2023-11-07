package use_case.return_mainpage;

public class ReturnMainDataInteractor implements ReturnMainDataInputBoundary {
    final ReturnMainDataOutputBoundary mainpagePresenter;

    public ReturnMainDataInteractor(ReturnMainDataOutputBoundary mainpagePresenter){
        this.mainpagePresenter = mainpagePresenter;
    }

    @Override
    public void execute(){
        mainpagePresenter.prepareSuccessView();
    }
}
