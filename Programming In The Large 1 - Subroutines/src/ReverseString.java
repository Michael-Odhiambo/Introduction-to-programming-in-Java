
import java.util.Scanner;

public class ReverseString {

    public static void main( String[] args ) {
        Scanner stdin = new Scanner( System.in );
        String str;
        System.out.print( "Enter the word/sentence: " );
        str = stdin.nextLine();

        str = reverseString( str );
        System.out.print( str );

    }  // end of main().

    static String reverseString( String str ) {
        String copy;
        int i;

        copy = "";
        for ( i = str.length() - 1; i >= 0; i-- ) {
            copy += str.charAt(i);
        }
        return copy;
    }
}
