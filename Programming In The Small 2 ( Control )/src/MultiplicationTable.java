
/*
This class implements a multiplication table.
 */

public class MultiplicationTable {

    public static void main( String[] args ) {
        // Number of rows and columns.
        int numRows, numCols;

        for ( numRows = 1; numRows <= 12; numRows++ ) {
            for ( numCols = 1; numCols <= 12; numCols++ ) {
                System.out.printf( "%4d", numRows * numCols );
            }
            // Include a carriage return after each row.
            System.out.println();
        }
    }
}
