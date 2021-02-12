

public class Stars implements Readable {

    public char readChar() {
        if ( Math.random() > 0.02 )
            return '*';
        else
            return '\n';
    }

    public static void main( String[] args ) {
        Stars stars = new Stars();
        for ( int i = 0; i < 10; i++ ) {
            String line = stars.readLine();  // Calls the default method.
            System.out.println( line );
        }
    }
}
