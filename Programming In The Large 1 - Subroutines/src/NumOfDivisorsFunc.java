
import java.util.Scanner;

public class NumOfDivisorsFunc {

    static Scanner stdin = new Scanner( System.in );

    // Print all the divisors of N.
    // Assume N is a positive integer.
    static void printDivisors( int N ) {

        int i;  // loop control variable.
        int divisorCount;  // Number of divisors of N.
        divisorCount = 0;
        for ( i = 1; i <= N; i++ ) {
            if ( N % i == 0 ){
                divisorCount++;
            }
        }
        System.out.printf( "%d has %d divisors.\n", N, divisorCount );

    } // end of printDivisors.

    public static void main( String[] args ) {
        int N;
        System.out.print( "Enter N: " );
        N = stdin.nextInt();
        printDivisors( N );
    }
}
