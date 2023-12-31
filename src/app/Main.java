package app;

import data_access.AllPurposeDataAccessObject;
import data_access.MatchDataAccessObject;
import data_access.PlayerDataAccessObject;
import data_access.StatPlotDataAccessObject;
import entity.NormalMatchFactory;
import entity.NormalMatchesFactory;
import entity.NormalPlayerFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.apply_selection.ApplySelectionViewModel;
import interface_adapter.check_match.CheckMatchViewModel;
import interface_adapter.check_player_stat_details.CheckPlayerStatDetailsViewModel;
import interface_adapter.key_setup.KeySetupViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LogInViewModel;
import interface_adapter.select_stat.SelectStatViewModel;
import interface_adapter.update.UpdateViewModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static JPanel views;

    public static void main(String[] args) {

        PlayerDataAccessObject playerDataAccessObject;
        try {
            playerDataAccessObject = new PlayerDataAccessObject("player.csv", new NormalPlayerFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean validKey = playerDataAccessObject.validKey();
        if (!validKey) {
            SwingUtilities.invokeLater(() -> {
                Keysetup();
            });

            // Wait for the panel to be closed
            while (!KeySetupView.PanelClose) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("panel closed");
        }


        JFrame application = new JFrame("LOL app");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LogInViewModel loginViewModel = new LogInViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        UpdateViewModel updateViewModel = new UpdateViewModel();
        CheckMatchViewModel checkMatchViewModel = new CheckMatchViewModel();
        KeySetupViewModel keySetupViewModel = new KeySetupViewModel();
        CheckPlayerStatDetailsViewModel checkPlayerStatDetailsViewModel = new CheckPlayerStatDetailsViewModel();
        SelectStatViewModel selectStatViewModel = new SelectStatViewModel();
        ApplySelectionViewModel applySelectionViewModel = new ApplySelectionViewModel();

        AllPurposeDataAccessObject allPurposeDataAccessObject;
        try {
            allPurposeDataAccessObject = new AllPurposeDataAccessObject("matchdata.csv", new NormalMatchFactory(),
                    new NormalMatchesFactory(), "player.csv", new NormalPlayerFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            playerDataAccessObject = new PlayerDataAccessObject("player.csv", new NormalPlayerFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MatchDataAccessObject matchDataAccessObject;
        try {
            matchDataAccessObject = new MatchDataAccessObject("matchdata.csv", new NormalMatchFactory(), new NormalMatchesFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, playerDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = LoggedInViewFactory.create(viewManagerModel, updateViewModel, loggedInViewModel, loginViewModel,
                checkPlayerStatDetailsViewModel, checkMatchViewModel, allPurposeDataAccessObject, matchDataAccessObject,
                playerDataAccessObject, keySetupViewModel, selectStatViewModel);
        views.add(loggedInView, loggedInView.viewName);

        PlayerPlotView playerPlotView = PlayerPlotViewFactory.create(viewManagerModel, checkPlayerStatDetailsViewModel, loggedInViewModel, selectStatViewModel);
        views.add(playerPlotView, playerPlotView.viewName);

        SelectStatView selectDataView = SelectDataViewFactory.create(viewManagerModel, selectStatViewModel, applySelectionViewModel, checkPlayerStatDetailsViewModel, allPurposeDataAccessObject, loggedInViewModel);
        views.add(selectDataView, selectDataView.viewName);

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
            public void run() {
                application.setVisible(true);
            }
        });
    }


    public static void Keysetup() {
        JFrame frame = new JFrame("Key setup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LogInViewModel loginViewModel = new LogInViewModel();
        KeySetupViewModel keySetupViewModel = new KeySetupViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        PlayerDataAccessObject playerDataAccessObject;
        try {
            playerDataAccessObject = new PlayerDataAccessObject("player.csv", new NormalPlayerFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        KeySetupView keySetupView = KeySetupUseCaseFactory.create(loginViewModel, keySetupViewModel,
                viewManagerModel, playerDataAccessObject);

        frame.getContentPane().add(keySetupView);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}