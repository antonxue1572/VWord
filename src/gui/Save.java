package gui;

import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public final class Save extends Frame {
    
    // Singleton
    private static final Save instance = new Save();
    
    // Component
    private JButton save;
    
    // Properties
    private final int SAVE_X = 330;
    private final int SAVE_Y = 10;
    
    // Constructor
    private Save() {
        save = new JButton("Save");
        save.setBounds(insets.left + SAVE_X, insets.top + SAVE_Y, save.getPreferredSize().width, save.getPreferredSize().height);
        save.addActionListener(new SaveActionListener());
    }
    
    // Static factory
    public static Save getInstance() {
        return instance;
    }
    
    @Override
    public Component getComponent() {
        return save;
    }
    
    
    // Helper class
    private class SaveActionListener implements ActionListener {

        // Framework
        private JFrame saveFrame;
        private Container savePane;
        private Insets saveInsets;
        
        // Framework properties
        private final int SAVE_FRAME_WIDTH = 275;
        private final int SAVE_FRAME_HEIGHT = 150;
        
        // Components
        private JTextField name;
        private JButton confirm;
        
        // Component properties
        private final int NAME_COLUMNS = 20;
        private final int NAME_X = 10;
        private final int NAME_Y = 10;
        private final String BUTTON_TEXT = "Confirm";
        private final int BUTTON_X = 100;
        private final int BUTTON_Y = 75;
        
        public SaveActionListener() {
            // Frame
            saveFrame = new JFrame("Save");
            saveFrame.setSize(SAVE_FRAME_WIDTH, SAVE_FRAME_HEIGHT);
            
            // Container
            savePane = saveFrame.getContentPane();
            savePane.setLayout(null);
            
            // Insets
            saveInsets = savePane.getInsets();
            
            // Components
            // Text field
            name = new JTextField(NAME_COLUMNS);
            name.setBounds(saveInsets.left + NAME_X, saveInsets.top + NAME_Y, name.getPreferredSize().width, name.getPreferredSize().height);
            savePane.add(name);
            
            // Confirmation button
            confirm = new JButton(BUTTON_TEXT);
            confirm.setBounds(saveInsets.left + BUTTON_X, saveInsets.top + BUTTON_Y, confirm.getPreferredSize().width, confirm.getPreferredSize().height);
            confirm.addActionListener(new ConfirmActionListener());
            savePane.add(confirm);
        }
        
        // Helper class
        private class ConfirmActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                PrintWriter pw;
                try {
                    pw = new PrintWriter(new FileWriter(new File(name.getText() + ".txt")));
                    // TODO: Make parser and get text
                    pw.println(Field.getInstance().getEditorText());
                    pw.flush();
                    pw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                saveFrame.dispose();
            }
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            saveFrame.setVisible(true);
        }
        
    }
    
}
