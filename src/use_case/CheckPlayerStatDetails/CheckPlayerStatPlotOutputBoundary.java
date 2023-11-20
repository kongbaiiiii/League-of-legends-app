package use_case.CheckPlayerStatDetails;

public interface CheckPlayerStatPlotOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
