package interface_adapter.check_player_stat_details;

import entity.PlayerStats;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class CheckPlayerStatDetailsViewModel extends ViewModel {

    private CheckPlayerStatDetailsState state = new CheckPlayerStatDetailsState();
    public static final String RETURN_MAIN_BUTTON_LABEL = "Return Home Page";
    public static final String SELECT_STAT_BUTTON_LABEL = "Select Stat";

    public CheckPlayerStatDetailsViewModel() {
        super("Check Player Stat Details");
    }


    public void setState(CheckPlayerStatDetailsState state) {
        this.state = state;
        firePropertyChanged();
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CheckPlayerStatDetailsState getState() {
        return state;
    }

    public void setSuccess(boolean b) {
    }

    public void setError(String error) {
    }

}