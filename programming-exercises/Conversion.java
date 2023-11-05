import java.util.Scanner;

public class Conversion {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Encloses the main program in a while loop for user repetition.
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("-------------- Money Denominations -------------");
            System.out.println("------------------------------------------------");

            System.out.print("Cash on Hand:\t  "); // Takes the user input for the corresponding amount of cash on hand.
            int intCashOnHand = input.nextInt();

            input.nextLine(); // This line of code consumes the excess new line character left by input.nextInt();
            System.out.println("Denominations:\t  ");
            
            int intOneThousand = intCashOnHand / 1000;
            System.out.println("\t\t  1000 - " + intOneThousand);
            intCashOnHand %= 1000;
    
            int intFiveHundred = intCashOnHand / 500;
            System.out.println("\t\t  500 - " + intFiveHundred);
            intCashOnHand %= 500;
    
            int intOneHundred = intCashOnHand / 100;
            System.out.println("\t\t  100 - " + intOneHundred);
            intCashOnHand %= 100;
    
            int intFifty = intCashOnHand / 50;
            System.out.println("\t\t  50 - " + intFifty);
            intCashOnHand %= 50;
    
            int intTwenty = intCashOnHand / 20;
            System.out.println("\t\t  20 - " + intTwenty);
            intCashOnHand %= 20;
    
            int intTen = intCashOnHand / 10;
            System.out.println("\t\t  10 - " + intTen);
            intCashOnHand %= 10;
    
            int intFive = intCashOnHand / 5;
            System.out.println("\t\t  5 - " + intFive);
            intCashOnHand %= 5;
    
            int intOne = intCashOnHand / 1;
            System.out.println("\t\t  1 - " + intOne);

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