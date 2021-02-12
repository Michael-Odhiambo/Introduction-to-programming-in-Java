
import java.util.Scanner;

/**
 * This program will get a line of input from the user and will print a copy
 * of the line in which the first character of each word has been changed to
 * upper case.  The program was written to test the CapitalizeString
 * subroutine.
 */

public class CapitalizeString {

    /**
     * Precondition : The supplied parameter must be a valid string.
     * Postcondition : A new string is printed with the first letter of every word capitalized.
     * @param str - The string whose words are to be capitalized.
     */

    public static void capitalizeString( String str ) {

        char prevChar = ' ';  // Prime the loop with any non-letter character.

        for ( int i = 0; i < str.length(); i++ ) {
            char L = str.charAt( i );

            if ( Character.isLetter( L ) && ! Character.isLetter( prevChar ) )
                System.out.print( Character.toUpperCase( L ) );
            else
                System.out.print( L );
            prevChar = L;
        }
    }  // end of capitalizeString().

    public static void main( String[] args ) {

        Scanner stdin = new Scanner( System.in );

        String str;
        System.out.print( "Enter sentence: " );
        str = stdin.nextLine();
        capitalizeString( str );

    }  // end of main().

}  // end of class CapitalizeString.
