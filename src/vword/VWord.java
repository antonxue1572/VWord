package vword;
import gui.editor.FieldWrapper;
import gui.frame.Frame;
import gui.menubar.MainMenuBar;
import util.Adjuster;
import util.InitMenuBar;

public class VWord {

    public static void main(String[] args) {
                
        // Add everything here
        Frame.getInstance().add(FieldWrapper.getInstance());
        
        // Menu bars
        InitMenuBar.getInstance().init();
        Frame.getInstance().add(MainMenuBar.getInstance());
        
        // Make visible
        Frame.getInstance().finalizeGUI();
        
        // Update
        new Thread(Adjuster.getInstance()).start();
    }
}
