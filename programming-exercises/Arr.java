package programmingExercises;

import java.util.Arrays;

public class Arr {
    
    public static void main(String[] args) {
        // Prints the introductory text.
        System.out.println("-----------------------------------------------------");
        System.out.println("------------------ Array Exercise -------------------");
        System.out.println("-----------------------------------------------------");
        
        // Initializes the array and its size which will be used all throughout the program.
        int[] arrNumbers = {33, 2, 70, 4, 52, 42, 8, 35, 9, 211};
        int intArrSize = arrNumbers.length;

        /*
         * a) Separate all odd from even numbers
         */
        int[] arrOddNumbers = new int[intArrSize]; // Initializes the array for odd numbers.
        int[] arrEvenNumbers = new int[intArrSize]; // Initializes the array for even numbers.

        int intOddIndex = 0; // Initializes the index variable for odd numbers.
        int intEvenIndex = 0; // Initializes the index variable for even numbers.

        // For loop for separating all odd from even numbers.
        for (int i = 0; i < intArrSize; i++) {
            if (arrNumbers[i] % 2 == 0) {
                arrEvenNumbers[intEvenIndex] = arrNumbers[i];
                intEvenIndex++;
            } else {
                arrOddNumbers[intOddIndex] = arrNumbers[i];
                intOddIndex++;
            }
        }

        // Prints the two separate arrays.
        System.out.println("Odd Numbers: " + 
                            Arrays.toString(Arrays.copyOf(arrOddNumbers, intOddIndex)));
        System.out.println("Even Numbers: " + 
                            Arrays.toString(Arrays.copyOf(arrEvenNumbers, intEvenIndex)));
        System.out.println("-----------------------------------------------------");

        /*
         * b) Display the highest number (without sorting)
         * c) Display the lowest number (without sorting)
         */
        int intHighestNumber = arrNumbers[0];
        int intLowestNumber = arrNumbers[0];

        for (int i = 0; i < intArrSize; i++) {
            // Identifies the highest number in the array.
            if (arrNumbers[i] > intHighestNumber) {
                intHighestNumber = arrNumbers[i];
            }

            // Identifies the lowest number in the array.
            if (arrNumbers[i] < intLowestNumber) {
                intLowestNumber = arrNumbers[i];
            }
        }

        // Prints the (a) highest number and (b) lowest number.
        System.out.println("Highest Number: " + intHighestNumber);
        System.out.println("-----------------------------------------------------");
        System.out.println("Lowest Number: " + intLowestNumber);
        System.out.println("-----------------------------------------------------");
        
        /*
        * d) Sort the numbers in ascending order
        */
        Arrays.sort(arrNumbers);
        System.out.println("Sorted Array: " + Arrays.toString(arrNumbers));
        System.out.println("-----------------------------------------------------");

        System.out.println("Thank you for using the program.");
        System.exit(0);
    }

}