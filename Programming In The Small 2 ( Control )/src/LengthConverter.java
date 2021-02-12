
import java.util.Scanner;

/*
This program will convert measurements expressed in inches, feet, yards or miles
into each of the possible units of measure. The measurement is input by the user,
followed by the unit of measure. For example: "17 feet", "1 inch", or
"2.73 mi". Abbreviations in, ft, yd and mi are accepted. The program will
continue to read and convert measurements until the user enters an input of 0.
 */

public class LengthConverter {

    public static void main( String[] args ) {

        Scanner stdin = new Scanner( System.in );

        // Numerical measurement, input by the user.
        double measurement;
        // The unit of measure for the input, also specified by the user.
        String units;
        // Measurement expressed in each possible unit of measure.
        double inches, feet, yards, miles;

        System.out.println( "Enter measurements in inches, feet, yards, or miles. " );
        System.out.println( "For example: 1 inch   17 feet   2.73 miles." );
        System.out.println( "You can use abbreviations: in ft yd mi." );
        System.out.println( "I will convert your input into the other units of measure. " );
        System.out.println();

        while ( true ) {
            // Get the user's input, and convert units to lower case.
            System.out.print( "Enter your measurements, or 0 to end: " );
            measurement = stdin.nextDouble();
            if ( measurement == 0 )
                break;  // Terminate the while loop.
            System.out.print( "Units: " );
            units = stdin.next();
            units = units.toLowerCase();  // Convert the units to lower case.

            // Convert the input measurements to inches.
            if ( units.equals( "inch" ) || units.equals( "inches" ) || units.equals( "in" ) ) {
                inches = measurement;
            }
            else if ( units.equals( "foot" ) || units.equals( "feet" ) || units.equals( "ft" ) ) {
                inches = measurement * 12;
            }
            else if( units.equals( "yard" ) || units.equals( "yards" ) || units.equals( "yd" ) ) {
                inches = measurement * 36;
            }
            else if ( units.equals( "mile" ) || units.equals( "miles" ) || units.equals( "mi" ) ) {
                inches = measurement * 12 * 5280;
            }
            else {
                System.out.printf( "Sorry, but i don't understand %s.\n ", units );
                continue;  // back to start of the while loop.
            }

            // Convert measurements in inches to feet, yards and miles.
            feet = inches / 12;
            yards = inches / 36;
            miles = inches / ( 12 * 5280 );

            // Output measurements in terms of each unit of measure.
            System.out.println();
            System.out.println( "That's equivalent to: " );
            System.out.printf( "%14.5g inches%n", inches );
            System.out.printf( "%14.5g feet%n", feet );
            System.out.printf( "%14.5g yards%n", yards );
            System.out.printf( "%14.5g miles%n", miles );
            System.out.println();

        }  // end while.
        System.out.println();
        System.out.println( "OK! Bye for now." );

    } // end of main().

}  // end of class LengthConverter.
