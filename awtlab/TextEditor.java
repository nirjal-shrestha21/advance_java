package awtlab;



import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends Frame implements ActionListener {
    TextArea textArea;
    MenuBar menuBar;
    Menu fileMenu, editMenu, formatMenu;
    MenuItem newItem, openItem, saveItem, closeItem, fontItem, colorItem;
    FileDialog fileDialogOpen, fileDialogSave;

    public TextEditor() {
        // Frame properties
        setTitle("AWT Text Editor");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Text area
        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        // Menu bar
        menuBar = new MenuBar();

        // File menu
        fileMenu = new Menu("File");
        newItem = new MenuItem("New");
        openItem = new MenuItem("Open");
        saveItem = new MenuItem("Save");
        closeItem = new MenuItem("Close");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);
        menuBar.add(fileMenu);

        // Edit menu
        editMenu = new Menu("Edit");
        // Add edit menu items like cut, copy, paste here if needed
        menuBar.add(editMenu);

        // Format menu
        formatMenu = new Menu("Format");
        fontItem = new MenuItem("Font");
        colorItem = new MenuItem("Color");
        formatMenu.add(fontItem);
        formatMenu.add(colorItem);
        menuBar.add(formatMenu);

        // Add menu bar to frame
        setMenuBar(menuBar);

        // File dialogs
        fileDialogOpen = new FileDialog(this, "Open File", FileDialog.LOAD);
        fileDialogSave = new FileDialog(this, "Save File", FileDialog.SAVE);

        // Add action listeners
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        closeItem.addActionListener(this);
        fontItem.addActionListener(this);
        colorItem.addActionListener(this);

        // Window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                textArea.setText("");
                break;
            case "Open":
                openFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Close":
                System.exit(0);
                break;
            case "Font":
                changeFont();
                break;
            case "Color":
                changeColor();
                break;
        }
    }

    private void openFile() {
        fileDialogOpen.setVisible(true);
        String directory = fileDialogOpen.getDirectory();
        String file = fileDialogOpen.getFile();
        if (directory != null && file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(directory + file))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFile() {
        fileDialogSave.setVisible(true);
        String directory = fileDialogSave.getDirectory();
        String file = fileDialogSave.getFile();
        if (directory != null && file != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(directory + file))) {
                bw.write(textArea.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void changeFont() {
        Font currentFont = textArea.getFont();
        Font newFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        textArea.setFont(newFont);
    }

    private void changeColor() {
        Color newColor = Color.BLUE;
        textArea.setForeground(newColor);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.setVisible(true);
    }
}
