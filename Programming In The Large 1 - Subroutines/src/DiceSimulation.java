
import java.util.Scanner;
/**
 * Write a function that simulates rolling a pair of dice until the total on the dice comes up to be
 * a given number. The number that you are rolling for is a parameter to the function.
 * The number of times you have to roll the dice is the return value of the function. The
 * parameter should be one of the possible totals: 2, 3,..., 12. The function should throw
 * an IllegalArgumentException if this is not the case. Use your function in a program that
 * computes and prints the number of rolls it takes to get snake eyes.
 */

public class DiceSimulation {

    /**
     * This function takes in an integer representing the total after rolling a pair of dice.
     * It computes the number of times you have to roll a pair of dice to get the given total.
     *
     * Precondition: The supplied total must be in the valid range. Otherwise, an IllegalArgumentException
     *               is thrown.
     * Postcondition: The number of rolls it took to get the supplied total is returned.
     *
     * @param total The total that the simulation is being carried out on.
     * @return numberOfRolls The number of rolls it took to get the given total.
     */
    static int simulate( int total ) {

        if ( total < 2 || total > 12 )
            throw new IllegalArgumentException( "Supplied total is out of the legal range." );

        int numberOfRolls = 0;  // Keep track of the number of rolls.
        int die1;  // Represent the first die.
        int die2;  // Represent the second die.

        do {
            die1 = ( int )( Math.random() * 6 ) + 1;
            die2 = ( int )( Math.random() * 6 ) + 1;

            // Count this roll.
            numberOfRolls++;
        } while ( die1 + die2 != total ) ;

        return numberOfRolls;

    }  // End of simulate().

    /**
     * This function returns the average number of rolls it takes to roll a pair of dice to arrive at
     * the given total.
     * @param total The total being experimented on.
     * @return The average number of rolls it took.
     */
    static double averageNumberOfRolls( int total ) {

        int grandTotal = 0;

        for ( int i = 0; i <= 10000; i++ )
            grandTotal += simulate( total );

        return grandTotal / 10000.0;

    }  // End of averageNumberOfRolls.

    public static void main( String[] args ) {

        System.out.println( "Total on dice        Average number of Rolls." );
        System.out.println( "---------------------------------------------" );

        for ( int i = 2; i < 13; i++ )
            System.out.printf( "%5d %30f\n", i, averageNumberOfRolls( i ) );


    }  // End of main().

}  // End of class DiceSimulation.
