package LemGame;

import java.util.*;

public class Player {

    private String playerName;
    private int playerCurrency;
    private Room currentPlayerRoom;
    private int playerDrunk;
    //ÆNDRET
    private HashMap<Prop, String> bag = new HashMap();

    Player(String playerName) {
        this.playerName = playerName;
        this.playerCurrency = 0;
        this.playerDrunk = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public HashMap<Prop, String> getBag() {
        return bag;
    }

    public int getPlayerCurrency() {
        return playerCurrency;
    }

    public void addCurrency(int currency) {
        playerCurrency += currency;
    }
    public void addProp(Prop prop){
        bag.put(prop, prop.getPropDescription());
    }

    public int removeCurrency(int currency) {
        return playerCurrency -= currency;
    }

    public void setCurrentRoom(Room room) {
        currentPlayerRoom = room;
    }

    public Room getCurrentPlayerRoom() {
        return currentPlayerRoom;
    }

    public void move(Room room) {
        currentPlayerRoom = room;
    }

    public void pickUp() {
//        BEMÆRK: HUSK GRINDEHVALSBØFFER OGSÅ FYLDER
// Ændret!
        if (bag.size() < 2) {
            if (currentPlayerRoom.roomItems.isEmpty() == true) {
                System.out.println("There is no items in the room ");
            } else {
                bag.putAll(currentPlayerRoom.roomItems);
            }
            System.out.println(currentPlayerRoom.getRoomItems());
            for (int i = 0; i < currentPlayerRoom.roomItems.size(); i++) {
                currentPlayerRoom.roomItems.remove(i);

            }
        } else {
            System.out.println("Your bag is full ");
        }

    }

    public void removeItem(Prop prop) {
        bag.remove(prop);
    }

    public void showBag() {

        if (bag.size() == 0) {
            System.out.println("Your bag is empty! ");
        } else {
            //fix så bag KUN printer value
            for (Prop StuffToPrint : bag.keySet()) {
                System.out.println(StuffToPrint.getPropName());
            }

        }
    }

    public void drink() {
        if (this.playerDrunk >= 4) {
            playerDrunk++;
        } else {
            System.out.println("You are too drunk");
        }

    }

    public void cutHegde() {
        System.out.println("You cut Fru Madsens hegde. You earned 25 coints! ");
        playerCurrency += 25;
    }

}
