
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyImage {

    public static void main( String[] args ) throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File( "E:\\Gallery\\Cars\\bmwm20200427123716431.jpg" );
        img = ImageIO.read(f);

        int width = img.getWidth();
        int height = img.getHeight();

        width = width / 10;
        height = height / 10;

        System.out.println( width );
        System.out.println( height );


        for ( int i = 0; i < width; i++ ) {
            for ( int j = 0; j < height; j++ ) {
                int p = img.getRGB( i, j );

                int alpha = ( p >> 24 ) & 0xff;
                int red = ( p >> 16) & 0xff;
                int green = ( p >> 8 ) & 0xff;
                int blue = p & 0xff;
                System.out.printf( "%d %d %d %d \n", alpha, red, green, blue );
            }
        }



    }
}
