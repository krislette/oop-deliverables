import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rosales_MP1 {

    public static Scanner input = new Scanner(System.in);
    public static final int INT_DASH_LENGTH = 70;
    public static final String STR_SET_PLAIN_TEXT = "\033[0;0m";
    public static final String STR_SET_BOLD_TEXT = "\033[0;1m";

    // Main method of the program.
    public static void main(String[] args) {
        while (true) {
            displayDashes();
            System.out.println("\t\t\t\b\b" + toBold("String Manipulation Toolkit"));
            displayMenu();
            int intChoice = getInput(1, 10);
            input.nextLine();

            displayDashes();
            displayUserDecision(intChoice);
            displayDashes();

            System.out.print(toBold("Enter three sentences: "));
            String strInput = input.nextLine();
            evaluateChoice(intChoice, strInput);
        }
    } 

    // Method for setting a given string to bold format.
    public static String toBold(String strText) {
        return (STR_SET_BOLD_TEXT + strText + STR_SET_PLAIN_TEXT);
    }

    // Method for displaying dashes (for design purposes).
    public static void displayDashes() {
        for (int i = 0; i < INT_DASH_LENGTH - 1; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }

    // Method for checking if the input is within the range of the choices.
    public static boolean isValid(int intUserInput, int intMin, int intMax) {
        return !((intUserInput >= intMin) && (intUserInput <= intMax)) ? false : true;
    }

    // Method with error handling for getting the valid user input.
    public static int getInput(int intMin, int intMax) {
        int intUserInput;

        try {
            System.out.print(toBold("Choice: "));
            intUserInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(toBold("Invalid input.") + " Enter integer values only.");
            input.nextLine();
            return getInput(intMin, intMax);
        }

        if (!isValid(intUserInput, intMin, intMax)) {
            System.out.printf(toBold("Invalid input.") + " Enter numbers from %d-%d only.\n", intMin, intMax);
            return getInput(intMin, intMax);
        }

        return intUserInput;
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

    // Method for displaying the user's choice for clarity.
    public static void displayUserDecision(int intChoice) {
        if (intChoice == 1) System.out.println("-> You chose " + toBold("String Reversal"));
        else if (intChoice == 2) System.out.println("-> You chose " + toBold("Palindrome Checker"));
        else if (intChoice == 3) System.out.println("-> You chose " + toBold("Anagram Checker"));
        else if (intChoice == 4) System.out.println("-> You chose " + toBold("Word Count"));
        else if (intChoice == 5) System.out.println("-> You chose " + toBold("Character Count"));
        else if (intChoice == 6) System.out.println("-> You chose " + toBold("Substring Finder"));
        else if (intChoice == 7) System.out.println("-> You chose " + toBold("Lower Case Converter"));
        else if (intChoice == 8) System.out.println("-> You chose " + toBold("Upper Case Converter"));
        else if (intChoice == 9) System.out.println("-> You chose " + toBold("Vowel Remover"));
        else System.out.println("-> You chose " + toBold("Consonant Remover"));
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

    // Method for [1] reversing the characters inside the string.
    public static void reverseString(String strInput) {
        String strResult = "";

        for (int i = strInput.length() - 1; i >= 0; i--) {
            strResult += strInput.charAt(i);
        }

        System.out.println(toBold("Reversed String: ") + strResult);
        displayChoices();
    }

    // Method for [2] checking if the string is a palindrome.
    public static void checkPalindrome(String strInput) {
        int intLength = strInput.length();
        int intCount = 0;

        for (int i = 0; i < intLength / 2; i++) {
            if (strInput.charAt(i) == strInput.charAt(intLength - i - 1)) {
                intCount++;
            }
        }

        System.out.println(strInput + " is " 
                            + toBold((intCount == intLength / 2) ? "a palindrome." : "not a palindrome."));

        displayChoices();
    }

    // Method for [3] checking if two strings are anagrams of each other.
    public static void checkAnagram(String strInput) {
        System.out.print(toBold("Enter another text: "));
        String strTestAnagram = input.nextLine();

        if (strInput.length() != strTestAnagram.length()) {
            System.out.println(strInput + " and " + strTestAnagram + " are " 
                                + toBold("not anagrams") + " of each other.");
            displayChoices();
            return;
        }

        char[] arrFirstWord = strInput.toCharArray();
        char[] arrSecondWord = strTestAnagram.toCharArray();

        Arrays.sort(arrFirstWord);
        Arrays.sort(arrSecondWord);

        System.out.println(strInput + " and " + strTestAnagram + " are " 
                            + toBold((Arrays.equals(arrFirstWord, arrSecondWord)) ? "anagrams" : "not anagrams") 
                            + " of each other.");

        displayChoices();
    }

    // Method for [4] counting the number of words in the string.
    public static void countWords(String strInput) {
        String[] arrWords = strInput.split("[^0-9a-z-A-Z]+");
        System.out.println(toBold("Number of Words: ") + arrWords.length);
        displayChoices();
    }

    // Method for [5] counting the number of characters (excluding spaces) in the string.
    public static void countCharacters(String strInput) {
        System.out.println(toBold("Number of Characters: ") + strInput.replaceAll(" ", "").length());
        displayChoices();
    }

    // Method for [6] counting the number of occurrences of a substring from a main string.
    public static void findSubstring(String strInput) {
        System.out.print(toBold("Enter a substring: "));
        String strSubstring = input.nextLine();

        int intCount = 0;
        int intIndex = strInput.indexOf(strSubstring);

        while (intIndex != - 1) {
            intCount++;
            intIndex = strInput.indexOf(strSubstring, intIndex + 1);
        }
        
        System.out.printf(toBold("Count of \"%s\": %d\n"), strSubstring, intCount);
        displayChoices();
    }

    // Method for [7] converting the string to lowercase.
    public static void convertToLowerCase(String strInput) {
        System.out.println(toBold("Lowercased String: ") + strInput.toLowerCase());
        displayChoices();
    }

    // Method for [8] converting the string to uppercase.
    public static void convertToUpperCase(String strInput) {
        System.out.println(toBold("Uppercased String: ") + strInput.toUpperCase());
        displayChoices();
    }

    // Method for [9] removing the vowels from the string.
    public static void removeVowel(String strInput) {
        System.out.println(toBold("No-Vowel String: ") + strInput.replaceAll("[AaIiUuEeOo]", ""));
        displayChoices();
    }

    // Method for [10] removing the consonants from the string.
    public static void removeConsonant(String strInput) {
        System.out.println(toBold("No-Consonant String: ") + strInput.replaceAll("[^AaIiUuEeOo]", ""));
        displayChoices();
    }

    // Method for displaying the choices after the program has been executed.
    public static void displayChoices() {
        displayDashes();
        System.out.println(toBold("[1]") + " Go back to main menu.");
        System.out.println(toBold("[2]") + " Exit the program.");
        displayDashes();
        int intChoice = getInput(1, 2);

        if (intChoice == 2) {
            displayDashes();
            System.out.println(toBold("Program successfully terminated."));
            input.close();
            System.exit(0);
        }
    }

}