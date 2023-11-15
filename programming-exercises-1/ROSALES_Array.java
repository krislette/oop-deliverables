import java.util.Arrays;

public class ROSALES_Array {
    
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------");
        System.out.println("------------------ Array Exercise -------------------");
        System.out.println("-----------------------------------------------------");
        
        // Initializes the array to be used all throughout the program.
        int[] arrN = {33, 2, 70, 4, 52, 42, 8, 35, 9, 211};
        int intArrSize = arrN.length;

        /*
         * a) Separate all odd from even numbers
         */
        int[] arrOddNumbers = new int[intArrSize]; // Array for odd numbers.
        int[] arrEvenNumbers = new int[intArrSize]; // Array for even numbers.

        int intOddIndex = 0; // Index variable for odd numbers.
        int intEvenIndex = 0; // Index variable for even numbers.

        // For loop for separating all odd from even numbers.
        for (int i = 0; i < intArrSize; i++) {
            if (arrN[i] % 2 == 0) {
                arrEvenNumbers[intEvenIndex] = arrN[i];
                intEvenIndex++;
            } else {
                arrOddNumbers[intOddIndex] = arrN[i];
                intOddIndex++;
            }
        }

        System.out.println("Odd Numbers: " 
                            + Arrays.toString(Arrays.copyOf(arrOddNumbers, intOddIndex)));
        System.out.println("Even Numbers: " 
                            + Arrays.toString(Arrays.copyOf(arrEvenNumbers, intEvenIndex)));
        System.out.println("-----------------------------------------------------");

        /*
         * b) Display the highest number (without sorting)
         * c) Display the lowest number (without sorting)
         */
        int intHighestNumber = arrN[0];
        int intLowestNumber = arrN[0];

        for (int i = 0; i < intArrSize; i++) {
            // Identifies the highest number in the array.
            if (arrN[i] > intHighestNumber) {
                intHighestNumber = arrN[i];
            }

            // Identifies the lowest number in the array.
            if (arrN[i] < intLowestNumber) {
                intLowestNumber = arrN[i];
            }
        }

        System.out.println("Highest Number: " + intHighestNumber);
        System.out.println("-----------------------------------------------------");
        System.out.println("Lowest Number: " + intLowestNumber);
        System.out.println("-----------------------------------------------------");
        
        /*
         * d) Sort the numbers in ascending order
         */
        Arrays.sort(arrN);
        System.out.println("Sorted Array: " + Arrays.toString(arrN));
        System.out.println("-----------------------------------------------------");

        System.out.println("Thank you for using the program.");
        System.exit(0);
    }

}