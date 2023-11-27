package use_case.ApplyStats;

public class ApplyStatsInteractor implements ApplyStatsInputBoundary {
    final ApplyStatsDataAccessInterface applyStatsDataAccessInterface;
    final ApplyStatsOutputBoundary outputBoundary;

    public ApplyStatsInteractor(ApplyStatsDataAccessInterface applyStatsDataAccessInterface, ApplyStatsOutputBoundary outputBoundary) {
        this.applyStatsDataAccessInterface = applyStatsDataAccessInterface;
        this.outputBoundary = outputBoundary;
    }
    @Override
    public void execute(ApplyStatsInputData applyStatsInputData) {
        applyStatsDataAccessInterface.plotStats(applyStatsInputData.getStat1(), applyStatsInputData.getStat2(), applyStatsInputData.getStat3(), applyStatsInputData.getStat4(), applyStatsInputData.getStat5());
        ApplyStatsOutputData applyStatsOutputData = new ApplyStatsOutputData();
        outputBoundary.prepareSuccessView(applyStatsOutputData);
    }
}
