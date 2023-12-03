package interface_adapter.apply_selection;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ApplySelectionViewModel extends ViewModel {
    public String APPLY_SELECTION_SUCCESSFUL_MESSAGE = "You have successfully applied the stats you want";
    private ApplySelectionState state = new ApplySelectionState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ApplySelectionViewModel() {
        super("Apply Selection");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getAPPLY_SELECTION_SUCCESSFUL_MESSAGE() {
        return String.format(APPLY_SELECTION_SUCCESSFUL_MESSAGE);
    }

    public void setState(ApplySelectionState state) {
        this.state = state;
    }

    public ApplySelectionState getState() {
        return state;
    }
}
