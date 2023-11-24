package interface_adapter.return_mainpage;

import use_case.return_mainpage.ReturnMainInputBoundary;

public class ReturnMainController {
    final ReturnMainInputBoundary returnMainInteractor;
    public ReturnMainController(ReturnMainInputBoundary returnMainInteractor){
        this.returnMainInteractor = returnMainInteractor;
    }

    public void execute(){returnMainInteractor.execute();}
}
