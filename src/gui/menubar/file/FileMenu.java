package gui.menubar.file;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {
    
    // Singleton
    private static final FileMenu instance = new FileMenu();
    
    // Properties
    
    // Constructor
    private FileMenu() {
        super("File");
        this.getAccessibleContext().setAccessibleDescription("Perform various operations");
    }
    
    // Static factory
    public static FileMenu getInstance() {
        return instance;
    }
    
    public void addMenuItem(JMenuItem newMenuItem) {
        this.add(newMenuItem);
    }
}
