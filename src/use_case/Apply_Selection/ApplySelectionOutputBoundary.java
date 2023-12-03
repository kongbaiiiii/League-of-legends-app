package use_case.Apply_Selection;

public interface ApplySelectionOutputBoundary {
    void prepareSuccessView(ApplySelectionOutputData applySelectionOutputData);

    void prepareFailView(String error);
}
