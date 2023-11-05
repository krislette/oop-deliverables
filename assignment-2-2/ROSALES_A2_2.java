import java.util.Scanner;

public class ROSALES_A2_2 {

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Start with getting the user input for day of the week.
        System.out.println("---------------------------------------------");
        System.out.print("Enter day of the Week:\t\t\t");
        int intDay = input.nextInt();

        // Initialize the variable for the corresponding number of working hours for each day.
        int intWorkingHours = 0;

        // Evaluates the corresponding day of the week based on the number input.
        if (intDay == 1)  {
            intWorkingHours = 0;
        } else if (intDay > 1 && intDay < 6) {
            intWorkingHours = 8;
        } else if (intDay == 6) {
            intWorkingHours = 7;
        } else if (intDay == 7) {
            intWorkingHours = 4;
        } else {
            System.out.println("Invalid input. Enter numbers from 1-7 only.");
            System.exit(1);
        }

        // Proceed with getting the user input for number of hours worked.
        System.out.print("Enter Number of Hours Worked:\t\t");
        int intHoursWorked = input.nextInt();

        // Evaluates the working hours with respect to the hours worked.
        if (intHoursWorked > intWorkingHours) {
            System.out.println("Overtime " + (intHoursWorked - intWorkingHours) + " Hour(s)");
        } else if (intHoursWorked < intWorkingHours) {
            System.out.println("Undertime " + (intWorkingHours - intHoursWorked) + " Hour(s)");
        } else {
            System.out.println("Worked Regular Hour(s)");
        }

        // Prints a message to indicate the completion of the program.
        System.out.println("---------------------------------------------");
        System.out.println("Thank you for using the program!");

        System.exit(0);
    }

}