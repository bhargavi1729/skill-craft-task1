import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageEncrypt {

    public static void main(String[] args) {
        try {
            // Load original image
            BufferedImage image = ImageIO.read(new File("input.jpg"));

            int width = image.getWidth();
            int height = image.getHeight();

            // Pixel-by-pixel encryption
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int pixel = image.getRGB(i, j);

                    // Extract RGB components
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;

                    // Encrypt by inverting colors
                    int newR = 255 - r;
                    int newG = 255 - g;
                    int newB = 255 - b;

                    // Put back encrypted pixel
                    int newPixel = (newR << 16) | (newG << 8) | newB;
                    image.setRGB(i, j, newPixel);
                }
            }

            // Save encrypted image
            ImageIO.write(image, "png", new File("encrypted.png"));

            System.out.println("Encryption complete! Saved as encrypted.png");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
