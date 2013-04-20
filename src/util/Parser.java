package util;

import java.util.ArrayList;

public abstract class Parser {
    
    protected ArrayList <String> output = new ArrayList <String> ();
    
    public abstract ArrayList <String> parse(String src);
    
}
