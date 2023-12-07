// import java.awt.Button;                     // For instantiating buttons.
// import java.awt.Color;
// import java.awt.Label;                      // For instantiating labels.
// import java.awt.FlowLayout;                 // For instantiating FlowLayout().
// import java.awt.Font;
// import java.awt.Frame;                      // For setLayout.
// import java.awt.TextField;                  // For instantiating textfields.
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;       // ! Button Clicks(?)
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;
// import javax.swing.JOptionPane;             // ! For the window(?)
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Calc extends Frame {

    Label lblFirstNumber = new Label("Enter first number: ");
    Label lblSecondNumber = new Label("Enter second number: ");
    TextField txtFieldFirst = new TextField(10);
    TextField txtFieldSecond = new TextField(10);
    Button btnOK = new Button("OK");
    Button btnAddition = new Button("+");
    Button btnSubtraction = new Button("-");
    Button btnMultiplication = new Button("x");
    Button btnDivision = new Button("÷");

    public Calc() {
        setLayout(new GridLayout(6, 1));

        // setBackground(Color.BLACK);

        add(lblFirstNumber);
        add(txtFieldFirst);
        add(lblSecondNumber);
        add(txtFieldSecond);
        add(btnOK);
        add(new Panel()); 

        add(btnAddition);
        add(btnSubtraction);
        add(btnMultiplication);
        add(btnDivision);

        // ! Learn how to resize buttons.
        btnAddition.setSize(1000, 1000);
        btnSubtraction.setSize(1000, 1000);
        btnMultiplication.setSize(1000, 1000);
        btnDivision.setSize(1000, 1000);

        Font lblFont = new Font("Arial", Font.BOLD, 12);
        lblFirstNumber.setFont(lblFont);
        lblSecondNumber.setFont(lblFont);

        // * Event Listeners...
        // btnOK.addActionListener(this);

        // * For closing the window.
        // ! Study this.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionsPerformed(ActionEvent e) {
        if (e.getSource() == btnOK) {
            // What do I want to do when the user clicks ok???
            // TODO: Make textfield uneditable.
            // TODO: Store the values for later manipulation.
        }
    }

    public static void main(String[] args) {
        Calc calculator = new Calc();
        calculator.setSize(300, 400);
        calculator.setVisible(true);
        calculator.setResizable(false);
    }

}