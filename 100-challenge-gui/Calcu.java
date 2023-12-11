import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class Calcu extends Frame {
    // Components of the Frame.
    private TextField display;
    private Button[] numberButtons;
    private Button[] operationButtons;
    private Button equalsButton;
    private Button clearButton;

    // Current state of the calculator.
    private double dblNum1, dblNum2, dblResult;
    private char chrOperator;

    public Calcu() {
        // Set frame properties.
        setTitle("Arithmetic Calculator");
        setSize(300, 350);
        setLayout(new BorderLayout(10, 10));

        // Display text field.
        display = new TextField("", 20);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Number buttons.
        numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(new NumberButtonListener());
        }

        // Operation buttons.
        operationButtons = new Button[4];
        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = new Button(operators[i]);
            operationButtons[i].addActionListener(new OperationButtonListener());
        }

        // Equals and Clear buttons.
        equalsButton = new Button("=");
        equalsButton.addActionListener(new EqualsButtonListener());
        clearButton = new Button("C");
        clearButton.addActionListener(new ClearButtonListener());

        // Panel for buttons.
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        setBackground(Color.WHITE);

        // Add number buttons to the panel.
        for (int i = 1; i <= 9; i += 3) {
            buttonPanel.add(numberButtons[i]);
            buttonPanel.add(numberButtons[i + 1]);
            buttonPanel.add(numberButtons[i + 2]);
        }

        buttonPanel.add(numberButtons[0]); // Add zero button.
        // Add operation buttons to the panel.
        buttonPanel.add(operationButtons[0]); // Addition (+)
        buttonPanel.add(operationButtons[1]); // Subtraction (-)
        buttonPanel.add(operationButtons[2]); // Multiplication (*)
        buttonPanel.add(operationButtons[3]); // Division (/)
        buttonPanel.add(equalsButton);         // Equals (=)
        buttonPanel.add(clearButton);          // Clear (C)

        // Make the panel border centered.
        add(buttonPanel, BorderLayout.CENTER);

        // Set frame visibility.
        setVisible(true);

        // Add terminate window listener.
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    // Action listener classes.
    private class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get the button that was clicked.
            Button button = (Button) e.getSource();
            display.setText(display.getText() + button.getLabel());
        }
    }

    private class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Button button = (Button) e.getSource();
            // Get the first number.
            dblNum1 = Double.parseDouble(display.getText());
            // Get the operator.
            chrOperator = button.getLabel().charAt(0);
            display.setText("");
        }
    }

    private class EqualsButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (!display.getText().isEmpty()) {
            dblNum2 = Double.parseDouble(display.getText());
            // Perform the operation.
            switch (chrOperator) {
                case '+':
                    dblResult = dblNum1 + dblNum2;
                    break;
                case '-':
                    dblResult = dblNum1 - dblNum2;
                    break;
                case '*':
                    dblResult = dblNum1 * dblNum2;
                    break;
                case '/':
                    if (dblNum2 != 0) {
                        dblResult = dblNum1 / dblNum2;
                    } else {
                        display.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(dblResult));
            dblNum1 = dblResult; // Set the result as the new first number for further calculations
        }
    }
}

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Clear the display.
            display.setText("");
            dblNum1 = dblNum2 = dblResult = 0;
        }
    }

    public static void main(String[] args) {
        // Display a welcome message.
        JOptionPane.showMessageDialog(null, "Welcome to my Calculator :)", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        // Create a calculator object.
        Calcu calcu = new Calcu();
        // Set the calculator frame properties.
        calcu.setVisible(true);
        calcu.setResizable(false);
    }
}