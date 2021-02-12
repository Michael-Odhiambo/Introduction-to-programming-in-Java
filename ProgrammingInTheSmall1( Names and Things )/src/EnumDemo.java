

public class EnumDemo {

    // Define two enum types -- remember that the definitions
    // go OUTSIDE the main routine!.

    enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }
    enum Month { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER }

    public static void main( String[] args ){
        Day tgif;   // Declare a variable of type Day.
        Month libra; // Declare a variable of type Month.

        tgif = Day.FRIDAY;   // Assign a value of type Day to tgif.
        libra = Month.OCTOBER;  // Assign a value of type Month.

        System.out.print( "My sign is libra since i was born in: " );
        System.out.println( libra );
        System.out.print( "That's the " );
        System.out.print( libra.ordinal() );
        System.out.print( "-nth month of the year." );
        System.out.println( " ( Counting from 0, of course! ) " );

        System.out.print( "Isn't it nice to get to " );
        System.out.println( tgif );

        System.out.println( tgif + " is the " + tgif.ordinal() +
                "-nth day of the week." );

    }
}
