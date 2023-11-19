package interface_adapter.return_mainpage;

import use_case.return_mainpage.ReturnMainDataInputBoundary;

public class ReturnMainController {
    final ReturnMainDataInputBoundary returnMainInteractor;
    public ReturnMainController(ReturnMainDataInputBoundary returnMainInteractor){
        this.returnMainInteractor = returnMainInteractor;
    }

    public void execute(){returnMainInteractor.execute();}
}
