package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame {

    // Framework
    protected JFrame frame;
    protected Container pane;
    protected Insets insets;
    
    // Constructor
    public Frame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        // Frame
        frame = new JFrame("V-Word Processor");
        frame.setSize(480, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Container
        pane = frame.getContentPane();
        pane.setLayout(null);
        
        // Insets
        insets = pane.getInsets();
    }
    
    // Add components
    public void add(Component comp) {
        pane.add(comp);
    }
    
    // Finalize
    public void finalizeGUI() {
        frame.setVisible(true);
    }
    
    // To be overriden
    public Component getComponent() {
        throw new UnsupportedOperationException("Unsuportted; must override");
    }
    
}
