package LemGame;

import java.util.*;

public class Game {

    Scanner input = new Scanner(System.in);
    Room centrum = new Room("Centrum", 0);
    Room north = new Room("North", 1);
    Room south = new Room("North", 2);
    Room east = new Room("North", 3);
    Room west = new Room("North", 4);
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop ciggarets = new Prop("ciggarets", 25);
    Player player1 = new Player("Kristian");
    String quit = input.nextLine();
    NPC fruMadsen = new NPC("Fru Madsen", "fru madsen kan godt lide unge mænd", centrum);
    NPC tuborgManden = new NPC("Tuborg Manden", "ham her kan godt lide bajer", centrum);
    NPC bartender = new NPC("Jimmy", "Han er bartender", centrum);

    boolean sameRoom = true;

    public static void main(String[] args) {

        Game play = new Game();
        play.play();

    }

    public void play() {
        initializeGame();
        commands();
        //TO DO: LAV ET WHILE LOOP DER SPILLER SPILLET:
        while (!quit.equalsIgnoreCase("quit")) {

            player1.setCurrentRoom(centrum);
            printHelp();
            break;

        }

    }

    public void initializeGame() {
        commands();
        centrum.setRoomExit(north);
        centrum.setRoomExit(east);
        centrum.setRoomExit(south);
        centrum.setRoomExit(west);
        centrum.addRoomItem(wallet);
        north.addRoomItem(beef);
        // TO DO INTIZIALIZE GAME FÆRDIGT

    }

    private void printHelp() {
        // LAV PRINT HELP FÆRDIGT
        System.out.println("You are now in centrum");
        System.out.println("Your command words are:");
        System.out.println("- help");
        System.out.println("- pickup");
        System.out.println("- dropItem");
        System.out.println("You can enter a location to go there. ");
        // SE CASE TO DO
    }

    public void commands() {

        while (sameRoom == true) {
            System.out.println("enter your command ");

            String command = input.nextLine();
// TO DO incorporer så hvis du skriver noget der ikke er en command.. print "What do you mean"
            switch (command) {
                case "help":
                    printHelp();
                    break;

                case "pickup":
                    player1.PickUp();
                    break;

                case "north":
                    caseNorth();
                    break;

                case "south":
                    caseSouth();
                    break;

                case "centrum":
                    caseCentrum();
                    break;

                case "west":
                    caseWest();
                    break;

                case "showCurrency":
                    player1.getPlayerCurrency();
                    break;
                    
                // to do: hvis exits for current room case "show exits":

            }

        }
    }

    private void caseNorth() {
        if (player1.getCurrentPlayerRoom() == north) {
            System.out.println("You are already in north");
        } else {
            player1.move(north);
        }
    }

    private void caseCentrum() {
        if (player1.getCurrentPlayerRoom() == centrum) {
            System.out.println("You are already in centrum");
        } else {
            player1.move(centrum);
            System.out.println("You moved to centrum");
        }
    }

    private void caseSouth() {
        if (player1.getCurrentPlayerRoom() == south) {
            System.out.println("You are already in south");
        } else {
            player1.move(south);
            System.out.println("You moved to south");

        }
    }

    private void caseEast() {
        if (player1.getCurrentPlayerRoom() == east) {
            System.out.println("You are already in east");
        } else {
            player1.move(east);
            System.out.println("You moved to east");

        }
    }

    private void caseWest() {
        if (player1.getCurrentPlayerRoom() == west) {
            System.out.println("You are already in west");
        } else {
            player1.move(west);
            System.out.println("You moved to west");

        }
    }

}
