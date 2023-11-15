import java.util.Scanner;

public class ROSALES_Pay {
    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Encloses the main program in a while loop for user repetition.
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("---------------- Pay Calculator ----------------");
            System.out.println("------------------------------------------------");

            // Lines 15 up to 19 takes the necessary user inputs.
            System.out.print("Hourly Rate:\t\t");
            double dblHourlyRate = input.nextDouble();
            
            System.out.print("Hours Worked:\t\t");
            double dblHoursWorked = input.nextDouble();
            
            input.nextLine(); // Consumes the excess \n left by input.nextDouble();
            
            // Lines 24 to 30 outputs the necessary information for the user.
            double dblGrossPay = dblHourlyRate * dblHoursWorked;
            System.out.printf("\nGross Pay:\t\t%.2f\n", dblGrossPay);
            
            double dblWithholdingTax = dblGrossPay * 0.15f;
            System.out.printf("Withholding Tax:\t%.3f\n", dblWithholdingTax);
            
            System.out.printf("Net Pay:\t\t%.3f\n", (dblGrossPay - dblWithholdingTax));

            // This block of code is responsible for retrying the program.
            System.out.println("------------------------------------------------");
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