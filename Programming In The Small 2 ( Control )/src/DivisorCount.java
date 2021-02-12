/**
 * Which integer between 1 and 10000 has the largest number of divisors, and how many divisors
 * does it have? Write a program to find the answers and print out the results.
 */
public class DivisorCount {

    public static void main( String[] args ) {
        // Declare the variables to be used for counting and storing the appropriate numbers.
        int number, numWithMaxDivs, maxDivisors;

        // Initialize the maximum divisor count encountered so far.
        maxDivisors = 0;
        numWithMaxDivs = 0;

        // Go through all the numbers.
        for ( number = 0; number <= 10000; number++ ) {
            int divisor;
            int divisorCount;

            divisorCount = 1;

            // Go through all the divisors.
            for ( divisor = 1; divisor <= number / 2; divisor++ ) {
                if ( number % divisor == 0 ) {
                    divisorCount++;
                }

            }
            if ( divisorCount > maxDivisors ) {
                maxDivisors = divisorCount;
                numWithMaxDivs = number;
            }

        }

        System.out.printf( "The number with the highest number of divisors is %d with %d divisors.\n" ,numWithMaxDivs,
                maxDivisors );
    }
}
