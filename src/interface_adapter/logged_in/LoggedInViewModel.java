package interface_adapter.logged_in;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Logged In View";

    public final String SUMMARY_GRAPH_TITLE = "Recent Stat";
    public final String CHECK_MATCH_DETAIL_BUTTON_LABEL = "Check Detail";

    public final String UPDATA_STAT_BUTTON_LABEL = "Update";

    private LoggedInState state = new LoggedInState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    private String loggedInPlayer;

    public LoggedInViewModel() {
        super("LOL.GH");
    }

    public void setState(LoggedInState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoggedInState getState() {
        return state;
    }


    public String getLoggedInPlayer() {
        return loggedInPlayer;
    }

    public void setLoggedInPlayer(String loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }
}
