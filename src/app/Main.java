package app;

import data_access.AllPurposeDataAccessObject;
import data_access.MatchDataAccessObject;
import data_access.PlayerDataAccessObject;
import entity.NormalMatchFactory;
import entity.NormalMatchesFactory;
import entity.NormalPlayerFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.check_match.CheckMatchViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LogInViewModel;
import interface_adapter.update.UpdateViewModel;
import view.CheckMatchView;
import view.LoggedInView;
import view.LoginView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("LOL app");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LogInViewModel loginViewModel = new LogInViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        UpdateViewModel updateViewModel = new UpdateViewModel();
        CheckMatchViewModel checkMatchViewModel = new CheckMatchViewModel();

        PlayerDataAccessObject playerDataAccessObject;
        try {
            playerDataAccessObject = new PlayerDataAccessObject("player.csv", new NormalPlayerFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AllPurposeDataAccessObject allPurposeDataAccessObject;
        try {
            allPurposeDataAccessObject = new AllPurposeDataAccessObject("matchdata.csv", new NormalMatchFactory(),
                    new NormalMatchesFactory(), "player.csv", new NormalPlayerFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MatchDataAccessObject matchDataAccessObject;
        try {
            matchDataAccessObject = new MatchDataAccessObject("matchdata.csv", new NormalMatchFactory(), new NormalMatchesFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CheckMatchView checkMatchView = CheckMatchViewFactory.create(viewManagerModel, checkMatchViewModel, loggedInViewModel);
        views.add(checkMatchView, checkMatchView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, playerDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = LoggedInViewFactory.create(viewManagerModel, updateViewModel, loggedInViewModel, loginViewModel,
                checkMatchViewModel, allPurposeDataAccessObject, matchDataAccessObject, playerDataAccessObject);
        views.add(loggedInView, loggedInView.viewName);

        File playerFile = new File("player.csv");
        if (playerFile.length() == 0) {
            viewManagerModel.setActiveView(loginView.viewName);
            viewManagerModel.firePropertyChanged();
        } else {
            viewManagerModel.setActiveView(loggedInView.viewName);
            viewManagerModel.firePropertyChanged();
        }

        application.pack();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){application.setVisible(true);}
        });
    }
}
