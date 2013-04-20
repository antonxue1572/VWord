package util;

import java.util.ArrayList;

public class PrintParser extends Parser {

    // Singleton
    private static final PrintParser instance = new PrintParser();
            
    // Constructor
    private PrintParser() {
        
    }
    
    // Static factory
    public static Parser getInstance() {
        return instance;
    }
    
    @Override
    public ArrayList<String> parse(String src) {
        
        StringBuffer sb = new StringBuffer(src);
        int iterAmount = sb.length() / 50;
        
        for(int i = 0; i < iterAmount; ++i) {
            output.add(sb.substring(0, 50));
            sb.delete(0, 50);
        }
        output.add(sb.substring(0));
        
        // Make "dummy" and clear original one
        ArrayList <String> temp = new ArrayList <String> ();
        for(int i = 0; i < output.size(); ++i) {
            temp.add(output.get(i));
        }
        output.clear();
        
        return temp;
    }

}
