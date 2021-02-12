
import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class IsPrime {

    public static void main( String[] args ){
        Scanner stdin = new Scanner( System.in );
        int N;

        System.out.print( "Enter N: " );
        N = stdin.nextInt();

        if ( isPrime( N ) )
            System.out.printf( "%d is a prime number.\n", N );
        else
            System.out.printf( "%d is not a prime number.\n", N );

    } // end of main().

    /**
     * THis function returns true if N is a prime number. A prime number
     * is an integer greater than 1 that is not divisible by any positive
     * integer, except itself and 1. If N has any divisor, D, in the range
     * 1 < D < N, then it has a divisor in the range 2 to Math.sqrt( N ),
     * namely either D itself or N/D. So we only test possible divisors from
     * 2 to Math.sqrt( N ).
     */
    static boolean isPrime( int N ) {
        int divisor;  // A number we will test to see whether it evenly divides N.

        if ( N <= 1 )
            return false;  // No number <= 1 is prime.

        int maxToTry;  // The largest divisor that we need to test.
        // We will try to divide N by numbers between 2 and maxToTry. If
        // N is not evenly divisible by any of these numbers, then N is prime.
        // ( Note that since Math.sqrt(N) is defined to return a value of
        // type double, the value must be type case to type int before
        // it can be assigned to maxToTry.
        maxToTry = ( int )( Math.sqrt( N ) );

        for ( divisor = 2; divisor <= maxToTry; divisor++ ) {
            if ( N % divisor == 0 )
                return false;

        }

        // If we get to this point, N must be prime. Otherwise,
        // the function would already have been terminated by a
        // return statement in the previous loop.

        return true;  // Yes, N is prime.

    }  // end of function isPrime.

}  // end of main().
