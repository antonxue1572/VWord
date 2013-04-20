package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vword.VWord;

public class Frame {

    
    // Framework
    protected JFrame frame;
    protected Container pane;
    protected Insets insets;
    
    // Important numbers
    protected final int WIDTH_ACCOM = 9;
    
    // Components
    private JButton print;
    
    // Misc
    
    
    // Constructor
    public Frame() {
        try {
            // Fancy
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        
        // Frame
        frame = new JFrame("VWord Processor");
        frame.setSize(480, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Container
        pane = frame.getContentPane();
        pane.setLayout(null);
        
        // Insets
        insets = pane.getInsets();
    }
    
    
    // Finalize
    public void finalizeGUI() {
        frame.setVisible(true);
    }
    
    public void initComponents() {
        
        
        pane.add(Print.getInstance().getComponent());
        pane.add(Field.getInstance().getComponent());
        pane.add(Save.getInstance().getComponent());
    }
    
    
    public Component getComponent() {
        return null;
    }
    
}
