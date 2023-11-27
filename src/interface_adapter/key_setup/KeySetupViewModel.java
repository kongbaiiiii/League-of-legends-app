package interface_adapter.key_setup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class KeySetupViewModel extends ViewModel {

    public static String SETUP_KEY_LABEL = "Enter a Riot API Key";
    public static String SETUP_KEY_BUTTON_LABEL = "Submit";
    public static final String TITLE_LABEL = "Key Setup View";

    private KeySetupState state = new KeySetupState();

    public KeySetupViewModel(){
        super("Key Setup");
    }

    public void setState(KeySetupState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public KeySetupState getState() {
        return state;
    }
}
