package Java.NotePad;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotePadApp {
    private JFrame frame;
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public NotePadApp() {
        frame = new JFrame("Notepad");
        textArea = new JTextArea();
        fileChooser = new JFileChooser();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Set up text area
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(new Color(30, 30, 30)); // Dark background
        textArea.setForeground(Color.WHITE); // Light text
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Set up menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        newMenuItem.addActionListener(new NewFileActionListener());
        openMenuItem.addActionListener(new OpenFileActionListener());
        saveMenuItem.addActionListener(new SaveFileActionListener());
        exitMenuItem.addActionListener(new ExitActionListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        // Set the menu bar
        frame.setJMenuBar(menuBar);

        // Set frame background to match text area background
        frame.getContentPane().setBackground(new Color(30, 30, 30));

        frame.setVisible(true);
    }

    private class NewFileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
        }
    }

    private class OpenFileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser.setDialogTitle("Open File");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.read(reader, null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Could not open file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class SaveFileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser.setDialogTitle("Save File");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().endsWith(".txt")) {
                    file = new File(file.getAbsolutePath() + ".txt");
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    textArea.write(writer);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Could not save file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class ExitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Use the event dispatch thread to build the UI for thread safety
        SwingUtilities.invokeLater(NotePadApp::new);
    }
}
