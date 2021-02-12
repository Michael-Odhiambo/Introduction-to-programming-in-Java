/**
 * The hexadecimal digits are ordinary, base-10 digits '0' through '9' plus the letters 'A'
 * through 'F'. In the hexadecimal system, these digits represent the values 0 through 15,
 * respectively. Write a function named hexValue that uses a switch statement to find the
 * hexadecimal value of a given character. The character is a parameter to the function, and
 * its hexadecimal value is the return value of the function. You should count lower case
 * letters 'a' through 'f' as having the same value as the corresponding upper case letters.
 * If the parameter is not one of the legal hexadecimal digits, return -1 as the value of the
 * function.
 *
 * A hexadecimal integer is a sequence of hexadecimal digits, such as 34A7, ff8, 174204, or
 * FADE. If str is a string containing a hexadecimal integer, then the corresponding base-10
 * integer can be computed as follows:
 *
 *            value = 0;
 *            for ( i = 0; i < str.length(); i++ )
 *               value = value * 16 + hexValue( str.charAt(i) );
 *
 * Of course, this is not valid if str contains any characters that are not hexadecimal digits.
 *
 * This program reads a string from the user. If all the characters in the string are
 * hexadecimal digits, the corresponding base-10 value is printed out.
 */

import java.util.Scanner;

public class HexConverter {

    /**
     * This function takes a character representing a hexadecimal digit and returns its corresponding
     * hexadecimal value.
     *
     * Precondition: The supplied character must be a legal hexadecimal digit. If not, -1 is returned.
     * Postcondition: The corresponding hex-value of the given digit is returned.
     * @param digit a char representing the hexadecimal digit.
     * @return The corresponding hexadecimal value.
     */
    static int hexValue( char digit ) {

        switch ( digit ) {
            case '0' :
                return 0;
            case '1' :
                return 1;
            case '2' :
                return 2;
            case '3' :
                return 3;
            case '4' :
                return 4;
            case '5' :
                return 5;
            case '6' :
                return 6;
            case '7' :
                return 7;
            case '8' :
                return 8;
            case '9' :
                return 9;
            case 'A' :
                return 10;
            case 'B' :
                return 11;
            case 'C' :
                return 12;
            case 'D' :
                return 13;
            case 'E' :
                return 14;
            case 'F' :
                return 15;
            default :
                return -1;
        }

    }  // End of hexValue().

    /**
     * This function takes as a parameter, a string representing a hexadecimal digit and the corresponding
     * integer value is returned.
     *
     * Precondition: The supplied string must be a valid hexadecimal digit. Otherwise, -1 is returned.
     * Postcondition: The corresponding integer value is returned.
     * @param hexDigit A string representing the given hexadecimal digit.
     * @return The corresponding hexadecimal integer.
     */
    static int hexInt( String hexDigit ) {

        hexDigit = hexDigit.toUpperCase();

        int value = 0;
        for ( int i = 0; i < hexDigit.length(); i++ ) {

            if ( hexValue( hexDigit.charAt( i ) ) != -1 )
                value = value * 16 + hexValue( hexDigit.charAt(i) );
            else
                return -1;
        }
        return value;

    }

    public static void main( String[] args ) {

        Scanner stdin = new Scanner( System.in );
        System.out.print( "Enter the hexadecimal digit: " );
        String digit = stdin.next();

        System.out.println( hexInt( digit ) );
    }

}
