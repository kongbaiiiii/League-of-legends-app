package view;

import interface_adapter.check_match.CheckMatchController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.update.UpdateController;
import interface_adapter.update.UpdateViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "LOL.GH";

    private final LoggedInViewModel loggedInViewModel;

    private final UpdateController updateController;

    private final UpdateViewModel updateViewModel;

    private final CheckMatchController checkMatchController;



//    TODO: Add CheckPlayerDetailController and LogoutController.
//    private final LogoutController logoutController;
//    private final CheckPlayerDetailController checkPlayerDetailController;

    private final JButton update;

    private final JButton checkMatch;

//    private final JButton logout;
//    private final JButton checkPlayerStatsDetail;


    public LoggedInView(LoggedInViewModel loggedInViewModel, UpdateController updateController, UpdateViewModel updateViewModel, CheckMatchController checkMatchController) {
        this.loggedInViewModel = loggedInViewModel;
        this.updateController = updateController;
        this.updateViewModel = updateViewModel;
        this.checkMatchController = checkMatchController;

        JPanel buttons = new JPanel();
//        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
//        buttons.add(signUp);
//        cancel = new JButton(SignupViewModel.CANCEL_BUTTON_LABEL);
//        buttons.add(cancel);
        update = new JButton(loggedInViewModel.UPDATA_STAT_BUTTON_LABEL);
        checkMatch = new JButton(loggedInViewModel.CHECK_MATCH_DETAIL_BUTTON_LABEL);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(update)) {
                    updateController.execute(loggedInViewModel.getLoggedInPlayer(), "kills", "deathds", "assissts", "cs", "goldEarned");
                }
                }
            });

        checkMatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(checkMatch)){
                    checkMatchController.execute();
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(update);
        this.add(checkMatch);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
