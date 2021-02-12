
import java.util.Scanner;
/*
This class implements a simple program that will compute the amount of
interest that is earned on an investment over a period of 5 years. The
initial amount of the investment and the interest rate are input by the
user. The value of the investment at the end of each year is output.
 */

public class Interest {

    public static void main( String[] args ){

        Scanner stdin = new Scanner( System.in );
        // The value of the investment.
        double principal;
        // The annual interest rate.
        double rate;

        // Get the initial investment and interest rate from the user.
        System.out.print( "Enter the initial investment: " );
        principal = stdin.nextDouble();

        System.out.println();
        System.out.println( "Enter the annual interest rate." );
        System.out.print( "Enter a decimal, not a percentage: " );
        rate = stdin.nextDouble();
        System.out.println();

        // Simulate the investment for 5 years.

        // Counts the number of years that have passed.
        int years;

        years = 0;
        while ( years < 5 ) {
            // Interest for this year.
            double interest;
            interest = principal * rate;
            // Add the interest to the principal.
            principal = principal + interest;
            years += 1;   // Count the current year.

            System.out.printf( "The value of investment after %d years is $ %1.2f\n", years, principal );

        }  // end of while loop.
        System.out.println( "That's a pretty damn good investment!!!" );

    }  // end of main()

}  // end of class Interest.
