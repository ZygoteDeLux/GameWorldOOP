package LemGame;

import java.util.*;

public class Room {

    String roomName;
    int roomLocation;
    String roomBehaviour;
    ArrayList<Prop> roomItems = new ArrayList();
    ArrayList<Room> roomExits = new ArrayList();

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

    @Override
    public String toString() {
        return "Room{" + "roomName=" + roomName + '}';
    }
    
    
}
