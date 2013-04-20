package gui;

import java.awt.Container;
import java.awt.Insets;
import javax.swing.JFrame;

public class Frame {

    // Framework
    private JFrame frame;
    private Container pane;
    private Insets insets;
    
    // Constructor
    public Frame() {
        
}
    
    // Begins stuff
    public void initGUI() {
        // Frame
        frame = new JFrame("VWord Processor");
        frame.setSize(480, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Container
        pane = frame.getContentPane();
        pane.setLayout(null);
        
        // Insets
    }
    
}
