package gui.menubar;

import gui.frame.Frame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainMenuBar extends JMenuBar {
    
    // Singleton
    private static final MainMenuBar instance = new MainMenuBar();
    
    // Properties
    private final int INIT_WIDTH = 462;
    
    // Constructor
    private MainMenuBar() {
        this.setBounds(Frame.getInstance().getInsets().left, Frame.getInstance().getInsets().top, INIT_WIDTH, this.getPreferredSize().height);
    }
    
    // Static factory
    public static MainMenuBar getInstance() {
        return instance;
    }
    
    public void addMenu(JMenu newMenu) {
        this.add(newMenu);
    }
}
