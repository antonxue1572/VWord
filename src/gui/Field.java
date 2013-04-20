package gui;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class Field extends Frame {
    
    // Singleton
    private static final Field instance = new Field();
    
    // Component
    private JTextArea field;
    private JScrollPane fieldWrapper;
    
    // Properties 462, 555 ; -18, -45
    private final int FIELD_WIDTH = 442;
    private final int FIELD_HEIGHT = 495;
    private final int FIELD_X = 10;
    private final int FIELD_Y = 50;
    
    // Constructor
    private Field() {
        field = new JTextArea();
        fieldWrapper = new JScrollPane(field);
        field.setEditable(true);
        field.setLineWrap(true);
        fieldWrapper.setWheelScrollingEnabled(true);
        fieldWrapper.setBounds(insets.left + FIELD_X, insets.top + FIELD_Y, FIELD_WIDTH, FIELD_HEIGHT);
    }
    
    // Static factory
    public static Field getInstance() {
        return instance;
    }
    
    public String getEditorText() {
        return field.getText();
    }
    
    @Override
    public Component getComponent() {
        return fieldWrapper;
    }
    
}
