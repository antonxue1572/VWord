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
        int j = 0;
        for(int i = 0; i < src.length() % 100; ++i, ++j) {
            String temp = src.substring(0, 100);
            output.add(temp);
        }
        
        // Make "dummy" and clear original one
        ArrayList <String> temp = new ArrayList <String> ();
        for(int i = 0; i < output.size(); ++i) {
            temp.add(output.get(i));
        }
        
        output.clear();
        
        return temp;
    }

}
