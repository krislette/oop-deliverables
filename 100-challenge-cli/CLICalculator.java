import java.util.InputMismatchException;
import java.util.Scanner;

public class CLICalculator {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_DESIGN_LENGTH = 50;
    public static final String STR_DESIGN_STRING = "-";

    // Main method of the program.
    public static void main(String[] args) {
        // Enclose the whole program in a loop for continuous use.
        while (true) {
            displayDesign();
            System.out.println("\t\t\t\b\b\b\bCalculator");
            displayDesign();

            // Lines 19 to 26 gets the user input.
            System.out.println("-> Enter Two Numbers.");
            displayDesign();

            System.out.print("First Number:\t");
            double dblFirstNumber = input.nextDouble();

            System.out.print("Second Number:\t");
            double dblSecondNumber = input.nextDouble();

            displayDesign();
            displayChoices();
            int intChoice = getInput(1, 4);

            // Lines 34 to 36 evaluates and displays the calculation using methods.
            displayDesign();
            double dblResult = doOperation(dblFirstNumber, dblSecondNumber, intChoice);
            System.out.println("Answer: " + dblResult);
            displayDesign();

            // Lines 39 to 44 are responsible for asking the user on program repetition.
            System.out.println("Do you want to use the calculator again?");
            System.out.println("[1] Yes\n[2] No");

            int intContinue = getInput(1, 2);
            if (intContinue == 2) break;
        }

        displayDesign();
        System.out.println("Thank you for using my program.");

        input.close();
        System.exit(0);
    }

    // Method for displaying dashes (for design purposes).
    public static void displayDesign() {
        System.out.println(STR_DESIGN_STRING.repeat(INT_DESIGN_LENGTH));
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

    // Method for displaying the choices.
    public static void displayChoices() {
        System.out.println("-> Choose an Operation.");
        displayDesign();
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
    }

    // Method for doing the operation based on the user choice.
    public static double doOperation(double dblFirstNumber, double dblSecondNumber, int intChoice) {
        double dblResult = 0;

        if (intChoice == 1) {
            System.out.println("Chosen Operation: Addition.");
            dblResult = dblFirstNumber + dblSecondNumber;
        } else if (intChoice == 2) {
            System.out.println("Chosen Operation: Subtraction.");
            dblResult = dblFirstNumber - dblSecondNumber;
        } else if (intChoice == 3) {
            System.out.println("Chosen Operation: Multiplication.");
            dblResult = dblFirstNumber * dblSecondNumber;
        } else {
            System.out.println("Chosen Operation: Division.");
            dblResult = dblFirstNumber / dblSecondNumber;
        }

        return dblResult;
    }

}