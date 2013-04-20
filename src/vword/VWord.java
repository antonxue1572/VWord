package vword;
import gui.Field;
import gui.Frame;
import gui.Print;
import gui.Save;

public class VWord {

    public static Frame vFrame;
    
    public static void main(String[] args) {
        vFrame = new Frame();
        
        // Add everything here
        vFrame.add(Field.getInstance().getComponent());
        vFrame.add(Save.getInstance().getComponent());
        vFrame.add(Print.getInstance().getComponent());
        
        // Make visible
        vFrame.finalizeGUI();
    }
}
