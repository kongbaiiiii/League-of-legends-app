package use_case.return_mainpage;

public class ReturnMainInteractor implements ReturnMainInputBoundary {
    final ReturnMainOutputBoundary mainpagePresenter;

    public ReturnMainInteractor(ReturnMainOutputBoundary mainpagePresenter){
        this.mainpagePresenter = mainpagePresenter;
    }

    @Override
    public void execute(){
        mainpagePresenter.prepareSuccessView();
    }
}
