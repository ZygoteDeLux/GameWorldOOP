package LemGame;

import java.util.*;

public class Room {

    private String roomName;
    private int roomLocation;
    private int roomBehavior;
    // Room items is not private so that PICKUP methods works in player
    //ÆNDRET
     HashMap<Prop, String> roomItems = new HashMap();
    private ArrayList<Room> roomExits = new ArrayList();

    Room(String roomName, int roomLocation) {
        this.roomName = roomName;
        this.roomLocation = roomLocation;
        this.roomBehavior = 1;
    }
//ÆNDRET
    public void addRoomItem(Prop prop){
        roomItems.put(prop, prop.getPropDescription());
    }
    public void removeRoomItem(Prop prop){
        roomItems.remove(prop);
    }
    public String getRoomItems(){
        return roomItems.toString();
    }
    public void setRoomExit(Room room){
        roomExits.add(room);
    }
    public String getRoomExit(){
        return roomExits.toString();
    }
    public int getRoomLocation(){
        return roomLocation;
    }

    @Override
    public String toString() {
        return "Room{" + "roomName=" + roomName + '}';
    }

    public int getRoomBehavior() {
        return roomBehavior;
    }

    public void setRoomBehavior(int roomBehavior) {
        this.roomBehavior = roomBehavior;
    }
    
    
}
