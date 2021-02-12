
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static javafx.application.Application.launch;

public class GuiDemo extends Application {

    /*
    Draws a picture. The parameters width and height give the size of the
    drawing area, in pixels.
     */
    public void drawPicture( GraphicsContext g, int width, int height ) {

        g.setFill( Color.WHITE );
        g.fillRect( 0, 0, width, height );  // First, fill the entire image with a background color.

        double inset;

        double rectWidth, rectHeight;
        g.setStroke( Color.BLACK );
        inset = 0.5;

        rectWidth = width;
        rectHeight = height;

        while ( rectWidth >= 0 && rectHeight >= 0 ) {
            g.strokeRect( inset, inset, rectWidth, rectHeight );
            inset += 15;
            rectWidth -= 30;
            rectHeight -= 30;
        }

    }  // end of drawPicture().

    public void start( Stage stage ) {
        int width = 800;  // The width of the image.
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

