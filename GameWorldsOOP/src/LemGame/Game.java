package LemGame;

import java.util.*;

public class Game {

    Room centrum = new Room("Centrum", 0);
    Room north = new Room("North", 1);
    Room south = new Room("North", 2);
    Room east = new Room("North", 3);
    Room west = new Room("North", 4);
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop ciggarets = new Prop("ciggarets", 25);

    public static void main(String[] args) {

        Game play = new Game();
        play.initializeGame();
        play.play();

    }

    public void play() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Playername: ");
            String name1 = input.nextLine();
            Player player1 = new Player(name1);
            player1.setCurrentRoom(centrum);
            System.out.println("You are now in centrum. Try to pickup items ");
            System.out.println("There is " + centrum.getRoomItems() + " in centrum! HYPE ");
            System.out.println("There is " + north.getRoomItems() + " in north! HYPE ");
            player1.PickUpItemsInCentrum(centrum, wallet);
            player1.PickUpItemsInNorth(north, beef);
            centrum.removeRoomItem(wallet);
            north.removeRoomItem(beef);
            System.out.println("There is " + centrum.getRoomItems() + " in centrum! HYPE ");
            System.out.println("There is " + north.getRoomItems() + " in north HYPE ");
            break;

        }
    }

    public void initializeGame() {

        centrum.setRoomExit(north);
        centrum.setRoomExit(east);
        centrum.setRoomExit(south);
        centrum.setRoomExit(west);

        centrum.addRoomItem(wallet);
        north.addRoomItem(beef);

    }
}
