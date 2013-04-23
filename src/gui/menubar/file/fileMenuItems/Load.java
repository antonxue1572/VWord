package gui.menubar.file.fileMenuItems;

import gui.editor.FieldWrapper;
import gui.frame.Frame;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Load extends JMenuItem {
    
    // Singleton
    private static final Load instance = new Load();
    
    // Constructor
    private Load() {
        super("Load");
        this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        this.getAccessibleContext().setAccessibleDescription("Loads a file");
        this.addActionListener(new LoadActionListener());
    }
    
    // Static factory
    public static Load getInstance() {
        return instance;
    }
    
    
    // Helper class
    private class LoadActionListener implements ActionListener {

        // Framework
        private JFrame loadFrame;
        private Container loadPane;
        private Insets loadInsets;
        
        // Components
        private JTextField name;
        private JButton confirm;
        
        // Properties
        private final int LOAD_FRAME_WIDTH = 320;
        private final int LOAD_FRAME_HEIGHT = 150;
        private final int NAME_COLUMNS = 25;
        private final int NAME_X = 10;
        private final int NAME_Y = 10;
        private final int CONFIRM_X = 100;
        private final int CONFIRM_Y = 75;
        
        public LoadActionListener() {
            // Frame
            loadFrame = new JFrame("Load existing");
            loadFrame.setSize(LOAD_FRAME_WIDTH, LOAD_FRAME_HEIGHT);
            
            // Container
            loadPane = loadFrame.getContentPane();
            loadPane.setLayout(null);
            
            // Insets
            loadInsets = loadPane.getInsets();
            
            // Components
            // Text field
            name = new JTextField(NAME_COLUMNS);
            name.setBounds(loadInsets.left + NAME_X, loadInsets.top + NAME_Y, name.getPreferredSize().width, name.getPreferredSize().height);
            loadPane.add(name);
            
            // Confirm button
            confirm = new JButton("Confirm");
            confirm.setBounds(loadInsets.left + CONFIRM_X, loadInsets.top + CONFIRM_Y, confirm.getPreferredSize().width, confirm.getPreferredSize().height);
            confirm.addActionListener(new ConfirmActionListener());
            loadPane.add(confirm);
        }
        
        // Inner helper class
        private class ConfirmActionListener implements ActionListener {

            BufferedReader reader;
            
            // Constructor
            public ConfirmActionListener() {
                
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Create reader, read file, and export to editor
                    reader = new BufferedReader(new FileReader(new File(name.getText() + ".txt")));
                    StringBuffer fileTextBuffer = new StringBuffer();
                    String fileText;
                    try {
                        while((fileText = reader.readLine()) != null) {
                            fileTextBuffer.append(fileText + "\n");
                        }
                        FieldWrapper.getInstance().setEditorText(fileTextBuffer.toString());
                    } catch (IOException ex) {
                        // Pop-up box for IOException
                        // Frame
                        JFrame pop = new JFrame("Exception!");
                        pop.setSize(100, 100);
                        Container pPane = pop.getContentPane();
                        pPane.setLayout(null);
                        Insets pInsets = pPane.getInsets();
                        
                        // Components
                        JLabel message = new JLabel("IOException");
                        message.setBounds(JLabel.CENTER, JLabel.CENTER, message.getPreferredSize().width, message.getPreferredSize().height);
                        pPane.add(message);
                        
                        // Finalize
                        pop.setVisible(true);
                    }
                } catch (FileNotFoundException ex) {
                    // Pop-up box for FileNotFoundException
                    // Frame
                    JFrame pop = new JFrame("Exception!");
                    pop.setSize(100, 100);
                    Container pPane = pop.getContentPane();
                    Insets pInsets = pPane.getInsets();
                    
                    // Components
                    JLabel message = new JLabel("FileNotFoundException");
                    message.setBounds(JLabel.CENTER, JLabel.CENTER, message.getPreferredSize().width, message.getPreferredSize().height);
                    pPane.add(message);
                    
                    // Finalize
                    pop.setVisible(true);
                }
                
                // Close
                loadFrame.dispose();
            }
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            loadFrame.setVisible(true);
        }
        
    }
    
}
