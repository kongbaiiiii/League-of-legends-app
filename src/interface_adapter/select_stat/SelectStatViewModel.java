package interface_adapter.select_stat;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectStatViewModel extends ViewModel {

    private SelectStatState state = new SelectStatState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SelectStatViewModel() {
        super("Select Stat");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SelectStatState getState() {
        return state;
    }

    public void setState(SelectStatState state) {
        this.state = state;
    }
}
