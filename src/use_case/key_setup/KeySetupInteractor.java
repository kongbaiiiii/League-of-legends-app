package use_case.key_setup;

public class KeySetupInteractor implements KeySetupInputBoundary{

    final KeySetupDataAccessInterface userDataAccessObject;

    final KeySetupOutputBoundary userPresenter;

    public KeySetupInteractor(KeySetupDataAccessInterface keySetupDataAccessInterface,
                              KeySetupOutputBoundary keySetupOutputBoundary){
        this.userDataAccessObject = keySetupDataAccessInterface;
        this.userPresenter = keySetupOutputBoundary;

    }
    @Override
    public void execute(KeySetupInputData keySetupInputData) {
        String key = keySetupInputData.getKey();
        userDataAccessObject.setKey(key);
        if (userDataAccessObject.validKey(key)) {
            System.out.println("valid key");
            userDataAccessObject.saveKey();
            userPresenter.prepareSuccessView();
        }else{
            System.out.println("invalid key");
            userPresenter.prepareFailView();
        }
    }
}
