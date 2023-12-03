package use_case;

import app.Main;
import view.KeySetupView;
import view.LoggedInView;
import view.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;

public class KeySetupTest {
    static boolean popUpDiscovered = false;

    private String validKey;

    public void clearFile(String filepath){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(filepath));
            writer.write("");
            writer.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void clearKey(){
        BufferedWriter writer;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("authoKey.csv"));
            validKey = reader.readLine();
            writer = new BufferedWriter(new FileWriter("authoKey.csv"));
            writer.write("somekey");
            writer.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void restoryKey(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("authoKey.csv"));
            writer.write(validKey);
            writer.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Container contentPane = app.getContentPane();

        KeySetupView keySetupView = findKeySetupView(contentPane);

        assertNotNull(keySetupView);

        JPanel buttons = (JPanel) keySetupView.getComponent(2);

        JButton submit = (JButton) buttons.getComponent(0);

        return submit;
    }

    private KeySetupView findKeySetupView(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof KeySetupView) {
                return (KeySetupView) component;
            } else if (component instanceof Container) {
                KeySetupView result = findKeySetupView((Container) component);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public JTextField getTextField(){
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app); // found the window?

        Container contentPane = app.getContentPane();

        KeySetupView keySetupView = findKeySetupView(contentPane);

        assertNotNull(keySetupView);

        JPanel textField = (JPanel) keySetupView.getComponent(1);

        return (JTextField) textField.getComponent(1);
    }

    @org.junit.Test
    public void testSubmitButtonPresent(){
        clearFile("player.csv");
        clearFile("matchdata.csv");
        clearKey();
        Main.Keysetup();
        JButton button = getButton();
        assert(button.getText().equals("Submit"));
    }

    @org.junit.Test
    public void invalidKeyPopUPTest(){
        clearFile("player.csv");
        clearFile("matchdata.csv");
        clearKey();
        Main.Keysetup();
        JButton button = getButton();
        JTextField textField =getTextField();
        textField.setText("somekey");
        createCloseTimer().start();
        button.doClick();
        assert (popUpDiscovered);
    }

    private Timer createCloseTimer() {
        ActionListener close = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Window[] windows = Window.getWindows();
                for (Window window : windows) {

                    if (window instanceof JDialog) {

                        JDialog dialog = (JDialog)window;

                        if (dialog.isVisible()) {
                            System.out.println("found");
                            KeySetupTest.popUpDiscovered = true;

                            window.dispose();
                        }
                    }
                }
            }

        };
        Timer t = new Timer(2000, close);
        t.setRepeats(false);
        return t;
    }
}