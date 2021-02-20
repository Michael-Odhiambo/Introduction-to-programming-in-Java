
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;


public class PaintVersion2 extends Application {

    // An array of colors that are available in the program.
    private final Color[] palette = { Color.BLACK, Color.GREEN, Color.BLUE, Color.ORANGE, Color.RED, Color.YELLOW };

    // An array of strings corresponding to the different colors.
    private final String[] colorNames = { "black", "green", "blue", "orange", "red", "yellow" };

    // The current color that is being used.
    private int currentColorNum = 0;

    // The graphics context that all drawing will be made on.
    private GraphicsContext g;

    // The canvas width and height.
    private final int canvasWidth = 1300;
    private final int canvasHeight = 700;

    // The root's width and height.
    private final int rootWidth = 1300;
    private final int rootHeight = 700;

    private Canvas canvas;

    /**
     * The previous location of the mouse, when the user is drawing by dragging the mouse.
     */
    private double prevX, prevY;

    /**
     * This is set to true while the user is dragging.
     */
    private boolean dragging;

    // The buttons for the various colors in the program.
    Button black;
    Button green;
    Button blue;
    Button orange;
    Button red;
    Button yellow;
    Button clear;

    /**
     * Create an array to store the buttons.
     */
    Button[] buttons = { black = new Button(), green = new Button(), blue = new Button(), orange = new Button(), red = new Button(), yellow = new Button(), clear = new Button( "CLEAR" ) };

    /**
     * A main method to enable this class to be run as a program.
     */
    public static void main( String[] args ) { launch(args); }

    public void start( Stage stage ) {

        canvas = new Canvas( canvasWidth, canvasHeight );
        setUpCanvas( canvas );

        BorderPane root = new BorderPane();
        root.setPrefSize( rootWidth, rootHeight );


        HBox buttonBar = new HBox( 30, black, green, blue, orange, red, yellow, clear );

        buttonBar.setPrefSize( 1300, 200 );
        buttonBar.setStyle( "-fx-background-color: grey" );
        buttonBar.setAlignment( Pos.CENTER_LEFT );

        configureButtons( buttonBar );
        outLineCurrentColor( currentColorNum );

        root.setTop( buttonBar );
        root.setBottom( canvas );

        Scene scene = new Scene( root );

        stage.setScene( scene );

        stage.show();

    }

    /**
     * This method sets up the canvas.
     */
    private void setUpCanvas( Canvas canvas ) {

        // Get the canvas' graphics context.
        g = canvas.getGraphicsContext2D();
        g.setFill( Color.WHITE );
        g.fillRect( 0, 0, canvasWidth, canvasHeight );

        canvas.setOnMousePressed( e -> { mousePressed( e );
        System.out.println( e.getX() );
        System.out.println( e.getY() );
        } );

        canvas.setOnMouseReleased( e -> mouseReleased( e ) );

        canvas.setOnMouseDragged( e -> mouseDragged( e ) );

    }

    /**
     * Method to configure the Buttons in the program.
     */

    private void configureButtons( HBox buttonBar ) {

        /**
         * Go through all the buttons in the array of buttons and set the preferred size and background
         * color.
         */
        for ( int i = 0; i < buttons.length - 1; i++ ) {
            buttons[i].setPrefSize( 30, 30 );
            buttons[i].setStyle( "-fx-background-color: " + colorNames[i] );
            int finalI = i;

            /**
             * Register a listener for ActionEvents with each button so that when it is pressed, the color
             * is changed.
             */
            buttons[i].setOnAction( e -> {
                buttons[ currentColorNum ].setStyle( "-fx-background-color: " + colorNames[ currentColorNum ] );
                currentColorNum = finalI;
                outLineCurrentColor( finalI );
            } );
        }

        /**
         * Set up the clear button.
         */
        buttons[ buttons.length - 1 ].setStyle( "-fx-padding: 5px; -fx-border-color: lawngreen; -fx-border-width: 3px; -fx-background-color: darkgreen" );
        buttons[ buttons.length - 1 ].setOnAction( e -> {
            buttons[ currentColorNum ].setStyle( "-fx-background-color: " + colorNames[ currentColorNum ] );
            setUpCanvas( canvas );
            currentColorNum = 0;
            outLineCurrentColor( currentColorNum );
        } );

    }


    /**
     * This method outline the current color being used for drawing.
     * @param currentColorNum
     */
    private void outLineCurrentColor( int currentColorNum ) {

        /**
         * Search for the appropriate button and outline it.
         */
        for ( int i = 0; i < buttons.length; i++ ) {
            if ( i == currentColorNum ) {
                buttons[i].setStyle( "-fx-padding: 1px; -fx-border-color: white; -fx-border-width: 4px; -fx-background-color: " + colorNames[i] );
            }
        }

    }

    /**
     * This is called when the user presses the mouse anywhere in the canvas.
     */
    private void mousePressed( MouseEvent evt ) {

        /**
         * Ignore mouse presses that occur when the user is already drawing
         * a curve. ( This can happen if the user presses two mouse buttons
         * at a time. )
         */
        if ( dragging == true )
            return;

        int x = ( int ) evt.getX();  // x-coordinate where the user clicked.
        int y = ( int ) evt.getY();  // y-coordinate where the user clicked.

        prevX = x;
        prevY = y;
        dragging = true;

        g.setLineWidth(2);  // Use a 2-pixel-wide line for drawing.
        g.setStroke( palette[ currentColorNum ] );  // Set the drawing color to the color that has been chosen.

    }

    /**
     * This method is called whenever the user releases the mouse button. Just sets dragging to false.
     */
    public void mouseReleased( MouseEvent evt ) { dragging = false; }

    /**
     * This method is called whenever the user moves the mouse while a mouse button is held down.
     * If the user is drawing, draw a line segment from the previous mouse location to the current
     * mouse location and set up prevX and prevY for the next call.
     */
    public void mouseDragged( MouseEvent evt ) {

        if ( dragging == false )
            return;  // Do nothing since the user is not drawing.

        double x = evt.getX();  // x-coordinate of the mouse.
        double y = evt.getY();  // y-coordinate of the mouse.

        g.strokeLine( prevX, prevY, x, y );

        // Get ready for the next line segment in the curve.
        prevX = x;
        prevY = y;
    }



}