package swinglab;

import javax.swing.*;
import java.awt.*;


public class Tappedpane {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("TabbedPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Home Tab
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Welcome to the Home Tab!"));
        
        // Profile Tab
        JPanel profilePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        profilePanel.add(new JLabel("Name:"));
        profilePanel.add(new JTextField(15));
        profilePanel.add(new JLabel("Email:"));
        profilePanel.add(new JTextField(15));
        
        // Settings Tab
        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Settings"));
        settingsPanel.add(new JButton("Apply"));
        
        // Add tabs to the tabbed pane
        tabbedPane.addTab("Home", homePanel);
        tabbedPane.addTab("Profile", profilePanel);
        tabbedPane.addTab("Settings", settingsPanel);
        
        // Add the tabbed pane to the frame
        frame.add(tabbedPane);
        
        // Set frame visibility
        frame.setVisible(true);
    }
}
