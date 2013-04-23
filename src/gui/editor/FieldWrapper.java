package gui.editor;

import gui.editor.Field;
import gui.frame.Frame;
import java.awt.Font;
import javax.swing.JScrollPane;

public class FieldWrapper extends JScrollPane {
    
    // Singleton
    private static final FieldWrapper instance = new FieldWrapper();
        
    // Properties 462, 555 ; -18, -45
    private final int INIT_WIDTH = 422;
    private final int INIT_HEIGHT = 485;
    private final int MAX_WIDTH = 1000;
    private final int MAX_HEIGHT = 1600;
    private final int INIT_X = 20;
    private final int INIT_Y = 50;
    
    // Constructor
    private FieldWrapper() {
        super(Field.getInstance());
        this.setWheelScrollingEnabled(true);
        this.setBounds(Frame.getInstance().getInsets().left + INIT_X, Frame.getInstance().getInsets().top + INIT_Y, INIT_WIDTH, INIT_HEIGHT);
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
    
    // Get maximum width
    public int getMaxWidth() {
        return MAX_WIDTH;
    }
    
    // Get maximum height
    public int getMaxHeight() {
        return MAX_HEIGHT;
    }
}
