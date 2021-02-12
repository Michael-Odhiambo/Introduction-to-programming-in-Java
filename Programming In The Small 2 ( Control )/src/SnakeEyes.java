/**
 * How many times do you have to roll a pair of dice before they turn up "snake eyes"?
 */

public class SnakeEyes {

    public static void main( String[] args ) {
        // variables for holding the die number and number of rolls.
        int die1, die2, numberOfRolls;
        // Initialize the number of rolls.
        numberOfRolls = 0;

        do {
            die1 = ( int )( Math.random() * 6 ) + 1;
            die2 = ( int )( Math.random() * 6 ) + 1;
            numberOfRolls++;

        } while ( die1 != 1 || die2 != 1 );

        // At this point, it's snake eyes.
        System.out.printf( "Die1: %d, Die2: %d\n", die1, die2 );
        System.out.printf( "Snake eyes appeared after %d rolls.\n", numberOfRolls );

    }  // End of main().

}  // End of class SnakeEyes.
