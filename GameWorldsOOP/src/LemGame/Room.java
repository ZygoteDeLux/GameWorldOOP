package LemGame;

import java.util.*;

public class Room {

    private String roomName;
    private int roomLocation;
    private int roomBehavior;
    private String roomDescription;

    // Room items is not private so that PICKUP methods works in player
    //ÆNDRET
    ArrayList<Prop> roomItems = new ArrayList();
    ArrayList<Room> roomExits = new ArrayList();

    Room(String roomName, int roomLocation) {
        this.roomName = roomName;
        this.roomLocation = roomLocation;
        this.roomBehavior = 1;
    }
//ÆNDRET

    public void addRoomItem(Prop prop) {
        roomItems.add(prop);
    }

    public void removeRoomItem(Prop prop) {
        roomItems.remove(prop);
    }

    public String getRoomName() {
        return roomName;
    }
      public void removeAllRoomItems() {
        roomItems.clear();
    }

    public String getRoomItems() {
        return roomItems.toString();
    }

    public void setRoomExit(Room room) {
        roomExits.add(room);
    }

    public String getRoomExit() {
        return roomExits.toString();
    }

    public int getRoomLocation() {
        return roomLocation;
    }

    //pænere
    @Override
    public String toString() {
        return roomName;
    }

    public int getRoomBehavior() {
        return roomBehavior;
    }

    public void setRoomBehavior(int roomBehavior) {
        this.roomBehavior = roomBehavior;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
   
}
