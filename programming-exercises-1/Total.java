import java.util.Scanner;

public class Total {
    
    public static Scanner input = new Scanner(System.in);
    public static final int INT_SIZE = 10; // Global constant for the array size.
    
    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("\tEven-Odd Total Calculator");
        System.out.println("----------------------------------------");
        
        // Declared the array that will store all the integer user inputs.
        int[] arrNumbers = new int[INT_SIZE]; 
        
        // Block of code for getting the user inputs.
        System.out.println("Enter " + INT_SIZE + " integers.\n");
        for (int i = 0; i < INT_SIZE; i++) {
            System.out.print("Number " + (i + 1) + "\t\b\b\b-> ");
            arrNumbers[i] = input.nextInt();
        }

        // Initialized the variables to be used for storing all required results.
        int intEvenCount = 0;
        int intOddCount = 0;
        int intEvenTotal = 0;
        int intOddTotal = 0;

        // Loop for getting the total count and total sum for both even and odd integers.
        for (int i = 0; i < INT_SIZE; i++) {
            if (arrNumbers[i] % 2 == 0) {
                intEvenTotal += arrNumbers[i];
                intEvenCount++;
            } else {
                intOddTotal += arrNumbers[i];
                intOddCount++;
            }
        }

        // Prints all the desired program outcomes.
        System.out.println("----------------------------------------");
        System.out.println("Count of Even Numbers\t   : " + intEvenCount);
        System.out.println("Total Sum of Even Numbers  : " + intEvenTotal);
        System.out.println("Count of Odd Numbers\t   : " + intOddCount);
        System.out.println("Total Sum of Odd Numbers   : " + intOddTotal);
        System.out.println("----------------------------------------");
        
        System.out.println("Thank you for using my program.");

        // Ends the program properly.
        input.close();
        System.exit(0);
    }

}