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
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
