package interface_adapter.check_player_stat_details;

import entity.PlayerStats;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class CheckPlayerStatDetailsViewModel {

    private CheckPlayerStatDetailsState state = new CheckPlayerStatDetailsState();

    public CheckPlayerStatDetailsViewModel() {
        super();
    }

    public List<PlayerStats> getPlayerStats() {
        return state.getPlayerStats();
    }

    public void setPlayerStats(List<PlayerStats> playerStats) {
        state.setPlayerStats(playerStats);
        firePropertyChanged();
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
