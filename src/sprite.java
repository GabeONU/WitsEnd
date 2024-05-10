/**
 * Description:The `sprite` class represents a sprite object in a graphical environment, 
 * storing its position and image data. It includes attributes for the sprite's x, y, and z-coordinate positions, 
 * as well as its width, height, and file path to the image. 
 * The class provides methods to set the ImageIcon for displaying the sprite and to load and 
 * scale the sprite image from the specified file path with the given dimensions. This class encapsulates the functionality necessary 
 * to manage and display sprites within a graphical application.
 * Author: Julian Calvelage, Enzo Bordogna and Gabe Parry
 * Date: 5/9/2024
 */

/**
 * The Sprite class represents a sprite with position and image properties.
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class sprite {
	
    public int xPos; // The x-coordinate position of the sprite
    public int yPos; // The y-coordinate position of the sprite
    public int zPos; // The z-coordinate position of the sprite

    public int width; // The width of the sprite
    public int height; // The height of the sprite

    public String imgPath; // The file path to the image of the sprite

    public ImageIcon imageIcon = new ImageIcon(); // The ImageIcon used to display the sprite image
    
    /**
     * Sets the ImageIcon for the sprite using the specified image path, width, and height.
     */
    public void setIcon() {
        imageIcon.setImage(setSpriteImage(imgPath, width, height));
    }
    
    /**
     * Loads and scales the sprite image from the specified file path with the given width and height.
     * @param imgPath The file path to the sprite image
     * @param w The desired width of the sprite image
     * @param h The desired height of the sprite image
     * @return The scaled sprite image
     */
    public Image setSpriteImage(String imgPath, int w, int h) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath)); // Read the image from file
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Scale the image to the specified width and height
        Image dimg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return dimg;
    }
}
