
import textio.TextIO;

/*
Here is a simple program that asks the user some questions and 
outputs the user's responses to a file named "profile.txt."

By Michael Odhiambo.
*/
public class CreateProfile {
    
    public static void main( String[] args ){
        String name;  // The user's name.
        String email; // The user's email address.
        double salary; // The user's yearly salary.
        String favColor;  // The user's favorite color.

        System.out.println( "Good Afternoon! This program will create" );
        System.out.println( "your profile file, if you will just answer" );
        System.out.println( "a few simple questions." );
        System.out.println();

        // Gather responses from the user.

        System.out.print( "What is your name?   " );
        name = TextIO.getln();
        System.out.print( "What is your email address?   " );
        email = TextIO.getln();
        System.out.print( "What is your yearly income?   " );
        salary = TextIO.getlnDouble();
        System.out.print( "What is your favourite color?   " );
        favColor = TextIO.getln();

        // Write the user's information to the file named profile.txt.
        TextIO.writeFile( "C:\\Users\\user\\Desktop\\profile.txt" ); // Subsequent output goes to the file.

        TextIO.putln( "Name:          " + name );
        TextIO.putln( "Email:          " + email );
        TextIO.putln( "Favorite Color:     " + favColor );
        TextIO.putf( "Yearly Income:      %1.2f%n", salary );

        // Print a final message to standard output.
        TextIO.writeStandardOutput();
        System.out.println( "Thank you. Your profile has been written to profile.txt" );



    }
}
