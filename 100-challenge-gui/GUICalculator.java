import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class GUICalculator extends Frame {

    private TextField txtDisplay;
    private Button[] btnNumbers;
    private Button[] btnOperations;
    private Button btnEquals;
    private Button btnClear;

    // Variables for storing the numbers and the result.
    private double dblNum1, dblNum2, dblResult;
    private char chrOperator;

    // Constructor for the GUI Calculator class.
    public GUICalculator() {
        setTitle("Arithmetic Calculator");
        setSize(300, 350);
        setLayout(new BorderLayout(10, 10));

        txtDisplay = new TextField("", 20);
        txtDisplay.setEditable(false);
        add(txtDisplay, BorderLayout.NORTH);

        // This block of code instantiates the buttons.
        btnNumbers = new Button[10];
        for (int i = 0; i < btnNumbers.length; i++) {
            btnNumbers[i] = new Button(String.valueOf(i));
            btnNumbers[i].addActionListener(new NumberButtonListener());
        }

        // This block of code instantiates the operation buttons.
        btnOperations = new Button[4];
        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < btnOperations.length; i++) {
            btnOperations[i] = new Button(operators[i]);
            btnOperations[i].addActionListener(new OperationButtonListener());
        }

        // Instantiate the equals and clear buttons.
        btnEquals = new Button("=");
        btnEquals.addActionListener(new btnEqualsListener());
        btnClear = new Button("C");
        btnClear.addActionListener(new btnClearListener());

        // Create a panel for the buttons.
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        setBackground(Color.WHITE);

        // This block of code adds the number buttons to the panel.
        for (int i = 1; i <= 9; i += 3) {
            buttonPanel.add(btnNumbers[i]);
            buttonPanel.add(btnNumbers[i + 1]);
            buttonPanel.add(btnNumbers[i + 2]);
        }

        buttonPanel.add(btnNumbers[0]);
        buttonPanel.add(btnOperations[0]);
        buttonPanel.add(btnOperations[1]);
        buttonPanel.add(btnOperations[2]);
        buttonPanel.add(btnOperations[3]);
        buttonPanel.add(btnEquals);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.CENTER);

        // Add terminate window listener.
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // This block of code handles the button clicks.
    private class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Button button = (Button) e.getSource();
            txtDisplay.setText(txtDisplay.getText() + button.getLabel());
        }
    }

    // This block of code handles the operation button clicks.
    private class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Button button = (Button) e.getSource();
            dblNum1 = Double.parseDouble(txtDisplay.getText());
            chrOperator = button.getLabel().charAt(0);
            txtDisplay.setText("");
        }
    }

    private class btnEqualsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!txtDisplay.getText().isEmpty()) {
                dblNum2 = Double.parseDouble(txtDisplay.getText());
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
                            txtDisplay.setText("Cannot divide by zero");
                            return;
                        }
                        break;
                }
                txtDisplay.setText(String.valueOf(dblResult));
                dblNum1 = dblResult; // Set the result as the new first number for further calculations
            }
        }
    }

    private class btnClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            txtDisplay.setText("");
            dblNum1 = dblNum2 = dblResult = 0;
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to my Calculator :)", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        GUICalculator calculator = new GUICalculator();
        
        calculator.setVisible(true);
        calculator.setResizable(false);
    }

}