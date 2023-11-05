package programmingExercises;

import java.util.Scanner;

public class Time {
    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Encloses the main program in a while loop for user repetition.
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("---------------- Time Converter ----------------");
            System.out.println("------------------------------------------------");

            System.out.print("Enter number of minutes worked: "); // Takes the user input for the corresponding minutes worked.
            int intMinutesWorked = input.nextInt();

            input.nextLine(); // This line of code consumes the excess new line character left by input.nextInt();
            
            // Evaluates the conversion.
            int intHours = intMinutesWorked / 60;
            int intMinutes = intMinutesWorked % 60;
            
            // This block of code prints all the necessary information for the user.
            System.out.println("------------------------------------------------\n");
            System.out.println("Given Time (mins): " + intMinutesWorked + " minutes");
            System.out.println("Conversion:\t   " + intHours + " hours and " + intMinutes + " minute/s");

            // This block of code is responsible for retrying the program.
            System.out.println("\n------------------------------------------------");
            System.out.println("Do you want to use the program again?\n-> Enter \"yes\" if so, or enter any key if not.");
            System.out.println("------------------------------------------------");
            System.out.print("Answer: ");
            String strAnswer = input.nextLine().toLowerCase();

            if (strAnswer.equals("yes")) continue;
            else break;
        }

        System.out.println("------------------------------------------------");
        System.out.println("Thank you for using the program.");
        
        input.close(); // This line of code closes the scanner.
        System.exit(0); 
    }
    
}