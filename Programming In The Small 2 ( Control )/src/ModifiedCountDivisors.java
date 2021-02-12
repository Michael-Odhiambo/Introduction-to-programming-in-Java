/**
 * Exercise 3.2 asked you to find the number in the range 1 to 10000 that has the largest
 * number of divisors. You only had to print out one such number. Revise the program so
 * that it will print out all numbers that have the maximum number of divisors. Use an array
 * as follows: As you count the divisors for each number, store each count in an array. Then
 * at the end of the program, you can go through the array and print out all the numbers
 * that have the maximum count. The output from the program should look something like
 * this:
 *                 Among integers between 1 and 10000,
 *                 The maximum number of divisors was 64
 *                 Numbers with that many divisors include:
 *                 7560
 *
 *                 9240
 */
public class ModifiedCountDivisors {

    public static void main( String[] args ) {
        int N, maxDivisors, divisor, divisorCount;
        int[] theArray;
        theArray = new int [10001];
        maxDivisors = 0;

        for ( N = 0; N <= 10000; N++ ) {
            divisorCount = 1;
            for ( divisor = 1; divisor <= N / 2; divisor++ ) {
                if ( N % divisor == 0 ) {
                    divisorCount++;
                }

            }
            theArray[N] = divisorCount;
            if ( divisorCount > maxDivisors ) {
                maxDivisors = divisorCount;
            }

        }
        System.out.printf( "The maximum number of divisors was: %d\n", maxDivisors );
        System.out.println( "Numbers with that many divisors include: " );

        for ( N = 0; N <= 10000; N++ ) {
            if ( theArray[N] == maxDivisors ) {
                System.out.println( N );
            }
        }
    }
}
