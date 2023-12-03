package use_case.Apply_Selection;

public interface ApplySelectionOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
