import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class NewCalcu {

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // * Instantiate JFrame.

        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // * Exits out the application. (We can use DO_NOTHING_ON_CLOSE).
        frame.setResizable(false); // Prevents the frame from being resized.

        ImageIcon image = new ImageIcon("meow.jpg"); // Create an image icon.
        frame.setIconImage(image.getImage()); // Change icon of frame to our specified photo.
        frame.getContentPane().setBackground(Color.black);
    }
    
}