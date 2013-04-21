package gui;

import javax.swing.JTextArea;

public class Field extends JTextArea {
    
    // Singleton
    private static final Field instance = new Field();
    
    // Properties
    private final boolean EDITABLE = true;
    private final boolean LINE_WRAP = true;
    
    // Constructor
    private Field() {
        this.setEditable(EDITABLE);
        this.setLineWrap(LINE_WRAP);
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
