package interface_adapter.check_match;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckMatchViewModel extends ViewModel {

    public final String RETURN_MAIN_BUTTON_LABEL = "Return Home Page";
    private CheckMatchState state = new CheckMatchState();

    public CheckMatchViewModel(){super("Check Match");}

    public void setState(CheckMatchState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CheckMatchState getState(){return state;}

}
