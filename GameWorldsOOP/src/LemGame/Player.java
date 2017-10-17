package LemGame;

import java.util.*;

public class Player {

    private String playerName;
    private int playerCurrency;
    private Room currentPlayerRoom;
    private int playerDrunk;
    private ArrayList<Prop> bag = new ArrayList();
    private boolean alreadyExecuted = true;
    private boolean alreadyExecuted1 = true;
    private boolean alreadyExecuted2 = true;
    private boolean alreadyExecuted3 = true;

    Player(String playerName) {
        this.playerName = playerName;
        this.playerCurrency = 0;
        this.playerDrunk = 0;
        //this.currentPlayerRoom = room;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerCurrency() {
        return playerCurrency;
    }

    public void addCurrency(int currency) {
        playerCurrency += currency;
    }

    public void removeCurrency(int currency) {
        playerCurrency -= currency;
    }

    public void setCurrentRoom(Room room) {
        currentPlayerRoom = room;
    }

    public void getCurrentPlayerRoom() {
        System.out.println(currentPlayerRoom);
    }

    public void move(Room room) {
        System.out.println("You moved " + room);
        currentPlayerRoom = room;
    }

    public void PickUpItemsInCentrum(Room room, Prop prop) {
        if (alreadyExecuted == true) {
            System.out.println("There is no items in the room! ");
            room.removeRoomItem(prop);
            bag.add(prop);
        }
        alreadyExecuted = false;

    }

    public void PickUpItemsInNorth(Room room, Prop prop) {
        if (alreadyExecuted1 == true) {
            System.out.println("There is no items in the room! ");
            room.removeRoomItem(prop);
            bag.add(prop);
        }
        alreadyExecuted1 = false;

    }

    public void PickUpItemsInSouth(Room room, Prop prop) {
        if (alreadyExecuted2 == true) {
            System.out.println("There is no items in the room! ");
            room.removeRoomItem(prop);
            bag.add(prop);
        }
        alreadyExecuted2 = false;

    }

    public void PickUpItemsInEast(Room room, Prop prop) {
        if (alreadyExecuted3 == true) {
            System.out.println("There is no items in the room! ");
            room.removeRoomItem(prop);
            bag.add(prop);
        }
        alreadyExecuted3 = false;

    }

    public void removeItem(Prop prop) {
        bag.remove(prop);
    }

    public void showBag() {

        if (bag.size() == 0) {
            System.out.println("Your bag is empty! ");
        } else {
            System.out.println(bag.toString());
        }
    }

    public void drink() {
        if (this.playerDrunk >= 4) {
            playerDrunk++;
        } else {
            System.out.println("You are too drunk");
        }

    }
}
/*
    -til senere
    public Boolean doAction() {
        return true;

    }
 */
