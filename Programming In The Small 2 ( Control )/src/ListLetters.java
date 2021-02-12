
import java.util.Scanner;

/*
This program reads a line of text entered by the user. It prints
a list of the letters that occur in the text, and it reports how many
different letters were found.
 */

public class ListLetters {

    public static void main( String[] args ) {
        Scanner stdin = new Scanner( System.in );

        // Line of text entered by the user.
        String str;
        // Number of different letters found in str.
        int count;
        // A letter of the alphabet.
        char letter;

        System.out.println( "Please type in a line of text: " );
        str = stdin.nextLine();

        str = str.toUpperCase();

        count = 0;
        System.out.println( "Your input contains the following letters: " );
        System.out.println();
        System.out.print( "   " );
        for ( letter = 'A'; letter <= 'Z'; letter++ ) {
            int i; // Position of a character in str.
            for ( i = 0; i < str.length(); i++ ) {
                if ( letter == str.charAt(i) ) {
                    System.out.print( letter );
                    System.out.print( ' ' );
                    count++;
                    break;
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.printf( "There were %d different letters.", count );

    } // end of main()

}  // end of class ListLetters.
