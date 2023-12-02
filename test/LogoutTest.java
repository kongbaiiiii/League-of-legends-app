import app.Main;
import view.LoggedInView;
import view.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static org.junit.Assert.assertNotNull;

public class LogoutTest {

    static boolean popUpDiscovered = false;

    public void writeDatatoPlayerCSV() {
        BufferedWriter writer1;
        try {
            writer1 = new BufferedWriter(new FileWriter("player.csv"));
            writer1.write("wrnmbb");
            writer1.write('\n');
            writer1.write("NcmRba2CroVoIwC20pdtjUpkV-VmwCeLW7Tfy3jm6_Tpt_7ArCpKsMALsioBC3MROaJA-uI0_rGFPA");
            writer1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeDatatoMatchCSV() {
        BufferedWriter writer1;
        try {
            writer1 = new BufferedWriter(new FileWriter("matchdata.csv"));
            writer1.write("NA1_4846616694");
            writer1.write('\n');
            writer1.write("NA1_4846603846");
            writer1.close();
        } catch (IOException e) {
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

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        LoggedInView loggedInView = (LoggedInView) jp2.getComponent(1);

        JPanel leftpanel = (JPanel) loggedInView.getComponent(0);

        JPanel leftTopsubpanel = (JPanel) leftpanel.getComponent(0);

        JPanel updateandlogout = (JPanel) leftTopsubpanel.getComponent(2);

        return (JButton) updateandlogout.getComponent(1);
    }

    @org.junit.Test
    public void testLogoutButtonPresent() {
        File file1 = new File("player.csv");
        File file2 = new File("matchdata.csv");
        if (file1.length()==0){
            writeDatatoPlayerCSV();
        }
        if (file2.length()==0){
            writeDatatoMatchCSV();
        }
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("Log out"));
    }

    @org.junit.Test
    public void logoutFileClearTest(){
        File file1 = new File("player.csv");
        File file2 = new File("matchdata.csv");
        if (file1.length()==0){
            writeDatatoPlayerCSV();
        }
        if (file2.length()==0){
            writeDatatoMatchCSV();
        }
        Main.main(null);
        JButton button = getButton();
        button.doClick();
        assert (new File("player.csv").length()==0);
    }

}



