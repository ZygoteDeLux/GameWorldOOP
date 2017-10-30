package LemGame;

import java.util.*;

public class Player {

    private String playerName;
    private int playerCurrency;
    private Room currentPlayerRoom;
    private int playerDrunk;
    
    //ÆNDRET
    private ArrayList<Prop> bag = new ArrayList();

    Player(String playerName) {
        this.playerName = playerName;
        this.playerCurrency = 0;
        this.playerDrunk = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Prop> getBag() {
        return bag;
    }

    public int getPlayerCurrency() {
        return playerCurrency;
    }

    public void addCurrency(int currency) {
        playerCurrency += currency;
    }

    public void addProp(Prop prop) {
        bag.add(prop);
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
        int count = 0;
//        BEMÆRK: HUSK GRINDEHVALSBØFFER OGSÅ FYLDER
// Ændret! Forsøg på et lave pickup metode så den printer en liste ud af items der er på jorden og man selv vælger hvad man kan samle op
        Scanner input = new Scanner(System.in);
        if (!currentPlayerRoom.roomItems.isEmpty()) {
            System.out.println("What do you want to pickup? Type 'done' to move on.");

            for (Prop StuffToPrint : currentPlayerRoom.roomItems) {
                System.out.println(count + " " + StuffToPrint.getPropName());
                count++;
            }
            String inputString;
            while (true) {
                if (!(inputString = input.nextLine()).equalsIgnoreCase("done")) {
                    try {
                        int next = Integer.parseInt(inputString);
                        bag.add(currentPlayerRoom.roomItems.get(next));
                        System.out.println("You added a " + currentPlayerRoom.roomItems.get(next).getPropName() + " to your bag" + currentPlayerRoom.roomItems.get(next).getPropDescription());
                        currentPlayerRoom.roomItems.remove(next);
                        count = 0;
                        for (Prop StuffToPrint : currentPlayerRoom.roomItems) {
                            System.out.println(count + " " + StuffToPrint.getPropName());
                            count++;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a number to pickup item");
                    }
                } else {
                    System.out.println("You no longer pick up items");
                    break;
                }
            }

        } else {
            System.out.println("There is no items in the room");
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
            for (Prop StuffToPrint : bag) {
                System.out.println(StuffToPrint.getPropName());
            }

        }
    }

    public void drink() {
        if (this.playerDrunk < 4) {
            playerDrunk++;
            System.out.println("You drunkometer is now at " + this.playerDrunk);
        } else {
            System.out.println("Your drunkometer is at " + this.playerDrunk + "you are too drunk");
            System.out.println("You are too drunk");
        }

    }

    public int getPlayerDrunk() {
        return playerDrunk;
    }

   

}
