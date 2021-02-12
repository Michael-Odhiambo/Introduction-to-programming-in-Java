
import java.util.Scanner;

/*
This program reads a positive integer from the user.
It counts how many divisors that number has, and
then it prints the result.
 */

public class CountDivisors {

    public static void main( String[] args ) {

        double startTime, endTime;

        startTime = System.nanoTime();

        // Create a Scanner object for input.
        Scanner stdin = new Scanner( System.in );

        // A positive integer entered by the user. Divisors of this number will be counted.
        int N;
        // A number between 1 and N that is a possible divisor of N.
        int testDivisor;
        // Number of divisors of N that have been found.
        int divisorCount;
        // Used to count how many possible divisors of N have been tested. When the number
        // reaches 10000000, a period is output and the value of numberTested is reset to zero.
        int numberTested;

        // Get a positive integer from the user.
        while ( true ) {
            System.out.print( "Enter a positive integer: " );
            N = stdin.nextInt();
            if ( N > 0 )
                break;
            System.out.println( "That number is not positive. Please try again." );

        }

        // Count the divisors, printing a "." after every 10000000 tests.
        divisorCount = 0;
        numberTested = 0;

        for ( testDivisor = 1; testDivisor <= N; testDivisor++ ) {
            if ( N % testDivisor == 0 )
                divisorCount ++;
            numberTested++;
            if ( numberTested == 10000000 ) {
                System.out.println( "." );
                numberTested = 0;
            }
        }

        // Display the result.
        System.out.println();
        System.out.printf( "The number of divisors of %d is %d.\n", N, divisorCount );

        endTime = System.nanoTime();
        System.out.printf( "Time: %s", ( endTime - startTime ) / 1000000000 );




    }  // end of main()

}  // end of class CountDivisors.
