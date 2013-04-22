package util;

import gui.FieldWrapper;
import gui.Frame;
import gui.Load;
import gui.Print;
import gui.Save;

public class Adjuster implements Runnable {
    
    // Singleton
    private static final Adjuster instance = new Adjuster();
    
    // Constructor
    private Adjuster() {
        
    }
    
    // Static factory
    public static Adjuster getInstance() {
        return instance;
    }

    // Run method for threads
    @Override
    public void run() {
        while(true) {
            // Maximum width for editor
            if(Frame.getInstance().getPane().getWidth() > 1020) {
                FieldWrapper.getInstance().setBounds((Frame.getInstance().getPane().getWidth() - FieldWrapper.getInstance().getMaxWidth()) / 2, FieldWrapper.getInstance().getY(), FieldWrapper.getInstance().getMaxWidth(), Frame.getInstance().getPane().getHeight() - 70);
            } else {
                FieldWrapper.getInstance().setBounds(FieldWrapper.getInstance().getX(), FieldWrapper.getInstance().getY(), Frame.getInstance().getPane().getWidth() - 40, Frame.getInstance().getPane().getHeight() - 70);
            }
            
            // Toolbar
            Print.getInstance().setBounds(Frame.getInstance().getPane().getWidth() - 78, Print.getInstance().getY(), Print.getInstance().getPreferredSize().width, Print.getInstance().getPreferredSize().height);
            Save.getInstance().setBounds(Frame.getInstance().getPane().getWidth() - 78 - Print.getInstance().getWidth() - 20, Save.getInstance().getY(), Save.getInstance().getPreferredSize().width, Save.getInstance().getPreferredSize().height);
            Load.getInstance().setBounds(Frame.getInstance().getPane().getWidth() - 78 - Print.getInstance().getWidth() - 20 - Save.getInstance().getWidth() - 20, Load.getInstance().getY(), Load.getInstance().getWidth(), Load.getInstance().getHeight());
            
            // Finalize
            Frame.getInstance().getPane().repaint();
        }
    }
    
}
