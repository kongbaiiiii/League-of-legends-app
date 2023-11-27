package interface_adapter.key_setup;

public class KeySetupState {
    private String key = "";

    private String keyError = null;

    public KeySetupState(KeySetupState copy){
        this.key = copy.key;
        this.keyError = copy.keyError;
    }

    public KeySetupState() {
    }

    public String getKey(){return key;}

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyError() {
        return keyError;
    }

    public void setKeyError(String keyError) {
        this.keyError = keyError;
    }

    @Override
    public String toString() {
        return key;
    }
}
