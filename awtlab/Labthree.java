package awtlab;
import javax.swing.*;
import java.awt.*;
public class Labthree {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Personal Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // Padding

        // Create labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");

        // Create text fields
        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        // Load and create the image icon
        ImageIcon imageIcon = new ImageIcon("path/to/your/image.png");
        JLabel imageLabel = new JLabel(imageIcon);

        // Add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        panel.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(emailLabel, constraints);

        constraints.gridx = 1;
        panel.add(emailField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        panel.add(imageLabel, constraints);

        // Add the panel to the frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    }
}
