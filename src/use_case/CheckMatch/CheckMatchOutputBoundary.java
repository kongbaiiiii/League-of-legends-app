package use_case.CheckMatch;

public interface CheckMatchOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
