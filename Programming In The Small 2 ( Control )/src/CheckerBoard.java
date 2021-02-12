
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static javafx.application.Application.launch;

public class CheckerBoard extends Application {

    /*
    Draws a picture. The parameters width and height give the size of the
    drawing area, in pixels.
     */
    public void drawPicture( GraphicsContext g, int width, int height ) {

        g.setFill( Color.WHITE );
        g.fillRect( 0, 0, width, height );  // First, fill the entire image with a background color.

        int colorChoice;
        int rows, cols;
        colorChoice = 0;
        for ( rows = 0; rows <= height; rows += 100 ) {
            for ( cols = 0; cols <= width; cols += 100 ) {

                switch( colorChoice ){
                    case 0 :
                        g.setFill( Color.RED );
                        colorChoice = 1;
                        break;
                    case 1 :
                        g.setFill( Color.BLACK );
                        colorChoice = 0;
                        break;
                }

                g.fillRect( rows, cols, 100, 100 );
                g.setStroke( Color.BLACK );
                g.strokeRect( rows, cols, 100, 100 );
            }
        }

    }  // end of drawPicture().

    public void start( Stage stage ) {
        int width = 600;  // The width of the image.
        int height = 600;  // The height of the image.
        Canvas canvas = new Canvas( width, height );
        drawPicture( canvas.getGraphicsContext2D(), width, height );
        BorderPane root = new BorderPane( canvas );
        root.setStyle( "-fx-border-width: 4px; -fx-border-color: #444" );
        Scene scene = new Scene( root );
        stage.setScene( scene );
        stage.setTitle( " Checker Board. " );
        stage.show();
        stage.setResizable( false );

    }
    public static void main( String[] args ){
        launch();
    }
}
