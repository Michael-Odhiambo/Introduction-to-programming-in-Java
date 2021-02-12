
import java.util.Scanner;

/*
Write a program that asks the user’s name, and then greets the user by name. Before
outputting the user’s name, convert it to upper case letters. For example, if the user’s
name is Fred, then the program should respond “Hello, FRED, nice to meet you!”.

 */

public class Greetings {

    public static void main( String[] args ) {
        // Create a Scanner object.
        Scanner stdin = new Scanner( System.in );
        // Create a name variable to hold the user's name.
        String name;

        // Display a prompt message.
        System.out.print( "Please enter your name: " );
        // Get the user's name.
        name = stdin.nextLine();
        // Convert the name to uppercase.
        name = name.toUpperCase();
        // Display the greetings.
        System.out.println( "Hello " + name + ", nice to meet you!" );

    }  // end of main.

}  // end of class Greetings.
