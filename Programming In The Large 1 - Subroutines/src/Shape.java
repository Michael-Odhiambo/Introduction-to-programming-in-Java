import javafx.scene.paint.Color;

public abstract class Shape {

    Color color;  // Color of the shape.

    void setColor( Color newColor ) {
        // Method to change the color of the shape.
        color = newColor;   // change the value of the instance variable.
        redraw();  // redraw shape, which will appear in new color.
    }

    abstract void redraw();

}  // end of class Shape.
