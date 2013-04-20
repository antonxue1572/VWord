package gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JButton;

public class Print extends Frame {
    
    // Singleton
    private static final Print instance = new Print();
    
    // Components
    JButton print;
    
    // Component properties
    private final int PRINT_X = 400;
    private final int PRINT_Y = 10;
    
    // Constructor
    private Print() {
        print = new JButton("Print");
        print.setBounds(insets.left + PRINT_X, insets.top + PRINT_Y, print.getPreferredSize().width, print.getPreferredSize().height);
        print.addActionListener(new PrintActionListener());
    }
    
    // Static factory
    public static Print getInstance() {
        return instance;
    }
    
    @Override
    public Component getComponent() {
        return print;
    }
    
    
    // Helper class
    private class PrintActionListener implements ActionListener, Printable {

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
            g.drawString(Field.getInstance().getEditorText(), 24, 24);
            return PAGE_EXISTS;
        }
        
        
    }
    
}
