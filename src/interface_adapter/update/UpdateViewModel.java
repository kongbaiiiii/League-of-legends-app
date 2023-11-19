package interface_adapter.update;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UpdateViewModel extends ViewModel {

    private final UpdateState state = new UpdateState();

    public final String UPDATE_SUCCESSFUL_MESSAGE = String.format("You have successfully updated %s's statistics", state.getUsername());


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public UpdateViewModel(){
        super("Update Stat");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getUPDATE_SUCCESSFUL_MESSAGE() {
        return UPDATE_SUCCESSFUL_MESSAGE;
    }
}
