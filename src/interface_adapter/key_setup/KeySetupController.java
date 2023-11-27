package interface_adapter.key_setup;

import use_case.key_setup.KeySetupInputData;
import use_case.key_setup.KeySetupInteractor;

public class KeySetupController {
    private final KeySetupInteractor keySetupInteractor;

    public KeySetupController(KeySetupInteractor keySetupInteractor){
        this.keySetupInteractor = keySetupInteractor;
    }

    public void execute(String key){
        KeySetupInputData keySetupInputData = new KeySetupInputData(key);
        this.keySetupInteractor.execute(keySetupInputData);
    }
}
