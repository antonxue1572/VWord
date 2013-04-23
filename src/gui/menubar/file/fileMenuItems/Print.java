package gui.menubar.file.fileMenuItems;

import gui.editor.FieldWrapper;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import util.PrintParser;

public class Print extends JMenuItem {
    
    // Singleton
    private static final Print instance = new Print();
    
    // Constructor
    private Print() {
        super("Print");
        this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        this.getAccessibleContext().setAccessibleDescription("Prints the file");
        this.addActionListener(new PrintActionListener());
    }
    
    // Static factory
    public static Print getInstance() {
        return instance;
    }
    
    
    // Helper class
    private class PrintActionListener implements ActionListener, Printable {

        private ArrayList <String> printOutput;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            if(job.printDialog() == true) {
                try {
                    job.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            
            if(pageIndex > 0) {
                return NO_SUCH_PAGE;
            }
            Graphics2D g = (Graphics2D)graphics;
            g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            
            // Get text and output it
            printOutput = PrintParser.getInstance().parse(FieldWrapper.getInstance().getEditorText());
            for(int i = 0; i < printOutput.size(); ++i) {
                g.drawString(printOutput.get(i), 48, 72 + 24 * i);
            }
            return PAGE_EXISTS;
        }
        
    }
    
}
