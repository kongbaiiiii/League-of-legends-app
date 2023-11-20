import javax.swing.*;
import java.awt.*;

public class test_view {

    public static void main(String[] args) {
//        JFrame f = new JFrame();
//        f.setVisible(true);
//        f.setSize(600, 400);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel p = new JPanel(new GridBagLayout());
//
//        JButton b1 = new JButton("Button 1");
//        JButton b2 = new JButton("Button 2");
//        b2.setFont(new Font("DIALOG", Font.PLAIN, 12));
//        b2.setForeground(new Color(13, 198, 191));
//
//
//        GridBagConstraints c = new GridBagConstraints();
//
//        c.gridx = 0;
//        c.gridy = 1;
//        p.add(b1, c);
//
//        c.gridx = 0;
//        c.gridy = 2;
//        p.add(b2, c);
//
//        f.add(p, BorderLayout.WEST);
        try {
            // Set the look and feel to Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Button Color Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Click me");
        button.setBackground(new Color(0, 0, 0));
        button.setForeground(new Color(13, 198, 191));

        Font font = new Font("Helvetica", Font.PLAIN, 14);
        button.setFont(font);

        frame.getContentPane().add(button);
        frame.setVisible(true);

    }
}
