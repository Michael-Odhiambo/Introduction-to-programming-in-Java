/**
 * Write a program that lets the user play Blackjack. The game will be a simplified version
 * of Blackjack as it is played in a casino. The computer will act as the dealer.
 *
 * You should first write a subroutine in which the user plays one game. The subroutine should
 * return a boolean value to indicate whether the user wins the game or not. Return
 * true if the user wins, false if the dealer wins. The program needs an object of class
 * Deck and two objects of type BlackjackHand, one for the dealer and one for the user.
 * The general object in Blackjack is to get a hand of cards whose value is as close to 21 as
 * possible, without going over. The game goes like this.
 *
 *  - First, two cards are dealt into each player's hand. If the dealer's hand has a value of
 *    21 at this point, then the dealer wins. Otherwise, if the user has 21, then the user wins.
 *    ( This is called a "Blackjack". ) Note that the dealer wins on a tie, so if both
 *    players have Blackjack, then the dealer wins.
 *
 *  - Now, if the game has not ended, the user gets a chance to add some cards to her
 *    hand. In this phase, the user sees her own cards and sees one of the dealer's two
 *    cards. ( In a casino, the dealer deals himself one card face up and one card face down.
 *    All the user's cards are dealt face up. ) The user makes a decision whether to "Hit",
 *    which means to add another card to her hand, or to "Stand", which means to stop
 *    taking cards.
 *
 *  - If the user Hits, there is a possibility that the user will go over 21. In that case, the
 *    game is over and the user loses. If not, then the process continues. The user gets to
 *    decide again whether to Hit or Stand.
 *
 *  - If the user Stands, the game will end, but first the dealer gets a chance to draw cards.
 *    The dealer only follows rules, without any choice. The rule is that as long as the
 *    value of the dealer's hand is less than or equal to 16, the dealer Hits ( that is, takes
 *    another card ). The user should see all the dealer's cards at this point. Now, the
 *    winner can be determined: If the dealer has gone over 21, the user wins. Otherwise,
 *    if the dealer's total is greater than or equal to the user's total, then the dealer wins.
 *    Otherwise, the user wins.
 *
 *    Two notes on programming: At any point in the subroutine, as soon as you know who
 *    the winner is, you can say "return true;" or "return false;" to end the subroutine
 *    and return to the main program. To avoid having an overabundance of variables in your
 *    subroutine, remember that a function call such as userHand.getBlackjackValue() can
 *    be used anywhere that a number could be used, including in an output statement or in
 *    the condition of an if statement.
 *
 *    Write a main program that lets the user play several games of Blackjack. To make
 *    things interesting, give the user 100 dollars, and let the user make bets on the game. If
 *    the user loses, subtract the bet from the user's money. If the user wins, add an amount
 *    equal to the bet to the user's money. End the program when the user wants to quit or
 *    when she runs out of money.
 */

import java.util.Scanner;

public class BlackjackGame {

    private Scanner stdin = new Scanner( System.in );

    // The deck of cards in this game.
    private Deck deck = new Deck();
    // The dealer's hand.
    private BlackjackHand dealer = new BlackjackHand();
    // The player's hand.
    private BlackjackHand player = new BlackjackHand();

    /**
     * Play one game of Blackjack. This method returns a boolean value of true if the player
     * wins and false otherwise.
     */
    public boolean play() {

        // Shuffle the cards.
        deck.shuffle();

        // Deal two cards to each of the players.
        // Start with the dealer.
        BlackjackHand currentPlayer = dealer;

        for ( int i = 0; i < 2; i++ ) {
            for ( int j = 0; j < 2; j++ ) {
                Card card = deck.dealCard();
                currentPlayer.addCard( card );

                if ( currentPlayer == player )
                    System.out.println( card );
                else if ( currentPlayer == dealer ) {
                    if ( j == 1 ) {
                        System.out.println( "Dealer: " + card );
                    }
                }
            }
            currentPlayer = player;

        }

        // Calculate the dealer's hand value. If it is 21, then the dealer wins.
        if ( dealer.getBlackjackValue() == 21 )
            return false;  // The dealer wins.
        else if ( player.getBlackjackValue() == 21 )
            return true;  // The player wins.
        else if ( dealer.getBlackjackValue() == player.getBlackjackValue() )
            return false;  // The dealer wins.

        /**
         * At this point, the game has not ended. The user gets a chance to add some cards to her hand.
         * In this phase, the user sees her own cards and sees one of the dealer's two cards. ( In a casino,
         * the dealer deals himself one card face up and one card face down. ) All the user's cards are
         * dealt face up. The user makes a decision whether to "Hit" which means to add another card to her
         * hand, or to "Stand", which means to stop taking cards.
         */
        String response;  // Store the player's response.

        do {
            System.out.print( "HIT OR STAND: " );
            response = stdin.next().toUpperCase();

            if ( response.equals( "HIT" ) ) {
                Card theCard = deck.dealCard();
                System.out.println( "Added: " + theCard );
                player.addCard( theCard );
                if ( player.getBlackjackValue() > 21 ) {
                    return false;
                }
            }
        } while ( !response.equals( "STAND" ) );

        /**
         * If the user stands, the game will end, but first the dealer gets a chance to draw cards. The dealer
         * only follows rules, without any choice. The rule is that as long as the value of the dealer's hand
         * is less than or equal to 16, the dealer Hits. The user should see all the dealer's cards at this point.
         * Now, the winner can be determined: If the dealer has gone over 21, the user wins, otherwise, if the
         * dealer's total is greater than or equal to the user's total, then the dealer wins. Otherwise, the
         * user wins.
         */
        while ( dealer.getBlackjackValue() <= 16 ) {
            dealer.addCard( deck.dealCard() );
        }

        System.out.println( "Dealer's cards: " );
        for ( int i = 0; i < dealer.getCardCount(); i++ )
            System.out.println( dealer.getCard(i) );

        if ( dealer.getBlackjackValue() > 21 )
            return true;
        else if ( dealer.getBlackjackValue() >= player.getBlackjackValue() )
            return false;

        return true;

    }

    public static void main( String[] args ) {

        BlackjackGame theGame = new BlackjackGame();
        boolean winner = theGame.play();

        if ( winner )
            System.out.println( "You Won!!" );
        else
            System.out.println( "Sorry, You lost." );

        System.out.println( theGame.player.getBlackjackValue() );
        System.out.println( theGame.dealer.getBlackjackValue() );
    }
}
