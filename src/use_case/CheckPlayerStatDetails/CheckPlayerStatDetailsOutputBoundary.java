package use_case.CheckPlayerStatDetails;

public interface CheckPlayerStatDetailsOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
