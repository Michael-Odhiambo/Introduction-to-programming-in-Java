/**
 * This program opens a window full of randomly colored squares. A "disturbance"
 * moves randomly around in the window, randomly changing the color of each
 * square that it visits. The program runs until the user closes the window.
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Sample {

    final static int ROWS = 177;  // Number of rows in the mosaic.
    final static int COLUMNS = 236;  // Number of columns in the mosaic.
    final static int SQUARE_SIZE = 1;  // Size of each square in the mosaic.

    static int currentRow;  // Row currently containing the disturbance.
    static int currentColumn;  // Column currently containing the disturbance.

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbance in a random walk around the window
     * as long as the window is open.
     */
    public static void main( String[] args ) throws IOException {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        Mosaic.setUse3DEffect( false );

        BufferedImage img = null;
        File f = null;

        f = new File( "C:\\Users\\user\\Desktop\\Screenshot_18.png" );
        img = ImageIO.read(f);

        currentRow = ROWS / 2;  // Start at the center of the window.
        currentColumn = COLUMNS / 2;

        while ( true ) {

            int p = img.getRGB( currentColumn, currentRow  );

            int alpha = ( p >> 24 ) & 0xff;
            int red = ( p >> 16) & 0xff;
            int green = ( p >> 8 ) & 0xff;
            int blue = p & 0xff;

            if ( Mosaic.getRed( currentRow, currentColumn ) == 0 && Mosaic.getGreen( currentRow, currentColumn ) == 0
                    && Mosaic.getBlue( currentRow, currentColumn ) == 0 )
                addColor( currentRow, currentColumn, red, green, blue );

            randomMove();
            Mosaic.delay( 10 );

        }
    } // end of main().


    /**
     * Adds "ADDITION_AMOUNT" to the green component of the given square..
     * Precondition: The specified rowNum and colNum are in the valid range of row
     *               and column numbers.
     * Postcondition: "ADDITION_AMOUNT" has been added to the square at the specified row and column.
     * @param rowNum the row number of the square, counting down from 0 at the top.
     * @param colNum the column number of the square, counting columns over from 0 at the left.
     */
    static void addColor( int rowNum, int colNum, int red, int green, int blue ) {
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
