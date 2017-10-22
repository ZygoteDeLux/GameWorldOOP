package LemGame;

import java.util.*;

public class NPC {

    private String npcName;
    private String npcDiscription;
    private Room npcRoom;

    NPC(String npcName, String npcDiscription, Room npcRoom) {
        this.npcName = npcName;
        this.npcDiscription = npcDiscription;
        this.npcRoom = npcRoom;

    }

    public String getNpcDiscription() {
        return npcDiscription;
    }

    public String getNpcName() {
        return npcName;
    }

    public String getNpcRoom() {
        return npcRoom.toString();
    }

    //TO DO MOVE NPC TO RANDOM ROOM
//    public void randomRoom() {
//        this.npcRoom.getRoomLocation();
//    }
//    

}
