
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class RandomStrings extends Application {

    private void draw( Canvas canvas ) {

        GraphicsContext g = canvas.getGraphicsContext2D();

        // Available fonts.
        Font font1 = Font.font( "Times New Roman", FontWeight.BOLD, 20 );
        Font font2 = Font.font( "Arial", FontWeight.BOLD, FontPosture.ITALIC, 28 );
        Font font3 = Font.font( "Verdana", 32 );
        Font font4 = Font.font( 40 );
        Font font5 = Font.font( "Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 60 );

        double width = canvas.getWidth();
        double height = canvas.getHeight();

        g.setFill( Color.WHITE );  // Fill with white background.
        g.fillRect( 0, 0, width, height );

        for ( int i = 0; i < 25; i++ ) {

            // Draw one string. First set the font to be one of the five
            // available fonts, at random.
            int fontNum = ( int )( 5*Math.random() ) + 1;

            switch( fontNum ) {
                case 1 :
                    g.setFont( font1 );
                    break;
                case 2 :
                    g.setFont( font2 );
                    break;
                case 3 :
                    g.setFont( font3 );
                    break;
                case 4 :
                    g.setFont( font4 );
                    break;
                case 5 :
                    g.setFont( font5 );
                    break;

            }  // end of switch statements.

            // Set the color to a bright, saturated color, with random hue.
            double hue = 360*Math.random();
            g.setFill( Color.hsb( hue, 1.0, 1.0 ) );

            // Select the position of the string, at random.
            double x, y;
            x = -50 + Math.random() * ( width + 40 );
            y = Math.random() * ( height + 20 );

            // Draw message.
            g.fillText( "@LangOfTheGods.", x, y );
            // Also, stroke the outline of the strings with black.
            g.setStroke( Color.BLACK );
            g.strokeText( "@LangOfTheGods", x, y );

        }

    }

    public void start( Stage stage ) {

        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas( 450, 170 );
        draw( canvas );

        Button redraw = new Button( "Redraw" );
        redraw.setOnAction( e -> draw( canvas ) );

        HBox buttonBar = new HBox( 20, redraw );
        buttonBar.setAlignment( Pos.CENTER );
        
        root.setCenter( canvas );
        root.setBottom( buttonBar );
        Scene scene = new Scene( root, 450, 200 );
        stage.setScene( scene );
        stage.setTitle( "Random Strings." );

        stage.show();

    }

    public static void main( String[] args ) {
        launch( args );
    }
}
