package LemGame;

import java.util.*;

public class Game {

    Prop wallet = new Prop("Wallet", 25);
    private Room currentroom;

    public static void main(String[] args) {
        Game play = new Game();
        play.play();
        
    }

    public void createProps() {

    }

    public void createRoom() {
        Room centrum = new Room("Centrum", 0);
        centrum.addRoomItem(wallet);
        centrum.removeRoomItem(wallet);
        
    }

    public void play() {
        while (true) {
            
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your name! ");
            String insertName = input.nextLine();
            Player playerName = new Player(insertName);
            System.out.println(playerName.getPlayerName());
            System.out.println(playerName.getPlayerCurrency());
            playerName.addItem(wallet);
            playerName.showBag();
            
        }
    }
}
