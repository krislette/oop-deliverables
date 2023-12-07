import javax.swing.JOptionPane;

public class Calculator {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, 
            "Welcome to my program!", 
            "Calulator", 
            JOptionPane.INFORMATION_MESSAGE);

        double dblFirstNumber = Double.parseDouble(JOptionPane.showInputDialog("Enter first number: "));
        double dblSecondNumber = Double.parseDouble(JOptionPane.showInputDialog("Enter second number: "));
    }

}