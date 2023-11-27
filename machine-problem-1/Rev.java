import java.util.InputMismatchException;
import java.util.Scanner;

public class Rev {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_DAYS_PER_WEEK = 5;
    public static final int INT_MAX_EMPLOYEES = 5;
    public static final int INT_HOURLY_RATE = 250;
    public static final int INT_WORK_HOURS = 8;
    public static final int INT_DESIGN_LENGTH = 65;
    public static final String STR_DESIGN_STRING = "-";

    // Main method of the program.
    public static void main(String[] args) {
        displayDesign();
        System.out.println("\t\tEmployee Weekly Time Record (DTR)");
        displayDesign();

        // This loop is responsible for looping through the five employees.
        for (int intEmployeeCount = 0; intEmployeeCount < INT_MAX_EMPLOYEES; intEmployeeCount++) {
            System.out.println("\t\t\t   EMPLOYEE " + (intEmployeeCount + 1));
            displayDesign();

            System.out.print("Enter employee ID: ");
            String strEmployeeID = input.nextLine();

            System.out.print("Enter employee name: ");
            String strEmployeeName = input.nextLine();

            // These arrays are responsible for storing all program requirements.
            int[] arrDailyWorkedHours = new int[INT_DAYS_PER_WEEK];
            int[] arrDailySalaries = new int[INT_DAYS_PER_WEEK];
            int[] arrUnderTime = new int[INT_DAYS_PER_WEEK];
            int[] arrOverTime = new int[INT_DAYS_PER_WEEK];
            int intWeeklyTotalIncome = 0;

            // This loop is responsible for looping through the days of the week.
            for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
                arrDailyWorkedHours[i] = getInput(i);
                arrDailySalaries[i] = calculateDailySalary(arrDailyWorkedHours[i]);
                arrUnderTime[i] = calculateUnderTime(arrDailyWorkedHours[i]);
                arrOverTime[i] = calculateOverTime(arrDailyWorkedHours[i]);
                intWeeklyTotalIncome = calculateWeeklyTotalIncome(intWeeklyTotalIncome, arrDailySalaries[i]);
            }

            // Lines 48-59 are responsible for displaying the overall employee's information.
            System.out.println("\nEmployee ID of " + strEmployeeName + ": " + strEmployeeID);
            System.out.println("Employee Weekly Daily Time Record for " + strEmployeeName + ":");

            for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
                System.out.println("\nDay " + (i + 1) + ":");
                System.out.println("Hours Worked: " + arrDailyWorkedHours[i]);
                System.out.println("Daily Salary: PHP " + arrDailySalaries[i]);
                System.out.println("Under Time: " + arrUnderTime[i] + " hour(s)");
                System.out.println("Over Time: " + arrOverTime[i] + " hour(s)");
            }

            System.out.println("\nWeekly Total Income: PHP " + intWeeklyTotalIncome);
            input.nextLine();
            displayDesign();
        }

        System.out.println("Thank you for using Employee Weekly Time Recorder.");
        input.close();
        System.exit(0);
    }

    // Method for calculating the daily salary.
    public static int calculateDailySalary(int intHoursWorked) {
        return intHoursWorked * INT_HOURLY_RATE;
    }

    // Method for calculating the under time.
    public static int calculateUnderTime(int intHoursWorked) {
        return ((INT_WORK_HOURS - intHoursWorked) > 0) ? INT_WORK_HOURS - intHoursWorked : 0;
    }

    // Method for calculating the over time.
    public static int calculateOverTime(int intHoursWorked) {
        return ((intHoursWorked - INT_WORK_HOURS) > 0) ? intHoursWorked - INT_WORK_HOURS : 0;
    }

    // Method for calculating the weekly total income.
    public static int calculateWeeklyTotalIncome(int intWeeklyTotalIncome, int intDailySalary) {
        return intWeeklyTotalIncome += intDailySalary;
    }

    // Method for displaying dashes (for design purposes).
    public static void displayDesign() {
        System.out.println(STR_DESIGN_STRING.repeat(INT_DESIGN_LENGTH));
    }

    // Method for getting a valid input from the user.
    public static int getInput(int intDayCount) {
        int intIntegerInput;

        try {
            System.out.print("Enter hours worked on day " + (intDayCount + 1) + ": ");
            intIntegerInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Enter integer values only.");
            input.nextLine();
            return getInput(intDayCount);
        }

        return intIntegerInput; 
    }

}