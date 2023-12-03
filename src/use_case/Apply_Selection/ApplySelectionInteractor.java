package use_case.Apply_Selection;

public class ApplySelectionInteractor implements ApplySelectionInputBoundary {
    final ApplySelectionDataAccessInterface applySelectionDataAccessInterface;
    final ApplySelectionOutputBoundary applySelectionOutputBoundary;

    public ApplySelectionInteractor(ApplySelectionDataAccessInterface applySelectionDataAccessInterface, ApplySelectionOutputBoundary applySelectionOutputBoundary) {
        this.applySelectionDataAccessInterface = applySelectionDataAccessInterface;
        this.applySelectionOutputBoundary = applySelectionOutputBoundary;
    }
    @Override
    public void execute(ApplySelectionInputData applySelectionInputData) {
        applySelectionDataAccessInterface.plotStats(applySelectionInputData.getPlayerId(),applySelectionInputData.getStat1(), applySelectionInputData.getStat2(), applySelectionInputData.getStat3(), applySelectionInputData.getStat4(), applySelectionInputData.getStat5());
        ApplySelectionOutputData applySelectionOutputData = new ApplySelectionOutputData();
        applySelectionOutputBoundary.prepareSuccessView(applySelectionOutputData);
    }
}