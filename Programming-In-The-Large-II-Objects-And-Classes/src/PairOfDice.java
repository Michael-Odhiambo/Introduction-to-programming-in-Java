/**
 * An instance variable can be assigned an initial value in its declaration, just like any other
 * variable. For example, consider a class named PairOfDice. An object of this class will represent
 * a pair of dice. It will contain two instance variables to represent the numbers showing on the
 * dice and an instance method for rolling the dice:
 */
public class PairOfDice {

    public int die1 = 3;  // Number showing on the first die.
    public int die2 = 4; // Number showing on the second die.

    public PairOfDice() {
        // Constructor. Rolls the dice, so that they initially show some
        // random values. Calls the roll() method to roll the dice.
        roll();
    }
    public PairOfDice( int val1, int val2 ) {
        // Constructor. Creates a pair of dice that are initially showing the
        // values val1 and val2.
        // Assign specified values to the instance variables.
        die1 = val1;
        die2 = val2;
    }

    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        die1 = ( int )( Math.random()*6 ) + 1;
        die2 = ( int )( Math.random()*6 ) + 1;

    }

    /**
     * Return a String representation of a pair of dice, where die1 and
     * die2 are instance variables containing the numbers that are showing
     * on the two dice.
     */
    public String toString() {
        if ( die1 == die2 )
            return "double " + die1;
        else
            return die1 + " and " + die2;
    }

}  // end of class PairOfDice.
