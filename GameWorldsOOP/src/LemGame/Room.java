package LemGame;
import java.util.*;
public class Room {
    
    private String description;
    private HashMap<String, Room> exits;
    
    
    
    Room(String description){
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    
    
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
        
    }
    
    public String getShortDescription(){
        return description;
    }

   
    
    
}
