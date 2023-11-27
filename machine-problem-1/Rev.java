import java.util.InputMismatchException;
import java.util.Scanner;

public class Rev {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_DAYS_PER_WEEK = 5;
    public static final int INT_MAX_EMPLOYEES = 5;
    public static final int INT_HOURLY_RATE = 250;
    public static final int INT_WORK_HOURS = 8;
    public static final int INT_DASH_LENGTH = 65;
    public static final String STR_DASH = "-";

    public static void main(String[] args) {
        displayDashes();
        System.out.println("\t\tEmployee Weekly Time Record (DTR)");
        displayDashes();

        for (int intEmployeeCount = 0; intEmployeeCount < INT_MAX_EMPLOYEES; intEmployeeCount++) {
            System.out.println("\t\t\t   EMPLOYEE " + (intEmployeeCount + 1));
            displayDashes();

            System.out.print("Enter employee ID: ");
            String strEmployeeID = input.nextLine();

            System.out.print("Enter employee name: ");
            String strEmployeeName = input.nextLine();

            int[] arrDailyWorkedHours = new int[INT_DAYS_PER_WEEK];
            int[] arrDailySalaries = new int[INT_DAYS_PER_WEEK];
            int[] arrUnderTime = new int[INT_DAYS_PER_WEEK];
            int[] arrOverTime = new int[INT_DAYS_PER_WEEK];
            int intWeeklyTotalIncome = 0;

            for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
                // System.out.print("Enter hours worked on day " + (i + 1) + ": ");
                arrDailyWorkedHours[i] = getInput(i);
                arrDailySalaries[i] = calculateDailySalary(arrDailyWorkedHours[i]);
                arrUnderTime[i] = calculateUnderTime(arrDailyWorkedHours[i]);
                arrOverTime[i] = calculateOverTime(arrDailyWorkedHours[i]);
                intWeeklyTotalIncome = calculateWeeklyTotalIncome(intWeeklyTotalIncome, arrDailySalaries[i]);
            }

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
            displayDashes();
        }

        System.out.println("Thank you for using Employee Weekly Time Record.");

        input.close();
        System.exit(0);
    }

    public static int calculateDailySalary(int intHoursWorked) {
        return intHoursWorked * INT_HOURLY_RATE;
    }

    public static int calculateUnderTime(int intHoursWorked) {
        return ((INT_WORK_HOURS - intHoursWorked) > 0) ? INT_WORK_HOURS - intHoursWorked : 0;
    }

    public static int calculateOverTime(int intHoursWorked) {
        return ((intHoursWorked - INT_WORK_HOURS) > 0) ? intHoursWorked - INT_WORK_HOURS : 0;
    }

    public static int calculateWeeklyTotalIncome(int intWeeklyTotalIncome, int intDailySalary) {
        return intWeeklyTotalIncome += intDailySalary;
    }

    public static void displayDashes() {
        System.out.println(STR_DASH.repeat(INT_DASH_LENGTH));
    }

    public static int getInput(int intIterationCount) {
        int intIntegerInput;

        try {
            System.out.print("Enter hours worked on day " + (intIterationCount + 1) + ": ");
            intIntegerInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Enter integer values only.");
            input.nextLine();
            return getInput(intIterationCount);
        }

        return intIntegerInput; 
    }

}