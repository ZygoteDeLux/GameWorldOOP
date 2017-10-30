package LemGame;

import java.util.*;

public class Room {

    //instance variables that defines a Room
    private String roomName;
    private int roomLocation;
    private int roomBehavior;
    private String roomDescription;
    ArrayList<Prop> roomItems = new ArrayList(); // ArrayList that holds props in the room.
    ArrayList<Room> roomExits = new ArrayList(); // ArrayList that holds room exits.

    Room(String roomName, int roomLocation) { //Constructor that sets a start value for roomName and roomLocation.
        this.roomName = roomName; // give roomName a start value
        this.roomLocation = roomLocation; // give roomLocation a start value
        this.roomBehavior = 1; //set roomBehavior to 1.
    }

    public void addRoomItem(Prop prop) { //add item to room
        roomItems.add(prop);
    }

    public void removeRoomItem(Prop prop) { // remove item from room
        roomItems.remove(prop);
    }

    public String getRoomName() { //return roomName
        return roomName;
    }
    public void setRoomExit(Room room) { //set a new roomExit
        roomExits.add(room);
    }

    public int getRoomLocation() { //r return room Location
        return roomLocation;
    }

    public int getRoomBehavior() { //return roomBehavior
        return roomBehavior;
    }

    public void setRoomBehavior(int roomBehavior) { //set a new value for roomBehavior
        this.roomBehavior = roomBehavior;
    }

    public String getRoomDescription() { //return roomDescription
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) { //set a new roomDescription
        this.roomDescription = roomDescription;
    }
   
}
