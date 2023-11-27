package use_case.key_setup;

public interface KeySetupDataAccessInterface {
    void setKey(String userInputKey);
    boolean validKey(String key);

    void saveKey();


}
