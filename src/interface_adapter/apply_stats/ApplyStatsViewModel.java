package interface_adapter.apply_stats;

import interface_adapter.apply_stats.ApplyStatsState;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ApplyStatsViewModel {
    private ApplyStatsState state;
    private final PropertyChangeSupport support;

    public ApplyStatsViewModel() {
        this.state = new ApplyStatsState();
        this.support = new PropertyChangeSupport(this);
    }

    public ApplyStatsState getState() {
        return state;
    }

    public void setState(ApplyStatsState state) {
        ApplyStatsState oldState = this.state;
        this.state = state;
        support.firePropertyChange("state", oldState, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setErrorMessage(String errorMessage) {
    }
}
