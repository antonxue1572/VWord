package gui;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame {

    
    // Framework
    private JFrame frame;
    private Container pane;
    private Insets insets;
    
    // Components
    private JTextArea field;
    private JScrollPane fieldWrapper;
    private JButton save;
    private JButton print;
    
    // Misc
    
    
    // Constructor
    public Frame() {
        
}
    
    // Begins stuff
    public void initGUI() {
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
        
        // Components
        initComponents();
        
        // Finalize
        frame.setVisible(true);
    }
    
    private void initComponents() {
        // Main text area
        field = new JTextArea();
        fieldWrapper = new JScrollPane(field);
        field.setEditable(true);
        field.setLineWrap(true);
        fieldWrapper.setWheelScrollingEnabled(true);
        fieldWrapper.setBounds(insets.left + 10, insets.top + 50, 445, 500);
        pane.add(fieldWrapper);
        
        // Toolbar
        // Save
        save = new JButton("Save");
        save.setBounds(insets.left + 330, insets.top + 10, save.getPreferredSize().width, save.getPreferredSize().height);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFrame save = new JFrame("Save");
                save.setSize(200, 100);
                Container sPane = save.getContentPane();
                sPane.setLayout(null);
                Insets sInsets = sPane.getInsets();
                
                final JTextField name = new JTextField(20);
                name.setBounds(sInsets.left + 10, sInsets.top + 10, name.getPreferredSize().width, name.getPreferredSize().height);
                sPane.add(name);
                
                JButton confirm = new JButton("Confirm");
                confirm.setBounds(sInsets.left + 100, sInsets.top + 35, confirm.getPreferredSize().width, confirm.getPreferredSize().height);
                confirm.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            PrintWriter pw = new PrintWriter(new FileWriter(new File(name.getText() + ".txt")));
                            pw.println(getEditorText());
                            pw.flush();
                            pw.close();
                            save.dispose();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    }
                });
                sPane.add(confirm);
                
                save.setVisible(true);
            }
        });
        pane.add(save);
        
        
        // Print
        print = new JButton("Print");
        print.setBounds(insets.left + 400, insets.top + 10, print.getPreferredSize().width, print.getPreferredSize().height);
        pane.add(print);
    }
    
    public String getEditorText() {
        return field.getText();
    }
    
}
