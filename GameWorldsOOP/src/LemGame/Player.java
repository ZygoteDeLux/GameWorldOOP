package LemGame;

import java.util.*;

public class Player  {

    //instances variables that defines a player.
    private String playerName; //player name
    private int playerCurrency; // player currency
    private Room currentPlayerRoom; //players current room
    private int playerDrunk; // indicates how "drunk" the player. It's indicated with a int datatype.
    private ArrayList<Prop> bag = new ArrayList(); // Array list with a list of all tha the props the player has in his bag.

    Player(String playerName) { //Constructor that sets a start value for playername, playerCurrency and playerDrunk
        this.playerName = playerName; // 
        this.playerCurrency = 0;
        this.playerDrunk = 0;
    }

    public String getPlayerName() { //returns player name
        return playerName;
    }

    public ArrayList<Prop> getBag() { //returns the bag arraylist
        return bag;
    }

    public int getPlayerCurrency() { //return player currency
        return playerCurrency;
    }

    public void addCurrency(int currency) { // add currency 
        playerCurrency += currency;
    }

    public void addProp(Prop prop) { // add props to your bag
        bag.add(prop);
    }

    public int removeCurrency(int currency) { // remove currency
        return playerCurrency -= currency;
    }

    public void setCurrentRoom(Room room) { //set a room for the player
        currentPlayerRoom = room;
    }

    public Room getCurrentPlayerRoom() { //returns the current room
        return currentPlayerRoom;
    }

    public void move(Room room) { //move method that updates currentPlayerRoom
        currentPlayerRoom = room;
    }

    public void pickUp() {
        int count = 0;
        Scanner input = new Scanner(System.in); //creates a Scanner object with a variable input
        if (!currentPlayerRoom.roomItems.isEmpty()) { //checks if the players room has any items. the ! indicator reverses the isEmpty() method.
            System.out.println("What do you want to pickup? Type 'done' to move on.");

            for (Prop StuffToPrint : currentPlayerRoom.roomItems) { //for loop to iterate through items in room.
                System.out.println(count + " " + StuffToPrint.getPropName()); //prints items
                count++; //increment count variable with 1.
            }
            String inputString; //variable of String type
            while (true) {
                if (!(inputString = input.nextLine()).equalsIgnoreCase("done")) { // exit loop if input = "done" (ignore case)
                    try { //try the following
                        try{ // try the following
                        int next = Integer.parseInt(inputString); // Parse input to integer
                        bag.add(currentPlayerRoom.roomItems.get(next)); // refer to the index in the arraylist roomItems. 
                        System.out.println("You added a " + currentPlayerRoom.roomItems.get(next).getPropName() + " to your bag" + currentPlayerRoom.roomItems.get(next).getPropDescription());
                        currentPlayerRoom.roomItems.remove(next); //remove item from room.
                        count = 0; //reset count variable
                        for (Prop StuffToPrint : currentPlayerRoom.roomItems) { //for loop to iterate through items in room
                            System.out.println(count + " " + StuffToPrint.getPropName()); //print items
                            count++; //increment count variable with 1.
                        }
                    }catch (IndexOutOfBoundsException e){ //if the program gets IndexOutOfBoundsException (If the user enters a number that canøt be referenced in the array list)
                            System.out.println("Enter a valid number"); //print
                    }
                    }catch (NumberFormatException e) { // if the program gets NumberFormatException (if the user inputs something thats not a number)
                        System.out.println("Enter a number to pickup item"); //print
                    }
                } else {
                    System.out.println("You no longer pick up items"); //if user inputs "done"
                    break;  //break while loop.
                }
            }

        } else {
            System.out.println("There is no items in the room"); //if the room.items is empty. 
        }

    }

    public void removeItem(Prop prop) { //remove item from bag
        bag.remove(prop);
    }

    public void showBag() {
        if (bag.size() == 0) { 
            System.out.println("Your bag is empty! "); //prints if there is nothing in your bag
        } else {
            Map<String, Integer>  print = new HashMap<>();
            for (Prop StuffToPrint : bag) { // iterate through bag
                if(print.containsKey(StuffToPrint.getPropName())){
                    print.put(StuffToPrint.getPropName(), print.get(StuffToPrint.getPropName()) + 1);
                    
                }
                else 
                    print.put(StuffToPrint.getPropName(), 1);
            }
            for(String propName : print.keySet()){
                System.out.println(print.get(propName)+ " " + propName+"(s)");
            }
        }
    }

    public void drink() {
        if (this.playerDrunk < 4) { //checks if you already drank 4 times
            playerDrunk++; //increment playerDrunk by 1
            System.out.println("You drunkometer is now at " + this.playerDrunk); // prints how drunk you are
        } else {
            System.out.println("Your drunkometer is at " + this.playerDrunk + "you are too drunk"); //print if you drank 4 times already
            System.out.println("You are too drunk");
        }

    }


    public int getPlayerDrunk() { //returns integer on how drunk you are.
        return playerDrunk;
    }

  
   

}
