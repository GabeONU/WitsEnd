/**
 * Description:The `MyLabel` class extends `JLabel` and customizes its behavior for specific use cases. 
 * It provides constructors to set initial text and overrides the `setText` method to update the label's text. Additionally, 
 * it overrides the `repaint` and `revalidate` methods to prevent unnecessary component updates, 
 * making it suitable for specialized label functionalities. This class offers a tailored 
 * approach to label manipulation within Swing applications. 
 * Author: Julian Calvelage, Enzo Bordogna and Gabe Parry
 * Date: 5/9/2024
 */

/**
 * The MyLabel class extends the JLabel class and provides custom label functionality.
 */
import javax.swing.JLabel;

public class MyLabel extends JLabel {

    /**
     * Constructs a new MyLabel with the specified text.
     * @param text The initial text to be displayed by the label
     */
    public MyLabel(String text) {
        super(text);
    }
    
    /**
     * Sets the text of this label to the specified text.
     * @param text The text to be set
     */
    @Override
    public void setText(String text) {
        super.setText(text);
    }

    /**
     * Repaints this component. Overrides the method to do nothing.
     */
    @Override
    public void repaint() {
        // Do nothing
    }

    /**
     * Revalidates this component's layout. Overrides the method to do nothing.
     */
    @Override
    public void revalidate() {
        // Do nothing
    }
}
