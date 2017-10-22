package LemGame;

import java.util.*;

public class Room {

    private String roomName;
    private int roomLocation;
    private int roomBehavior;
    // Room items is not private so that PICKUP methods works in player
     ArrayList<Prop> roomItems = new ArrayList();
    private ArrayList<Room> roomExits = new ArrayList();

    Room(String roomName, int roomLocation) {
        this.roomName = roomName;
        this.roomLocation = roomLocation;
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
