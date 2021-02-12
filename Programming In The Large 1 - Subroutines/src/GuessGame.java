
import java.util.Scanner;

public class GuessGame {

    static Scanner stdin = new Scanner( System.in );

    public static void main( String[] args ) {

        System.out.println( "Let's play a game. I'll pick a number between " );
        System.out.println( "1 and 100, and you try to guess it." );
        boolean playAgain;

        do {
            // Call subroutine to play one game.
            playGame();
            System.out.print( "Would you like to play again ( true or false ): " );
            playAgain = stdin.nextBoolean();
        } while ( playAgain );
    }

    static void playGame() {
        // A random number picked by the computer.
        int computerNumber;
        // A Number entered by the user as a guess.
        int userGuess;
        // Number of guesses the user has made.
        int guessCount;

        computerNumber = ( int )( 100 * Math.random() ) + 1;
        guessCount = 0;
        System.out.println();
        System.out.print( "What is your first guess? " );

        while ( true ) {
            userGuess = stdin.nextInt();
            guessCount++;
            if ( userGuess == computerNumber ) {
                System.out.printf( "You got it in %d guesses! My number was %d.\n", guessCount, computerNumber );
                break;
            }
            if ( guessCount == 6 ) {
                System.out.println( "You didn't get the number in 6 guesses." );
                System.out.printf( "You lose. My number was %d\n", computerNumber );
                break;
            }

            // If we get to this point, the game continues.
            // Tell the user if the guess was too high or too low.
            if ( userGuess < computerNumber ) {
                System.out.print( "That's too low. Try again. " );
            }
            else if ( userGuess > computerNumber ) {
                System.out.print( "That's too high. Try again:" );
            }
        }
        System.out.println();

    }  // end of playGame()

}  // end of class GuessGame.
