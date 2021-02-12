
import java.util.Scanner;

/*
This program rads a sequence of positive integers input
by the user, and it will print out the average of those
integers. The user is prompted to enter one integer at a
time. The user must enter a 0 to mark the end of the
data. ( The zero is not counted as part of the data to
be averaged.) The program does not check whether the
user's input is positive. So it will actually add up
both positive and negative input values.
 */

public class computeAverage {

    public static void main( String[] args ) {

        Scanner stdin = new Scanner( System.in );
        int inputNumber;  // One of the integers input by the user.
        int sum;  // The sum of the positive integers.
        int count;  // The number of positive integers.
        double average;  // The average of the positive integers.

        // Initialize the summation and counting variables.
        sum = 0;
        count = 0;

        // Read and process the user's input.
        System.out.print( "Enter your first positive integer: " );
        inputNumber = stdin.nextInt();

        while ( inputNumber != 0 ) {
            sum += inputNumber;  // Add input number to running sum.
            count++;
            System.out.print( "Enter your next positive integer, or 0 to end: " );
            inputNumber = stdin.nextInt();
        }
        // Display the result.
        if ( count == 0 ) {
            System.out.println( "You did not enter any data!!" );

        }
        else {
            average = ( ( double ) sum ) / count;  // The average is a real number.
            System.out.println();
            System.out.printf( "You entered %d positive integers.\n", count );
            System.out.printf( "Their average is %1.3f.\n", average );

        }  // end of main().

    }  // end of class ComputeAverage.
}
