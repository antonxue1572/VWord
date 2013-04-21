package gui;

import javax.swing.JTextArea;

public class Field extends JTextArea {
    
    // Singleton
    private static final Field instance = new Field();
    
    // Properties
    
    
    // Constructor
    private Field() {
        this.setEditable(true);
        this.setLineWrap(true);
    }
    
    // Static factory
    public static Field getInstance() {
        return instance;
    }
    
    // Get text
    public String getEditorText() {
        return this.getText();
    }
}
