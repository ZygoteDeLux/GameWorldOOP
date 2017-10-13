package LemGame;

import java.util.*;

public class Room {

    String roomName;
    int roomLocation;
    String roomBehaviour;
    ArrayList<Prop> roomItems = new ArrayList();

    Room(String roomName, int roomLocation) {
        this.roomName = roomName;
        this.roomLocation = roomLocation;
        
    }

    public String getRoomName() {
        return roomName;
    }
    public void addRoomItem(Prop prop){
        roomItems.add(prop);
    }
    public void removeRoomItem(Prop prop){
        roomItems.remove(prop);
    }
    public String getRoomItems(){
        return roomItems.toString();
    }
    
}
