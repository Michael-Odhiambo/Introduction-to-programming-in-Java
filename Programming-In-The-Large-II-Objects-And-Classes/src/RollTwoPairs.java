/**
 * This program uses the PairOfDice class to count how many times two pairs
 * of dice are rolled before the two pairs come up showing the same value.
 */
public class RollTwoPairs {

    public static void main( String[] args ) {

        PairOfDice firstDice = new PairOfDice();  // Refers to the first pair of dice.
        PairOfDice secondDice = new PairOfDice();  // Refers to the second pair of dice.

        int countRolls = 0; // Counts how many times the two pairs of dice have been rolled.

        int total1;  // Total showing on the first pair of dice.
        int total2;  // Total showing on the second pair of dice

        do{
            // Roll the two pairs of dice until totals are the same.
            firstDice.roll();  // Roll the first pair of dice.
            total1 = firstDice.die1 + firstDice.die2;  // Get total.
            System.out.println( "The first pair comes up: " + total1 );

            secondDice.roll();  // Roll the second pair of dice.
            total2 = secondDice.die1 + secondDice.die2;  // Get the total.
            System.out.println( "The second pair comes up: " + total2 );

            countRolls++;  // Count this roll.

            System.out.println();  // Blank line.

        } while ( total1 != total2 );

        System.out.printf( "It took %d rolls until the totals were the same " , countRolls );

    }  // end of main() subroutine.

}  // end of class RollTwoPairs.
