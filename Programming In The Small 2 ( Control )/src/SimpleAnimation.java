/**
 * Often, some element of an animation repeats over and over, every so many frames. Some
 * times, the repetition is "cyclic," meaning that at the end it jumps back to the start.
 * Sometimes the repetition is "oscillating," like a back-and-forth motion where the second
 * half is the same as the first half played in reverse.
 *
 * Write an animation that demonstrates both cyclic and oscillating motions at various speeds.
 * For cyclic motion, you can use a square that moves across the drawing area, then
 * jumps back to the start, and then repeats the same motion over and over. For oscillating
 * motion, you can do something similar, but the square should move back and forth between
 * the two edges of the drawing area; that is, it moves left-to-right during the first half of
 * the animation and then backwards from right-to-left during the second half.
 *
 * A cyclic motion has to repeat every N frames for some value of N. What you draw in
 * some frame of the animation depends on the frameNumber. The frameNumber just keeps
 * increasing forever. To implement cyclic motion, what you really want is a "cyclic frame
 * number " that takes on the values 0, 1, 2,...,( N - 1 ), 0, 1, 2, ..., ( N - 1 ),
 * 0, 1, 2, ... You can derive the value that you need from frameNumber simply by saying
 *
 *        cyclicFrameNumber = frameNumber % N;
 *
 * Then, you just have to base what you draw on cyclicFrameNumber instead of frameNumber. Similarly,
 * for an oscillating animation, you need an "oscillation frame number" that takes on the values
 * 0, 1, 2, ....( N - 1 ), N, ( N - 1 ), ( N - 2 ),...2, 1, 0, 1, 2, and so on repeating the back and
 * forth motion forever. You can compute the value that you need with
 *
 *        oscillationFrameNumber = frameNumber % ( 2 * N )
 *        if ( oscillationFramenumber > N )
 *            oscillationFrameNumber = ( 2 * N ) - oscillationFrameNumber;
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class SimpleAnimation extends Application {

    /**
     * Draws one frame of an animation. This subroutine should be called
     * about 60 times per second.  It is responsible for redrawing the
     * entire drawing area. The parameter g is used for drawing. The frameNumber
     * starts at zero and increases by 1 each time this subroutine is called.
     * The parameter elapsedSeconds gives the number of seconds since the animation
     * was started.  By using frameNumber and/or elapsedSeconds in the drawing
     * code, you can make a picture that changes over time.  That's an animation.
     * The parameters width and height give the size of the drawing area, in pixels.
     */
    public void drawFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {

        g.setFill( Color.TURQUOISE );
        g.fillRect( 0, 0, width, height );

        int cyclicFrameNum;
        int oscillationFrameNum;

        cyclicFrameNum = frameNumber % 535;  // Repeats every 800 frames.
        g.setFill( Color.RED );
        g.fillRect( 1.5 * cyclicFrameNum, 0, 100, 100 );

        cyclicFrameNum = frameNumber % 280;
        g.setFill( Color.GREEN );
        g.fillRect( 3 * cyclicFrameNum, 100, 100, 100 );

        cyclicFrameNum = frameNumber % 400;
        g.setFill( Color.YELLOW );
        g.fillRect( 2 * cyclicFrameNum, 200, 100, 100 );

        oscillationFrameNum = frameNumber % ( 2 * 235 );
        if ( oscillationFrameNum > 235 )
            oscillationFrameNum = ( 2 * 235 ) - oscillationFrameNum;
        g.setFill( Color.BLACK );
        g.fillRect( 3 * oscillationFrameNum, 300, 100, 100 );

        oscillationFrameNum = frameNumber % ( 2 * 175 );
        if ( oscillationFrameNum > 175 )
            oscillationFrameNum = ( 2 * 175 ) - oscillationFrameNum;
        g.setFill( Color.BURLYWOOD );
        g.fillRect( 4 * oscillationFrameNum, 400, 100, 100 );

        oscillationFrameNum = frameNumber % ( 2 * 140 );
        if ( oscillationFrameNum > 140 )
            oscillationFrameNum = ( 2 * 140 ) - oscillationFrameNum;
        g.setFill( Color.ORANGE );
        g.fillRect( 5 * oscillationFrameNum, 500, 100, 100 );

        int y;
        g.setStroke( Color.BLACK );
        for ( y = 100; y <= 500; y += 100 ) {
            g.strokeLine( 0, y, 800, y );
        }

        g.setFill( Color.BLACK );
        g.fillText( "Frame number " + frameNumber, 40, 50 );
        g.fillText( String.format("Elapsed Time: %1.1f seconds", elapsedSeconds), 40, 80);

    }

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public void start(Stage stage) {
        int width = 800;   // The width of the image.  You can modify this value!
        int height = 600;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cyclic And Oscillating Motion."); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
        AnimationTimer anim = new AnimationTimer() {
            private int frameNum;
            private long startTime = -1;
            private long previousTime;
            public void handle(long now) {
                if (startTime < 0) {
                    startTime = previousTime = now;
                    drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
                }
                else if (now - previousTime > 0.95e9/60) {
                    // The test in the else-if is to guard against a bug that has shown
                    // up in some versions of JavaFX on some computers.  The bug allows
                    // the handle() method to be called many times more than the 60 times
                    // per second that is specified in the JavaFX documentation.
                    frameNum++;
                    drawFrame(canvas.getGraphicsContext2D(), frameNum, (now-startTime)/1e9, width, height);
                    previousTime = now;
                }
            }
        };
        anim.start();
    }

    public static void main(String[] args) {
        launch();
    }

} // end SimpleAnimationStarter


