import javax.swing.JLabel;
import javax.swing.JLabel;

public class MyLabel extends JLabel{

    public MyLabel(String text) {
        super(text);
    }
    
    @Override
    public void setText(String text) {
        super.setText(text);
    }

        @Override
        public void repaint() {
            // Do nothing
        }

        @Override
        public void revalidate() {
            // Do nothing
        }
    
}
