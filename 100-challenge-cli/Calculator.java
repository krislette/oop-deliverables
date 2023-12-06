import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Calculator");

        System.out.println("Enter Two Numbers.");
        System.out.print("First Number:\t");
        double dblFirstNumber = input.nextDouble();
        
        System.out.print("Second Number:\t");
        double dblSecondNumber = input.nextDouble();

        displayChoices();
        int intChoice = getInput(1, 4);
        
        double dblResult = doOperation(dblFirstNumber, dblSecondNumber, intChoice);
        System.out.println("Answer: " + dblResult);
    }

    // Method for checking if the input is within the range of the choices.
    public static boolean isValid(int intUserInput, int intMin, int intMax) {
        return ((intUserInput >= intMin) && (intUserInput <= intMax));
    }

    // Method with error handling for getting the valid user input.
    public static int getInput(int intMin, int intMax) {
        int intUserInput;

        try {
            System.out.print("Choice: ");
            intUserInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input." + " Enter integer values only.");
            input.nextLine();
            return getInput(intMin, intMax);
        }
        
        if (!isValid(intUserInput, intMin, intMax)) {
            System.out.printf("Invalid input. Enter numbers from %d-%d only.\n", intMin, intMax);
            return getInput(intMin, intMax);
        }

        return intUserInput;
    }

    //
    public static void displayChoices() {
        System.out.println("Choose an Operation.");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
    }

    //
    public static double doOperation(double dblFirstNumber, double dblSecondNumber, int intChoice) {
        double dblResult = 0;

        if (intChoice == 1) {
            System.out.println("You Chose Addition.");
            dblResult = dblFirstNumber + dblSecondNumber;
        } else if (intChoice == 2) {
            System.out.println("You Chose Subtraction.");
            dblResult = dblFirstNumber - dblSecondNumber;
        } else if (intChoice == 3) {
            System.out.println("You Chose Multiplication.");
            dblResult = dblFirstNumber * dblSecondNumber;
        } else {
            System.out.println("You Chose Division.");
            dblResult = dblFirstNumber / dblSecondNumber;
        }

        return dblResult;
    }

}