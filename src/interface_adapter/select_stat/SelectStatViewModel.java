package interface_adapter.select_stat;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectStatViewModel extends ViewModel {

    public static String APPLY_STAT_BUTTON_LABEL = "Apply Selection";

    public static String ASSISTS_CHECK_BOX_LABEL = "Assists";
    public static String ASSISTS_CHECK_BOX_VALUE = "assists";
    public static String DEATHS_CHECK_BOX_LABEL = "Deaths";
    public static String DEATHS_CHECK_BOX_VALUE = "deaths";
    public static String KILLS_CHECK_BOX_LABEL = "Kills";
    public static String KILLS_CHECK_BOX_VALUE = "kills";
    public static String KDA_CHECK_BOX_LABEL = "KDA";
    public static String KDA_CHECK_BOX_VALUE = "kda";
    public static String BOUNTY_LEVEL_CHECK_BOX_LABEL = "Bounty Level";
    public static String BOUNTY_LEVEL_CHECK_BOX_VALUE = "bountyLevel";
    public static String CS_CHECK_BOX_LABEL = "CS";
    public static String CS_CHECK_BOX_VALUE = "cs";
    public static String GAME_WON_CHECK_BOX_LABEL = "GAME WON";
    public static String GAME_WON_CHECK_BOX_VALUE = "win";
    public static String EARLY_SURRENDER_CHECK_BOX_LABEL = "Early Surrender";
    public static String EARLY_SURRENDER_CHECK_BOX_VALUE = "gameEndedInEarlySurrender";
    public static String LONGEST_LIVING_TIME_CHECK_BOX_LABEL = "Longest Living Time";
    public static String LONGEST_LIVING_TIME_CHECK_BOX_VALUE = "longestTimeSpentLiving";
    public static String TIME_CC_OTHERS_CHECK_BOX_LABEL = "Time CCing Others";
    public static String TIME_CC_OTHERS_CHECK_BOX_VALUE = "timeCCingOthers";
    public static String TOTAL_DEAD_TIME_CHECK_BOX_LABEL = "Total Time Spent Dead";
    public static String TOTAL_DEAD_TIME_CHECK_BOX_VALUE = "totalTimeSpentDead";
    public static String GOLD_EARNED_CHECK_BOX_LABEL = "Gold Earned";
    public static String GOLD_EARNED_CHECK_BOX_VALUE = "goldEarned";
    public static String DAMAGE_DEALT_CHECK_BOX_LABEL = "Total Damage Dealt";
    public static String DAMAGE_DEALT_CHECK_BOX_VALUE = "totalDamageDealt";
    public static String DAMAGE_TAKEN_CHECK_BOX_LABEL = "Total Damage Taken";
    public static String DAMAGE_TAKEN_CHECK_BOX_VALUE = "totalDamageTaken";

    private SelectStatState state = new SelectStatState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SelectStatViewModel() {
        super("Select Stat View");
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
