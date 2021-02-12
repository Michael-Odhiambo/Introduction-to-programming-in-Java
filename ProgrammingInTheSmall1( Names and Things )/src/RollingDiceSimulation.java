
/*
Write a program that simulates rolling a pair of dice.
 */

public class RollingDiceSimulation {
    public static void main( String[] args ) {

        // Initialize the variables to store the values of die1 and die2
        int die1, die2;

        // Roll the dice.
        die1 = ( int ) ( 6 * Math.random() ) + 1;
        die2 = ( int ) ( 6 * Math.random() ) + 1;

        // Output the results.
        System.out.print( "The first die comes up: " );
        System.out.println( die1 );
        System.out.print( "The second die comes up: " );
        System.out.println( die2 );
        System.out.print( "Your total roll is: " );
        System.out.println( die1 + die2 );

    } // end of main().
}  // End of class RollingDiceSimulation.
