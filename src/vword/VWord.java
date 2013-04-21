package vword;
import gui.FieldWrapper;
import gui.Frame;
import gui.Print;
import gui.Save;

public class VWord {

    
    public static void main(String[] args) {
        
        // Add everything here
        Frame.getInstance().add(FieldWrapper.getInstance());
        Frame.getInstance().add(Save.getInstance());
        Frame.getInstance().add(Print.getInstance());
        
        // Make visible
        Frame.getInstance().finalizeGUI();
    }
}
