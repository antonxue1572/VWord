package vword;
import gui.FieldWrapper;
import gui.Frame;
import gui.Load;
import gui.Print;
import gui.Save;

public class VWord {

    public static void main(String[] args) {
        
        // Add everything here
        Frame.getInstance().add(FieldWrapper.getInstance());
        Frame.getInstance().add(Save.getInstance());
        Frame.getInstance().add(Print.getInstance());
        Frame.getInstance().add(Load.getInstance());
        
        // Make visible
        Frame.getInstance().finalizeGUI();
    }
}
