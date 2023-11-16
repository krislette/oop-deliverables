import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Sort {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_SIZE = 10; // Global constant for the array size.

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------");
        System.out.println("\t\tNumber-Sorting Program");
        System.out.println("-------------------------------------------------------");

        // Declared the array that will store all the double/float user inputs.
        Double[] arrNumbers = new Double[INT_SIZE];

        // Block of code for getting the user inputs.
        System.out.println("Enter " + INT_SIZE + " values one by one.\n");
        for (int i = 0; i < INT_SIZE; i++) {
            System.out.print("Number " + (i + 1) + "\t\b\b\b-> ");
            arrNumbers[i] = input.nextDouble();
        }
        input.nextLine(); // This will consume the new line character.

        // This block of code will ask for the user to choose between ASC or DES.
        System.out.println("-------------------------------------------------------");
        System.out.println("Choose a sorting rule:\n[ASC] Ascending order\n[DES] Descending order");
        System.out.print("Choice: ");
        String strChoice = input.nextLine().toUpperCase(); // Uppercasing the input.
        System.out.println("-------------------------------------------------------");

        // Sorts the array based on the user's choice.
        if (strChoice.equals("ASC")) {
            Arrays.sort(arrNumbers);
        } else if (strChoice.equals("DES")) {
            Arrays.sort(arrNumbers, Collections.reverseOrder());
        } else {
            System.out.println("Invalid input. Enter \"ASC\" or \"DES\" only.");
            System.exit(1);
        }

        // Prints the desired program outcomes.
        System.out.println("Sorted Array " + "[" + strChoice + "]: ");
        System.out.println(Arrays.toString(arrNumbers));
        System.out.println("-------------------------------------------------------");
        
        System.out.println("Thank you for using my program.");

        // Ends the program properly.
        input.close();
        System.exit(0);
    }

}