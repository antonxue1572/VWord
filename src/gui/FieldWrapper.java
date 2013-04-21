package gui;

import javax.swing.JScrollPane;

public class FieldWrapper extends JScrollPane {
    
    // Singleton
    private static final FieldWrapper instance = new FieldWrapper();
        
    // Properties 462, 555 ; -18, -45
    private final int FIELD_WIDTH = 442;
    private final int FIELD_HEIGHT = 495;
    private final int FIELD_X = 10;
    private final int FIELD_Y = 50;
    
    // Constructor
    private FieldWrapper() {
        super(Field.getInstance());
        this.setWheelScrollingEnabled(true);
        this.setBounds(Frame.getInstance().getInsets().left + FIELD_X, Frame.getInstance().getInsets().top + FIELD_Y, FIELD_WIDTH, FIELD_HEIGHT);
    }
    
    // Static factory
    public static FieldWrapper getInstance() {
        return instance;
    }
    
    // Get the text
    public String getEditorText() {
        return Field.getInstance().getText();
    }    
    
    // Set the text
    public void setEditorText(String newText) {
        Field.getInstance().setText(newText);
        this.repaint();
    }
}
