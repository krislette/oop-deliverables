import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Surname_MP1 {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_DASH_LENGTH = 70;

    // Main method of the program.
    public static void main(String[] args) {
        displayDashes();
        System.out.println("\t\t\tString Analysis Toolkit");

        // Enclosed the main program in a loop for it to be repeatable.
        while (true) {
            displayMenu();
            int intChoice = getInput(1, 10);
            input.nextLine();
            
            displayDashes();
            System.out.print("Enter a text: ");
            String strInput = input.nextLine();
            
            evaluateChoice(intChoice, strInput);
        }
    } 

    // Method for displaying dashes (for design purposes).
    public static void displayDashes() {
        for (int i = 0; i < INT_DASH_LENGTH - 1; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }

    // Method with error handling for getting the valid user input.
    public static int getInput(int intMin, int intMax) {
        int intUserInput;
        
        try {
            System.out.print("Choice: ");
            intUserInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Enter integer values only.");
            input.nextLine();
            return getInput(intMin, intMax);
        }
        
        if (!isValid(intUserInput, intMin, intMax)) {
            System.out.printf("Invalid input. Enter numbers from %d-%d only.\n", intMin, intMax);
            return getInput(intMin, intMax);
        }
        
        return intUserInput;
    }

    // Method for checking if the input is within the range of the choices.
    public static boolean isValid(int intUserInput, int intMin, int intMax) {
        if (!((intUserInput >= intMin) && (intUserInput <= intMax))) return false;
        else return true;
    }
    
    // Method for displaying the main menu of the program.
    public static void displayMenu() {
        displayDashes();
        System.out.println("\t\t   Choose a type of string analysis.");
        displayDashes();
        System.out.println("|  1 | String Reversal");
        System.out.println("|  2 | Palindrome Checker");
        System.out.println("|  3 | Anagram Checker");
        System.out.println("|  4 | Word Count");
        System.out.println("|  5 | Character Count");
        System.out.println("|  6 | Substring Finder");
        System.out.println("|  7 | Lower Case Converter");
        System.out.println("|  8 | Upper Case Converter");
        System.out.println("|  9 | Vowel Remover");
        System.out.println("| 10 | Consonant Remover");
        displayDashes();
    }

    // Method for evaluating the user's choice and calling the corresponding method.
    public static void evaluateChoice(int intChoice, String strInput) {
        if (intChoice == 1) reverseString(strInput);
        else if (intChoice == 2) checkPalindrome(strInput);
        else if (intChoice == 3) checkAnagram(strInput);
        else if (intChoice == 4) countWords(strInput);
        else if (intChoice == 5) countCharacters(strInput);
        else if (intChoice == 6) findSubstring(strInput);
        else if (intChoice == 7) convertToLowerCase(strInput);
        else if (intChoice == 8) convertToUpperCase(strInput);
        else if (intChoice == 9) removeVowel(strInput);
        else removeConsonant(strInput);
    }
    
    // Method for removing special characters from the string.
    public static String removeSpecialCharacters(String strInput) {
        return strInput.toLowerCase().replaceAll("[^0-9a-z-A-Z]+", "");
    }

    // Method for [1] reversing the characters inside the string.
    public static void reverseString(String strInput) {
        String strResult = "";
        
        for (int i = strInput.length() - 1; i >= 0; i--) {
            strResult += strInput.charAt(i);
        }
        
        System.out.println("Reversed String: " + strResult);
        displayChoices();
    }
    
    // Method for [2] checking if the string is a palindrome.
    public static void checkPalindrome(String strInput) {
        String strOriginalString = strInput;
        strInput = removeSpecialCharacters(strInput);

        int intLength = strInput.length();
        int intCount = 0;

        for (int i = 0; i < intLength / 2; i++) {
            if (strInput.charAt(i) == strInput.charAt(intLength - i - 1)) {
                intCount++;
            }
        }

        if (intCount == (intLength / 2)) {
            System.out.println(strOriginalString + " is a palindrome.");
        } else {
            System.out.println(strOriginalString + " is not a palindrome.");
        }

        displayChoices();
    }

    // Method for [3] checking if two strings are anagrams of each other.
    public static void checkAnagram(String strInput) {
        System.out.print("Enter another text: ");
        String strTestAnagram = input.nextLine();

        String strFirstString = strInput;
        String strSecondString = strTestAnagram;

        strInput = removeSpecialCharacters(strInput);
        strTestAnagram = removeSpecialCharacters(strTestAnagram);

        if (strInput.length() != strTestAnagram.length()) {
            System.out.println(strFirstString + " and " + strSecondString + " are not anagrams of each other.");
            displayChoices();
            return;
        }

        char[] arrFirstWord = strInput.toCharArray();
        char[] arrSecondWord = strTestAnagram.toCharArray();

        Arrays.sort(arrFirstWord);
        Arrays.sort(arrSecondWord);

        if (Arrays.equals(arrFirstWord, arrSecondWord)) {
            System.out.println(strFirstString + " and " + strSecondString + " are anagrams of each other.");
        } else {
            System.out.println(strFirstString + " and " + strSecondString + " are not anagrams of each other.");
        }

        displayChoices();
    }

    // Method for [4] counting the number of words in the string.
    public static void countWords(String strInput) {
        String[] arrWords = strInput.split("[^0-9a-z-A-Z]+");
        System.out.println("Number of Words: " + arrWords.length);
        displayChoices();
    }

    // Method for [5] counting the number of characters (excluding spaces) in the string.
    public static void countCharacters(String strInput) {
        strInput = strInput.replaceAll(" ", "");
        System.out.println("Number of Characters: " + strInput.length());
        displayChoices();
    }

    // Method for [6] counting the number of occurrences of a substring from a main string.
    public static void findSubstring(String strInput) {
        System.out.print("Enter a substring: ");
        String strSubstring = input.nextLine();

        int intCount = 0;
        int intIndex = strInput.indexOf(strSubstring);

        while (intIndex != - 1) {
            intCount++;
            intIndex = strInput.indexOf(strSubstring, intIndex + 1);
        }
        
        System.out.printf("Count of \"%s\": %d\n", strSubstring, intCount);
        displayChoices();
    }

    // Method for [7] converting the string to lowercase.
    public static void convertToLowerCase(String strInput) {
        System.out.println("Lowercased String: " + strInput.toLowerCase());
        displayChoices();
    }

    // Method for [8] converting the string to uppercase.
    public static void convertToUpperCase(String strInput) {
        System.out.println("Uppercased String: " + strInput.toUpperCase());
        displayChoices();
    }

    // Method for [9] removing the vowels from the string.
    public static void removeVowel(String strInput) {
        System.out.println("No-Vowel String: " + strInput.replaceAll("[AaIiUuEeOo]", ""));
        displayChoices();
    }

    // Method for [10] removing the consonants from the string.
    public static void removeConsonant(String strInput) {
        System.out.println("No-Consonant String: " + strInput.replaceAll("[^AaIiUuEeOo]", ""));
        displayChoices();
    }

    // Method for displaying the choices after the program has been executed.
    public static void displayChoices() {
        displayDashes();
        System.out.println("[1] Go back to main menu.");
        System.out.println("[2] Exit the program.");
        displayDashes();

        int intChoice = getInput(1, 2);

        if (intChoice == 2) {
            displayDashes();
            System.out.println("Program successfully terminated.");
            input.close();
            System.exit(0);
        }
    }

}