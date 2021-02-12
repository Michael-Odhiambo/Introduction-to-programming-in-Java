
import java.util.Scanner;

public class Interest0 {

    public static void main( String[] args ){
        Scanner stdin = new Scanner( System.in );  // Create the scanner.

        double principal;    // The value of the investment.
        double rate;         // The annual interest rate.
        double interest;     // The interest earned during the year.

        System.out.print( "Enter the intitial investment: " );
        principal = stdin.nextDouble();

        System.out.print( "Enter the annual interest rate ( as a decimal ): " );
        rate = stdin.nextDouble();

        interest = principal * rate;   // Compute this year's interest.
        principal = principal + interest;  // Add it to principal.

        System.out.printf( "The amount of interest is $%1.2f%n", interest );
        System.out.printf( "The value of the investment after one year is $%1.2f%n", principal );

    } // end of main()


} // end of class Interest0.
