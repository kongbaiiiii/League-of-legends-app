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
        try {
            writer = new BufferedWriter(new FileWriter("authoKey.csv"));
            writer.write("somekey");
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

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        LoginView loginView = (LoginView) jp2.getComponent(0);

        JPanel labelText = (JPanel) loginView.getComponent(1);

        return (JTextField) labelText.getComponent(1);
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

//    @org.junit.Test
//    public void errorIDLoginPopUPTest(){
//        clearFile("player.csv");
//        clearFile("matchdata.csv");
//        Main.main(null);
//        JButton button = getButton();
//        JTextField textField =getTextField();
//        textField.setText("asdacavsvca");
//        createCloseTimer().start();
//        button.doClick();
//        assert (popUpDiscovered);
//    }
//
//    @org.junit.Test
//    public void correctIDLoginFileWriteTest(){
//        clearFile("player.csv");
//        clearFile("matchdata.csv");
//        Main.main(null);
//        JButton button = getButton();
//        JTextField textField =getTextField();
//        textField.setText("wrnmbb");
//        button.doClick();
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("player.csv"));
//            String line1 = reader.readLine();
//            String line2 = reader.readLine();
//            assert (line1.equals("wrnmbb") && line2.equals("NcmRba2CroVoIwC20pdtjUpkV-VmwCeLW7Tfy3jm6_Tpt_7ArCpKsMALsioBC3MROaJA-uI0_rGFPA"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private Timer createCloseTimer() {
//        ActionListener close = new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                Window[] windows = Window.getWindows();
//                for (Window window : windows) {
//
//                    if (window instanceof JDialog) {
//
//                        JDialog dialog = (JDialog)window;
//
//                        // this ignores old dialogs
//                        if (dialog.isVisible()) {
//
//                            // store the information we got from the JDialog
//                            LoginTest.popUpDiscovered = true;
//
//                            window.dispose();
//                        }
//                    }
//                }
//            }
//
//        };
//
//        Timer t = new Timer(1000, close);
//        t.setRepeats(false);
//        return t;
//    }
}
