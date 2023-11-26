import java.util.Scanner;

public class Rev {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_DAYS_PER_WEEK = 5;
    public static final int INT_MAX_EMPLOYEES = 5;
    public static final int INT_HOURLY_RATE = 250;
    public static final int INT_WORK_HOURS = 8;

    public static void main(String[] args) {
        int[] arrDailyWorkedHours = new int[INT_DAYS_PER_WEEK];
        int[] arrDailySalaries = new int[INT_DAYS_PER_WEEK];
        int[] arrUnderTime = new int[INT_DAYS_PER_WEEK];
        int[] arrOverTime = new int[INT_DAYS_PER_WEEK];

        int intEmployeeCount = 0;
        while (intEmployeeCount < INT_MAX_EMPLOYEES) {
            System.out.print("Enter employee name: ");
            String strEmployeeName = input.nextLine();
    
            for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
                System.out.print("Enter hours worked on day " + (i + 1) + ": ");
                arrDailyWorkedHours[i] = input.nextInt();
                arrDailySalaries[i] = calculateDailySalary(arrDailyWorkedHours[i]);
                arrUnderTime[i] = calculateUnderTime(arrDailyWorkedHours[i]);
                arrOverTime[i] = calculateOverTime(arrDailyWorkedHours[i]);
            }
    
            System.out.println("Employee Weekly Daily Time Record for " + strEmployeeName);
    
            for (int i = 0; i < INT_DAYS_PER_WEEK; i++) {
                System.out.println("Day " + (i + 1) + ":");
                System.out.println("Hours Worked: " + arrDailyWorkedHours[i]);
                System.out.println("Daily Salary: PHP" + arrDailySalaries[i]);
                System.out.println("Under Time: " + arrUnderTime[i] + " hour(s)");
                System.out.println("Over Time: " + arrOverTime[i] + " hour(s)");
            }

            intEmployeeCount++;
            input.nextLine();
        }

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

}