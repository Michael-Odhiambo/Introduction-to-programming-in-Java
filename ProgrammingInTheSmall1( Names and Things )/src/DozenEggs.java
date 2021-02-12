
/*
If you have N eggs, then you have N/12 dozen eggs, with N%12 eggs left over. (This is
essentially the definition of the / and % operators for integers.) Write a program that asks
the user how many eggs she has and then tells the user how many dozen eggs she has and
how many extra eggs are left over.

A gross of eggs is equal to 144 eggs. Extend your program so that it will tell the user
how many gross, how many dozen, and how many left over eggs she has. For example, if
the user says that she has 1342 eggs, then your program would respond with
Your number of eggs is 9 gross, 3 dozen, and 10
since 1342 is equal to 9*144 + 3*12 + 10.
 */

import java.util.Scanner;

public class DozenEggs {

    public static void main( String[] args ){
        // Variable to store the number of eggs.
        int eggs, gross, dozen, remainder;
        // Create a scanner object for input.
        Scanner stdin = new Scanner( System.in );

        // Display a prompt to the user.
        System.out.print( "Enter the number of eggs you have: " );
        // Assign the value entered by the user to "eggs."
        eggs = stdin.nextInt();

        // Do the calculations.
        gross = eggs / 144;
        dozen = ( eggs % 144 ) / 12;
        remainder = eggs - ( gross * 144 + dozen * 12 );

        // Display the results.
        System.out.printf( "You have %d gross, %d dozen and %d", gross, dozen, remainder );

    }  // End of main().
}  // End of DozenEggs.
