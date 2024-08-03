import java.awt.*;
import java.awt.event.*;

public class TextEditor extends Frame implements ActionListener {
    // Components of the text editor
    TextArea textArea;
    MenuBar menuBar;
    Menu fileMenu, editMenu, formatMenu;
    MenuItem newFile, openFile, saveFile, closeFile;
    MenuItem cut, copy, paste, selectAll;
    MenuItem bold, italic, underline;

    // Constructor
    TextEditor() {
        // Frame properties
        setTitle("Text Editor");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Text area
        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        // Menu bar
        menuBar = new MenuBar();
        setMenuBar(menuBar);

        // File menu
        fileMenu = new Menu("File");
        newFile = new MenuItem("New");
        openFile = new MenuItem("Open");
        saveFile = new MenuItem("Save");
        closeFile = new MenuItem("Close");
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(closeFile);
        menuBar.add(fileMenu);

        // Edit menu
        editMenu = new Menu("Edit");
        cut = new MenuItem("Cut");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");
        selectAll = new MenuItem("Select All");
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(selectAll);
        menuBar.add(editMenu);

        // Format menu
        formatMenu = new Menu("Format");
        bold = new MenuItem("Bold");
        italic = new MenuItem("Italic");
        underline = new MenuItem("Underline");
        formatMenu.add(bold);
        formatMenu.add(italic);
        formatMenu.add(underline);
        menuBar.add(formatMenu);

        // Adding action listeners
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        closeFile.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        bold.addActionListener(this);
        italic.addActionListener(this);
        underline.addActionListener(this);

        // Window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    // Action handler
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        switch (command) {
            case "New":
                textArea.setText("");
                break;
            case "Open":
                // Add code to open a file
                break;
            case "Save":
                // Add code to save a file
                break;
            case "Close":
                dispose();
                break;
            case "Cut":
                textArea.cut();
                break;
            case "Copy":
                textArea.copy();
                break;
            case "Paste":
                textArea.paste();
                break;
            case "Select All":
                textArea.selectAll();
                break;
            case "Bold":
                // Add code to make text bold
                break;
            case "Italic":
                // Add code to make text italic
                break;
            case "Underline":
                // Add code to underline text
                break;
        }
    }

    public static void main(String[] args) {
        new TextEditor().setVisible(true);
    }
}
