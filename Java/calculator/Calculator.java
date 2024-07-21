import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField displayField;
    private JPanel buttonPanel;
    private String operator;
    private double firstOperand;
    private boolean startNewNumber;

    public Calculator() {
        frame = new JFrame("Calculator");
        displayField = new JTextField();
        buttonPanel = new JPanel();
        operator = "";
        firstOperand = 0;
        startNewNumber = true;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        // Set the icon image
        ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Documents\\Repos\\july_2024\\Java\\calculator\\rebound.png");
        frame.setIconImage(icon.getImage());

        // Set dark theme colors
        Color backgroundColor = new Color(45, 45, 45); // Dark background
        Color textColor = new Color(230, 230, 230); // Light text color
        Color buttonColor = new Color(70, 70, 70); // Button background color
        Color buttonTextColor = new Color(255, 255, 255); // Button text color

        frame.getContentPane().setBackground(backgroundColor);

        displayField.setFont(new Font("Arial", Font.PLAIN, 40));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setBackground(backgroundColor);
        displayField.setForeground(textColor);
        frame.add(displayField, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(4, 4));
        buttonPanel.setBackground(backgroundColor);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setBackground(buttonColor);
            button.setForeground(buttonTextColor);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                displayField.setText("");
                firstOperand = 0;
                operator = "";
                startNewNumber = true;
            } else if (command.equals("=")) {
                double secondOperand = Double.parseDouble(displayField.getText());
                switch (operator) {
                    case "+":
                        displayField.setText(String.valueOf(firstOperand + secondOperand));
                        break;
                    case "-":
                        displayField.setText(String.valueOf(firstOperand - secondOperand));
                        break;
                    case "*":
                        displayField.setText(String.valueOf(firstOperand * secondOperand));
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            displayField.setText(String.valueOf(firstOperand / secondOperand));
                        } else {
                            displayField.setText("Error");
                        }
                        break;
                }
                operator = "";
                startNewNumber = true;
            } else if ("+-*/".contains(command)) {
                firstOperand = Double.parseDouble(displayField.getText());
                operator = command;
                startNewNumber = true;
            } else {
                if (startNewNumber) {
                    displayField.setText(command);
                    startNewNumber = false;
                } else {
                    displayField.setText(displayField.getText() + command);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
