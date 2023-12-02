package use_case.CheckPlayerStatDetails;

public interface CheckPlayerStatPlotOutputBoundary {
    void prepareSuccessView(CheckPlayerStatPlotOutputdata checkPlayerStatPlotOutputdata);

    void prepareFailView(String error);
}
