
/*
This exercise asks you to write a program that tests some of the built-in subroutines for
working with Strings. The program should ask the user to enter their first name and their
last name, separated by a space. Read the user’s response using TextIO.getln(). Break
the input string up into two strings, one containing the first name and one containing the
last name. You can do that by using the indexOf() subroutine to find the position of the
space, and then using substring() to extract each of the two names. Also output the
number of characters in each name, and output the user’s initials. (The initials are the
first letter of the first name together with the first letter of the last name.) A sample run
of the program should look something like this:
Please enter your first name and last name, separated by a space.
? Mary Smith
Your first name is Mary, which has 4 characters
Your last name is Smith, which has 5 characters
Your initials are MS
 */

import java.util.Scanner;

public class SplitNames {

    public static void main( String[] args ) {
        // Create a Scanner object.
        Scanner stdin = new Scanner( System.in );
        // Create the variables for storing the names.
        String name, first, last;
        // "index" stores the position of the space which separates the names.
        int index;

        // Display a prompt to the user.
        System.out.print( "Please enter your full name: " );
        // Store the user's name.
        name = stdin.nextLine();

        // Get the index of the space character.
        index = name.indexOf( " " );
        // Get the first part of the name.
        first = name.substring( 0, index );
        // Get the last part of the name.
        last = name.substring( index + 1, name.length() );

        // Display the relevant information.
        System.out.printf( "Your first name is %s which has %d characters.\n", first, first.length() );
        System.out.printf( "Your last name is %s which has %d characters.\n", last, last.length() );
        System.out.print( "Your initials are: " );
        System.out.print( first.charAt(0) );
        System.out.println( last.charAt(0) );

    }  // end of main().

}  // end of SplitNames class.
