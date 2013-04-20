package vword;
import gui.Field;
import gui.Frame;
import gui.Save;

public class VWord {

    public static Frame vFrame;
    
    public static void main(String[] args) {
        vFrame = new Frame();
        vFrame.initComponents();
        vFrame.finalizeGUI();
    }
}
