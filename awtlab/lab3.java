package awtlab;
import java.awt.*;
import java.awt.event.*;

public class lab3 extends Frame implements MouseListener {

    Label label;

    lab3() {
        // Create a frame
        Frame frame = new Frame("Mouse Event Demo");

        // Create a label
        label = new Label();
        label.setBounds(50, 100, 200, 30);
        label.setAlignment(Label.CENTER);

        // Add mouse listener to the frame
        frame.addMouseListener(this);

        // Add the label to the frame
        frame.add(label);

        // Set frame size and layout
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        // Handle frame close event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    // Override the mouse event methods
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked");
    }

    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered");
    }

    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited");
    }

    public void mousePressed(MouseEvent e) {
        // Not used, but must be defined
    }

    public void mouseReleased(MouseEvent e) {
        // Not used, but must be defined
    }

    public static void main(String[] args) {
        new lab3();
    }
}
