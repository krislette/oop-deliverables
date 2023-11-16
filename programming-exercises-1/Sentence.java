import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Sentence {

    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------");
        System.out.println("\t\t\bSentence Sorting Program");
        System.out.println("-------------------------------------------------------");

        System.out.print("Enter a sentence: ");
        String strSentence = input.nextLine();

        // Splits the string into words, excluding white space(s) and puntuation(s).
        String[] strResult = strSentence.split("[^0-9a-z-A-Z]+");
        
        // This block of code will ask for the user to choose between ASC or DES.
        System.out.println("-------------------------------------------------------");
        System.out.println("Choose a sorting rule:\n[ASC] Ascending order\n[DES] Descending order");
        System.out.print("Choice: ");
        String strChoice = input.nextLine().toUpperCase(); // Uppercasing the input.
        System.out.println("-------------------------------------------------------");

        /* I used a brute force approach in sorting the words using bubble sort algorithm.
         * After the words are sorted alphabetically, they will be sorted based on the length.
         * I used a switch case instead of an if-else block to make it more readable.
         */
        switch (strChoice) {
            case "ASC": {
                Arrays.sort(strResult);                                 // Sorts the words from A-Z.
                for (int i = 0; i < strResult.length - 1; i++) {
                    for (int j = 0; j < strResult.length - i - 1; j++) {
                        if (strResult[j].length() > strResult[j + 1].length()) {
                            String strTemp = strResult[j];
                            strResult[j] = strResult[j + 1];
                            strResult[j + 1] = strTemp;
                        }
                    }
                }

                break;
            }
            case "DES": {
                Arrays.sort(strResult, Collections.reverseOrder());     // Sorts the array from Z-A.
                for (int i = 0; i < strResult.length - 1; i++) {
                    for (int j = 0; j < strResult.length - i - 1; j++) {
                        if (strResult[j].length() < strResult[j + 1].length()) {
                            String strTemp = strResult[j];
                            strResult[j] = strResult[j + 1];
                            strResult[j + 1] = strTemp;
                        }
                    }
                }
                
                break;
            }
            default: {
                System.out.println("Invalid input. Enter \"ASC\" or \"DES\" only.");
                System.exit(1);
            }
        }

        // Prints the sorted words using for each loop.
        for (String strWord : strResult) {
            System.out.println(strWord);
        }
        
        // Prints a closing message for the program.
        System.out.println("-------------------------------------------------------");
        System.out.println("Thank you for using my program.");

        // Ends the program properly.
        input.close();
        System.exit(0);
    }

}