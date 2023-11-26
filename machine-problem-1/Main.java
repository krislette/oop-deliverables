import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_EMPLOYEE_SIZE = 5;
    public static final int INT_DAYS_PER_WEEK = 5;
    public static final int INT_DASH_LENGTH = 55;

    public static void main(String[] args) {
        System.out.println("Employee Weekly Time Record (DTR)");

        for (int i = 0; i < INT_EMPLOYEE_SIZE; i++) {
            displayDashes();
            System.out.print("Enter employee name: ");
            String strName = input.nextLine();
            int[] arrDailyHours = inputWorkedHours();

            int[] arrDailySalary = calculateDailySalary(arrDailyHours);
            int[] arrUnderTime = calculateUnderTime(arrDailyHours);
            int[] arrOverTime = calculateOverTime(arrDailyHours);

            System.out.println("\nEmplyoyee Weekly Daily Time Record for " + strName);
            displayDailyInformation(arrDailyHours, arrDailySalary, arrUnderTime, arrOverTime);

            int intWeeklyIncome = calculateWeeklyTotalIncome(arrDailySalary);
            displayWeeklyIncome(intWeeklyIncome);
            input.nextLine();
        }

        input.close();
    }

    public static int[] inputWorkedHours() {
        int[] arrDailyHours = new int[INT_DAYS_PER_WEEK];

        for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
            System.out.print("Enter hours worked on day " + (i + 1) + ": ");
            int intWorkedHours = input.nextInt();
            arrDailyHours[i] = intWorkedHours;
        }

        return arrDailyHours;
    }

    public static int[] calculateDailySalary(int[] arrDailyHours) {
        int[] arrDailySalary = new int[INT_DAYS_PER_WEEK];
        int intHourlyRate = 250;

        for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
            arrDailySalary[i] = intHourlyRate * arrDailyHours[i];
        }

        return arrDailySalary;
    }

    public static int[] calculateUnderTime(int[] arrDailyHours) {
        int[] arrUnderTime = new int[INT_DAYS_PER_WEEK];
        int intStandardHours = 8;

        for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
            arrUnderTime[i] = (intStandardHours - arrDailyHours[i] > 0) ? 
                                intStandardHours - arrDailyHours[i] : 0;
        }

        return arrUnderTime;
    }

    public static int[] calculateOverTime(int[] arrDailyHours) {
        int[] arrOverTime = new int[INT_DAYS_PER_WEEK];
        int intStandardHours = 8;

        for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
            arrOverTime[i] = ((arrDailyHours[i] - intStandardHours) > 0) ? 
                                arrDailyHours[i] - intStandardHours : 0;
        }

        return arrOverTime;
    }

    public static void displayDailyInformation(int[] arrDailyHours, int[] arrDailySalary, 
                                                int[] arrUnderTime, int[] arrOverTime) {
        for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
            System.out.println("\nDay " + (i + 1) + ":");
            System.out.println("Hours Worked: " + arrDailyHours[i]);
            System.out.println("Daily Salary: PHP" + arrDailySalary[i]);
            System.out.println("Under Time: " + arrUnderTime[i] + " hour(s)");
            System.out.println("Over Time: " + arrOverTime[i] + " hour(s)");
        }
    }

    public static int calculateWeeklyTotalIncome(int[] arrDailySalary) {
        int intWeeklyIncome = 0;

        for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
            intWeeklyIncome += arrDailySalary[i];
        }

        return intWeeklyIncome;
    }

    public static void displayWeeklyIncome(int intWeeklyIncome) {
        System.out.println("Weekly Total Income: PHP" + intWeeklyIncome);
    }

    // Method for checking if the input is within the range of the choices.
    public static boolean isValid(int intUserInput, int intMin, int intMax) {
        return !((intUserInput >= intMin) && (intUserInput <= intMax)) ? false : true;
    }

    public static void displayDashes() {
        System.out.print("-".repeat(INT_DASH_LENGTH));
        System.out.println();
    }

}