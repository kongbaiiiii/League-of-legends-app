package use_case.update;

import entity.Matches;

public class UpdateInteractor implements UpdateInputBoundary {

    final UpdateDataAccessInterface updateDataAccessObject;

    final UpdateOutputBoundary playerPresenter;

    public UpdateInteractor(UpdateDataAccessInterface updateDataAccessObject, UpdateOutputBoundary playerPresenter) {
        this.updateDataAccessObject = updateDataAccessObject;
        this.playerPresenter = playerPresenter;
    }

    @Override
    public void execute(UpdateInputData updateInputData) {
        String puuid = updateInputData.getPuuid();
        updateDataAccessObject.updateMatchesFile(puuid);
        updateDataAccessObject.plotStats(updateInputData.getStat1(), updateInputData.getStat2(), updateInputData.getStat3(), updateInputData.getStat4(), updateInputData.getStat5());
        Matches matches = updateDataAccessObject.getMatches();

        UpdateOutputData updateOutputData = new UpdateOutputData(matches);
        playerPresenter.prepareSuccessView(updateOutputData);
    }
}
