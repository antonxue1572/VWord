package gui.menubar.file.fileMenuItems;

import gui.editor.FieldWrapper;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import util.SaveParser;

public class Save extends JMenuItem {
    
    // Singleton
    private static final Save instance = new Save("Save");
    
    // Constructor
    private Save(String newName) {
        super(newName);
        this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        this.getAccessibleContext().setAccessibleDescription("Saves the file");
        this.addActionListener(new SaveActionListener());
    }
    
    // Static factory
    public static Save getInstance() {
        return instance;
    }    
    
    // Helper class
    private class SaveActionListener implements ActionListener {

        // Framework
        private JFrame saveFrame;
        private Container savePane;
        private Insets saveInsets;
        
        // Properties
        private final int SAVE_FRAME_WIDTH = 320;
        private final int SAVE_FRAME_HEIGHT = 150;
        
        // Components
        private JTextField name;
        private JButton confirm;
        
        // Properties
        private final int NAME_COLUMNS = 25;
        private final int NAME_X = 10;
        private final int NAME_Y = 10;
        private final String BUTTON_TEXT = "Confirm";
        private final int CONFIRM_X = 100;
        private final int CONFIRM_Y = 75;
        
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
            confirm.setBounds(saveInsets.left + CONFIRM_X, saveInsets.top + CONFIRM_Y, confirm.getPreferredSize().width, confirm.getPreferredSize().height);
            confirm.addActionListener(new ConfirmActionListener());
            savePane.add(confirm);
        }
        
        // Helper class
        private class ConfirmActionListener implements ActionListener {

            private ArrayList <String> outputData;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintWriter pw;
                outputData = SaveParser.getInstance().parse(FieldWrapper.getInstance().getEditorText());
                try {
                    pw = new PrintWriter(new FileWriter(new File(name.getText() + ".txt")));
                    System.out.println("Ouput data: " + outputData.size());
                    for(int i = 0; i < outputData.size(); ++i) {
                        pw.println(outputData.get(i));
                    }
                    pw.flush();
                    pw.close();
                    outputData.clear();
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
