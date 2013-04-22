package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame {

    // Singleton
    private static final Frame instance = new Frame();
    
    // Framework
    private JFrame frame;
    private Container pane;
    private Insets insets;
    
    // Properties
    private final int WIDTH = 480;
    private final int HEIGHT = 600;
    
    // Constructor
    private Frame() {
        /*
         * Adapt to appear native to the machine. Nothing is done with the
         * exceptions due to the lack of necessity. Avoidance of multi-catch
         * in case recipients lack Java 7 / above
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        // Frame
        frame = new JFrame("V-Word Processor");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Container
        pane = frame.getContentPane();
        pane.setLayout(null);
        
        // Insets
        insets = pane.getInsets();
    }
    
    // Static factory
    public static Frame getInstance() {
        return instance;
    }
    
    // Add components
    public void add(Component comp) {
        pane.add(comp);
    }
    
    // Finalize
    public void finalizeGUI() {
        frame.setVisible(true);
    }
    
    // Get the insets
    public Insets getInsets() {
        return insets;
    }
    
    // Get content pane for external usage
    public Container getPane() {
        return pane;
    }
}
