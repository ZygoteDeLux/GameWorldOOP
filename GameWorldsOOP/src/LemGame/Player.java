package LemGame;

import java.util.*;

public class Player {

    private String playerName;
    private int playerCurrency;
    private Room currentPlayerRoom;
    private int playerDrunk;
    private ArrayList<Prop> bag = new ArrayList();

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

    public void move(Room room) {
        currentPlayerRoom = room;
    }

    public void addItem(Prop prop) {
        bag.add(prop);
    }

    public void removeItem(Prop prop) {
        bag.remove(prop);
    }

    public void showBag() {
        if(bag.size() == 0){
            System.out.println("Your bag is empty! ");
        } else{
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
    /*
    -til senere
    public Boolean doAction() {
        return true;

    }
     */
}
