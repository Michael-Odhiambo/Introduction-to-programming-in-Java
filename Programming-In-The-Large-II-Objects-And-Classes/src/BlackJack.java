/**
 * A Blackjack hand typically contains from two to six cards. Write a program to test the
 * BlackjackHand class. You should create a BlackjackHand object and a Deck object. Pick
 * a random number between 2 and 6. Deal that many cards from the deck and add them to
 * the hand. Print out all the cards in the hand, and then print out the value computed for
 * the hand by getBlackjackValue(). Repeat this as long as the user wants to continue.
 */

import java.util.Scanner;

public class BlackJack {

    static Scanner stdin = new Scanner( System.in );

    public static void play() {
        /**
         * The number of cards to be dealt to the user. This is a random
         * number between 2 and 6.
         */
        int numberOfCards = ( int )(Math.random()*5) + 2;

        /**
         * The deck of cards.
         */
        Deck theDeck = new Deck();
        /**
         * Shuffle the cards.
         */
        theDeck.shuffle();
        /**
         * The user's hand.
         */
        BlackjackHand theHand = new BlackjackHand();

        /**
         * Deal the cards. The number of cards that are dealt to the user depends
         * on the value of numberOfCards.
         */
        for ( int i = 1; i <= numberOfCards; i++ ) {
            Card card = theDeck.dealCard();
            theHand.addCard( card );

            // Print out this card.
            System.out.println( card );
        }

        // Compute the value of the hand.
        int valueOfHand = theHand.getBlackjackValue();

        System.out.println( "The hand's value is: " + valueOfHand );


    }

    public static void main( String[] args ) {

        boolean response;
        do {
            play();

            // Determine if the user wants to play again or not.
            System.out.print( "Do you wish to continue ( true or false ): " );
            response = stdin.nextBoolean();

        } while ( response != false );
    }
}
