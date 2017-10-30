package LemGame;

import java.util.*;

public class NPC{

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

    public Room getNpcRoom() {
        return npcRoom;
    }

    public void npcMove(){
        Random random = new Random();
        npcRoom = npcRoom.roomExits.get(random.nextInt(npcRoom.roomExits.size()));
    }

    public void setNpcRoom(Room npcRoom) {
        this.npcRoom = npcRoom;
    }


}
