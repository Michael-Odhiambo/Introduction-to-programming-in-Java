/**
 * In all versions of the PairOfDice class, the instance variables die1 and die2
 * are declared to be public. They really should be private, so that they would be protected
 * from being changed from outside the class. Write another version of the PairOfDice class
 * in which the instance variables die1 and die2 are private. Your class will need "getter"
 * methods that can be used to find out the values of die1 and die2. ( The idea is to protect
 * their values from being changed from outside the class, but still allow the values to be
 * read. ) Include other improvements in the class, including at least a toString() method.
 * Test your class with a short program that counts how many times a pair of dice is rolled,
 * before the total of the two dice is equal to two.
 */

public class ModifiedPairOfDice {

    // Number showing on the first die.
    private int die1 = 3;
    // Number showing on the second die.
    private int die2 = 4;

    // The first constructor. It takes no arguments but rolls the dice so that the
    // dice show random numbers.
    ModifiedPairOfDice() {
        this.roll();  // Roll this pair of dice.
    }

    // The second constructor. It takes two arguments of type "int" specifying the
    // value on die1 and die2 respectively.
    ModifiedPairOfDice( int die1, int die2 ) {
        this.die1 = die1;
        this.die2 = die2;
    }

    // Randomly rolls the dice.
    public void roll() {
        die1 = ( int )( Math.random() * 6 ) + 1;
        die2 = ( int )( Math.random() * 6 ) + 1;
    }

    // Getter methods for die1 and die2.
    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    // Returns a string representation of die1 and die2.
    public String toString() {
        if ( die1 == die2 )
            return "Double " + die1;
        else
            return die1 + " and " + die2;

    }

    // This program counts how many times the dice have to be rolled before
    // the total is equal to two.
    public static void main( String[] args ) {

        // Keep track of the number of rolls.
        int rollCount = 0;
        ModifiedPairOfDice theDice = new ModifiedPairOfDice();

        do {

            // Roll the dice.
            theDice.roll();
            // Count this roll.
            rollCount++;

        } while ( ( theDice.getDie1() + theDice.getDie2() ) != 2 );

        System.out.printf( "It took %d rolls to get to a total of 2. \n", rollCount );
    }
}
