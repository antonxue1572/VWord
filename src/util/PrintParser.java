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
        int iterAmount = sb.length() / 96;
        
        for(int i = 0; i < iterAmount; ++i) {
            output.add(sb.substring(0, 96));
            sb.delete(0, 96);
        }
        
        // Get last bit
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
