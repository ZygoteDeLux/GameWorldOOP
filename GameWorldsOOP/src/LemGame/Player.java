package LemGame;

import java.util.*;

public class Player {

    //player skal kende rum.
    private String playerName;
    private int playerCurrency;
    private Room currentPlayerRoom;
    private int playerDrunk;
    private ArrayList<Prop> bag = new ArrayList();

    Player(String playerName) {
        this.playerName = playerName;
        this.playerCurrency = 0;
        this.playerDrunk = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void getPlayerCurrency() {
        System.out.println("You have " + playerCurrency + " monetos now");
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

    public Room getCurrentPlayerRoom() {
        return currentPlayerRoom;
    }

    public void move(Room room) {
        System.out.println("You moved " + room);
        currentPlayerRoom = room;
    }

    public void PickUp() {
        if (currentPlayerRoom.roomItems.isEmpty() == true) {
            System.out.println("There is no items in the room ");
        } else {
            bag.addAll(currentPlayerRoom.roomItems);
        }
        System.out.println("You added " + currentPlayerRoom.roomItems + " to your bag ");
        for (int i = 0; i < currentPlayerRoom.roomItems.size(); i++) {
            currentPlayerRoom.roomItems.remove(i);

        }
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
