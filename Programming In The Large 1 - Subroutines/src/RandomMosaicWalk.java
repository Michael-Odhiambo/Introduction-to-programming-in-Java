/**
 * This program opens a window full of randomly colored squares. A "disturbance"
 * moves randomly around in the window, randomly changing the color of each
 * square that it visits. The program runs until the user closes the window.
 */

public class RandomMosaicWalk {

    final static int ROWS = 30;  // Number of rows in the mosaic.
    final static int COLUMNS = 30;  // Number of columns in the mosaic.
    final static int SQUARE_SIZE = 15;  // Size of each square in the mosaic.

    static int currentRow;  // Row currently containing the disturbance.
    static int currentColumn;  // Column currently containing the disturbance.

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbance in a random walk around the window
     * as long as the window is open.
     */
    public static void main( String[] args ) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        fillWithRandomColors();
        currentRow = ROWS / 2;  // Start at the center of the window.
        currentColumn = COLUMNS / 2;

        while ( true ) {
            changeToRandomColor( currentRow, currentColumn );
            randomMove();
            Mosaic.delay( 10 );  // Remove this line to speed things up!

        }
    } // end of main().

    /**
     * Fills the window with randomly colored squares.
     * Precondition: The mosaic window is open.
     * Postcondition: Each square has been set to a random color.
     */
    static void fillWithRandomColors() {

        for ( int row = 0; row < ROWS; row++ ) {
            for ( int column = 0; column < COLUMNS; column++ ) {
                changeToRandomColor( row, column );
            }
        }
    }  // end of fillWithRandomColors.

    /**
     * Changes one square to a new randomly selected color.
     * Precondition: The specified rowNum and colNum are in the valid range of row
     *               and column numbers.
     * Postcondition: The square in the specified row and column has been set to a random color.
     * @param rowNum the row number of the square, counting down from 0 at the top.
     * @param colNum the column number of the square, counting columns over from 0 at the left.
     */
    static void changeToRandomColor( int rowNum, int colNum ) {
        int red = ( int )( Math.random() * 256 );
        int green = ( int )( Math.random() * 256 );
        int blue = ( int )( Math.random() * 256 );
        Mosaic.setColor( rowNum, colNum, red, green, blue );

    }  // end of changeToRandomColor.

    /**
     * Move the disturbance.
     * Precondition:  The global variables currentRow and currentColumn are within the legal range
     *                of row and column numbers.
     * Postcondition: currentRow or currentColumn is changed to one of the neighboring positions in the grid --
     *                up, down, left, or right from the current position. If this moves the position outside the
     *                grid, then it is moved to the opposite edge of the grid.
     */
    static void randomMove() {
        int directionNum;  // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = ( int )( Math.random() * 4 );

        switch ( directionNum ) {
            case 0:  // Move up.
                currentRow--;
                if ( currentRow < 0 )
                    currentRow = ROWS - 1;
                break;
            case 1 :  // Move right.
                currentColumn++;
                if ( currentColumn >= COLUMNS )
                    currentColumn = 0;
                break;
            case 2 :   // Move down.
                currentRow++;
                if ( currentRow >= ROWS )
                    currentRow = 0;
                break;
            case 3 :  // Move left.
                currentColumn--;
                if ( currentColumn < 0 )
                    currentColumn = COLUMNS - 1;
                break;

        }
    }  // end of randomMove().

}  // end of randomMosaicWalk class.
