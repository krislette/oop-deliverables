import java.util.Scanner;

public class Vowels {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("\t   String Manipulator Program");
        System.out.println("-------------------------------------------------");

        System.out.print("Enter first string\t: ");
        String strFirstString = input.nextLine();

        System.out.print("Enter second string\t: ");
        String strSecondString = input.nextLine();

        // Line 19 concatenates two strings while line 20 replaces all vowel instances.
        String strConcatenatedString = strFirstString.concat(strSecondString);
        String strResult = strConcatenatedString.replaceAll("[AaIiUuEeOo]", "*");

        // Prints the resulting string(s).
        System.out.println("-------------------------------------------------");
        System.out.println("Concatenated String\t: " + strConcatenatedString);
        System.out.println("No-Vowel String\t\t: " + strResult);
        System.out.println("-------------------------------------------------");

        System.out.println("Thank you for using my program.");

        // Ends the program properly.
        input.close();
        System.exit(0);
    }

}