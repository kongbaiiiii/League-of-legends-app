package interface_adapter.apply_selection;

import use_case.Apply_Selection.ApplySelectionInputBoundary;
import use_case.Apply_Selection.ApplySelectionInputData;

public class ApplySelectionController {
    private final ApplySelectionInputBoundary applySelectionUseCaseInteractor;

    public ApplySelectionController(ApplySelectionInputBoundary applySelectionUseCaseInteractor) {
        this.applySelectionUseCaseInteractor = applySelectionUseCaseInteractor;
    }

    public void execute(String playerID, String stat1, String stat2, String stat3, String stat4, String stat5){
        ApplySelectionInputData applySelectionInputData = new ApplySelectionInputData(playerID, stat1, stat2, stat3, stat4, stat5);
        applySelectionUseCaseInteractor.execute(applySelectionInputData);
    }
}
