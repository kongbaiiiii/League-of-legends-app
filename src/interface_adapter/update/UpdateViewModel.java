package interface_adapter.update;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UpdateViewModel extends ViewModel {

    private UpdateState state = new UpdateState();

    public String UPDATE_SUCCESSFUL_MESSAGE = "You have successfully updated %s's statistics";


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
        return String.format(UPDATE_SUCCESSFUL_MESSAGE, state.getUsername());
    }

    public void setState(UpdateState state){
        this.state = state;
    }

    public UpdateState getState(){
        return state;
    }
}
