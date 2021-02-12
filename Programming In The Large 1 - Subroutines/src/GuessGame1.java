
import java.util.Scanner;

public class GuessGame1 {

    static int gamesPlayed;  // The number of games played. ( Initialized to zero. )
    static int gamesWon;     // The number of games won. ( Initialized to zero. )
    static Scanner stdin = new Scanner( System.in );

    public static void main( String[] args ) {

        System.out.println( "Let's play a game. I'll pick a number between " );
        System.out.print( "1 and 100, and you try to guess it." );
        boolean playAgain;

        do {

            playGame();  // Call subroutine to play one game.
            System.out.print( "Would you like to play again ( true or false )? : " );
            playAgain = stdin.nextBoolean();

        } while ( playAgain );

        System.out.println();
        System.out.printf( "You played %d games and you won %d of those games.\n", gamesPlayed, gamesWon );
        System.out.println( "Thanks for playing. Goodbye." );

    }  // End of main().
    static void playGame() {
        int computerNumber;   // A random number picked by the computer.
        int userGuess;  // A number entered by the user as a guess.
        int guessCount;  // Number of guesses the user has made.
        gamesPlayed++;  // Count this game.

        computerNumber = ( int )( Math.random() * 100 ) + 1;
        guessCount = 0;
        System.out.println();
        System.out.print( "What is your first guess? " );

        while ( true ) {
            userGuess = stdin.nextInt();  // Get the user's guess.
            guessCount++;  // Count this guess.
            if ( userGuess == computerNumber ) {
                System.out.printf( "You got it in %d guesses! My number was %d\n " ,guessCount, computerNumber );
                gamesWon++;  // Count this win.
                break;
            }
            if ( guessCount == 6 ) {
                System.out.println( "You didn't get the number in 6 guesses." );
                System.out.printf( "You lose. My number was %d.\n ", computerNumber );
                break;
            }
            // If we get to this point, the game continues.
            // Tell the user if the guess was too low or too high.
            if ( userGuess < computerNumber ) {
                System.out.print( "That's too low. Try again: " );
            }
            else if ( userGuess > computerNumber ) {
                System.out.print( "That's too high. Try again: " );

            }

        }
        System.out.println();
    } // end of playGame().

}  // end of class GuessingGame1.
