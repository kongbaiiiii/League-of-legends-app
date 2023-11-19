package interface_adapter.return_mainpage;

import interface_adapter.ViewModel;
import interface_adapter.check_match.CheckMatchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ReturnMainViewModel extends ViewModel {
    private ReturnMainState state = new ReturnMainState();

    public ReturnMainViewModel(){super("Return Main");}

    public void setState(ReturnMainState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ReturnMainState getState(){return state;}

}
