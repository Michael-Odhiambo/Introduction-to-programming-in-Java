
import textio.TextIO;

/*
This class implements a simple program that will compute
the amount of interest that is earned on an investment over
a period of one year. The initial amount of the investment and
the interest rate are input by the user. The value of the investment
at the end of the year is output. The rate must be input as
a decimal, not a percentage ( for example, 0.05 rather than 5 ).
 */

// By Michael Odhiambo.

public class Interest2 {

    public static void main( String[] args ){

        // Declare the variables.
        double principal, rate, interest;  // The value of principal, rate on the investment
                                           // and the interest earned on a particular year.

        System.out.print( "Enter the initial investment amount: " );
        principal = TextIO.getlnDouble();  // Get the principal from the user.

        System.out.print( "Enter the interest rate in decimal: " );
        rate = TextIO.getlnDouble();       // Get the interest rate from the user.

        interest = principal * rate;       // Compute the interest earned.

        principal = principal + interest;  // Update the principal.

        System.out.printf( "The amount of interest is $%1.2f%n", interest );
        System.out.printf( "The value of the investment after one year is %1.2f", principal );

    } // end of main.
} // end of interest2 class.
