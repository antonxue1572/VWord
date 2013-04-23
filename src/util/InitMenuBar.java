package util;
import gui.frame.Frame;
import gui.menubar.MainMenuBar;
import gui.menubar.file.FileMenu;
import gui.menubar.file.fileMenuItems.Load;
import gui.menubar.file.fileMenuItems.Print;
import gui.menubar.file.fileMenuItems.Save;
import javax.swing.JMenuItem;

public class InitMenuBar {
    
    // Singleton
    private static final InitMenuBar instance = new InitMenuBar();
    
    // Constructor
    private InitMenuBar() {
        
    }
    
    // Static factory
    public static InitMenuBar getInstance() {
        return instance;
    }
    
    public void init() {
        // File menu
        FileMenu.getInstance().addMenuItem(Save.getInstance());
        FileMenu.getInstance().addMenuItem(Print.getInstance());
        FileMenu.getInstance().addMenuItem(Load.getInstance());
        
        // Add every main menu
        MainMenuBar.getInstance().addMenu(FileMenu.getInstance());
        
        // Finalize dimensions
        MainMenuBar.getInstance().setBounds(Frame.getInstance().getInsets().left, Frame.getInstance().getInsets().top, MainMenuBar.getInstance().getPreferredSize().width, MainMenuBar.getInstance().getPreferredSize().height);
    }
}
