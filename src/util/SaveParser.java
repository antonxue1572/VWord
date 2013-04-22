package util;

import java.util.ArrayList;

public class SaveParser extends Parser {

    // Singleton
    private static final SaveParser instance = new SaveParser();
    
    // Constrctor
    private SaveParser() {
        
    }
    
    // Static factory
    public static Parser getInstance() {
        return instance;
    }
    
    @Override
    public ArrayList<String> parse(String src) {
    
        StringBuffer sb = new StringBuffer(src);
        
        if(sb.indexOf("\n") != -1) {
            while(sb.indexOf("\n") != -1) {
                output.add(sb.substring(0, sb.indexOf("\n")));
                sb.delete(0, sb.indexOf("\n") + 1);
            }
        } else {
            output.add(sb.toString());
        }
        // Add remaining bits
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
