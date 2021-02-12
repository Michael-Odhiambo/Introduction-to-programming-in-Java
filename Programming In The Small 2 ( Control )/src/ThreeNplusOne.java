
/*
Given a positive integer, N, define the '3N + 1' sequence starting from N as follows: If N is an
even number, then divide N by two: but if N is odd: then multiply N by 3 and add 1. Continue to
generate numbers in this way until N becomes equal to 1.

Write a program that will read a positive integer from the user and will print out the 3N + 1
sequence starting from that integer. The program should also count and print out the number of terms
in the sequence.
 */

import java.util.Scanner;

public class ThreeNplusOne {

    public static void main( String[] args ) {
        // Create a scanner object.
        Scanner stdin = new Scanner( System.in );
        // Variables to store N and the number of terms in the sequence.
        int N, numOfTerms;

        // Initialize the number of terms.
        numOfTerms = 0;

        // Get the value of N from the user.
        System.out.print( "Enter the N: " );
        N = stdin.nextInt();
        while ( N < 0 ) {
            System.out.println( "Please enter a positive integer. " );
            System.out.print( "Enter the N: " );
            N = stdin.nextInt();
        }

        // Start with N.
        System.out.println( N );
        // Increment the counter.
        numOfTerms += 1;

        while ( N != 1 ) {
            if ( N % 2 == 0 ) {
                N /= 2;
            }
            else {
                N = 3 * N + 1;
            }
            // Display the term.
            System.out.println( N );
            // Count it.
            numOfTerms += 1;
        }

        // Display the number of terms in the sequence.
        System.out.printf( "The number of terms are %d", numOfTerms );

    }
}
