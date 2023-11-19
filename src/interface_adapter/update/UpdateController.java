package interface_adapter.update;

import use_case.update.UpdateInputBoundary;
import use_case.update.UpdateInputData;

public class UpdateController {
    private final UpdateInputBoundary updateUseCaseInteractor;

    public UpdateController(UpdateInputBoundary updateUseCaseInteractor) {
        this.updateUseCaseInteractor = updateUseCaseInteractor;
    }

    public void execute(String puuid, String stat1, String stat2, String stat3, String stat4, String stat5){
        UpdateInputData updateInputData = new UpdateInputData(puuid, stat1, stat2, stat3, stat4, stat5);
        updateUseCaseInteractor.execute(updateInputData);
    }
}
