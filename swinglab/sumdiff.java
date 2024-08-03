package swinglab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class sumdiff {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Sum and Difference Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        
        // Set the layout
        frame.setLayout(new GridLayout(3, 2, 5, 5));
        
        // Create labels
        JLabel label1 = new JLabel("Number 1:");
        JLabel label2 = new JLabel("Number 2:");
        JLabel resultLabel = new JLabel("Result:");
        
        // Create text fields
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        
        // Create result display label
        JLabel outputLabel = new JLabel("");
        
        // Add mouse listener to the result label
        resultLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double sum = num1 + num2;
                    outputLabel.setText("Sum: " + sum);
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Invalid input");
                }
            }
            
            public void mouseReleased(MouseEvent e) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double difference = num1 - num2;
                    outputLabel.setText("Difference: " + difference);
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Invalid input");
                }
            }
        });
        
        // Add components to the frame
        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(resultLabel);
        frame.add(outputLabel);
        
        // Set frame visibility
        frame.setVisible(true);
    }
}
