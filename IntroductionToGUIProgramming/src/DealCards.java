
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class DealCards extends Application {

    private void draw( Canvas canvas ) {

        GraphicsContext g = canvas.getGraphicsContext2D();
        Image cardImages = new Image( "cards.png" );

        // Create a new deck.
        Deck deck = new Deck();

        // Shuffle the deck.
        deck.shuffle();

        double sx, sy;  // Top left corner of the source rectangle for the card in cardImages.
        double dx, dy;  // Corner of destination rectangle for the card in the canvas.

        for ( int i = 0; i < 5; i++ ) {

            Card card = deck.dealCard();
            System.out.println( card );  // For testing.
            sx = 79*( card.getValue() - 1 );
            sy = 123*( 3 - card.getSuit() );

            dx = 20 + ( 79 + 20 ) * i;
            dy = 20;

            g.drawImage( cardImages, sx, sy, 79, 123, dx, dy, 79, 123 );

        }
    }

    public void start( Stage stage ) {

        Button dealCard = new Button( "Deal Again!" );

        HBox buttonBar = new HBox( dealCard );
        buttonBar.setAlignment(Pos.CENTER );

        BorderPane root = new BorderPane();

        Canvas canvas = new Canvas( 550, 200 );
        draw( canvas );

        dealCard.setOnAction( e -> draw( canvas ) );

        root.setCenter( canvas );
        root.setBottom( buttonBar );

        Scene scene = new Scene( root, 525, 250 );
        stage.setScene( scene );
        stage.setTitle( "Blackjack" );
        stage.show();

    }

    public static void main( String[] args ) {
        launch( args );
    }
}
