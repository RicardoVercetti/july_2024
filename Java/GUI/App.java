package Java.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Sample app");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello Swing", SwingConstants.CENTER);
        frame.add(label);

        frame.setVisible(true);
    }
}
