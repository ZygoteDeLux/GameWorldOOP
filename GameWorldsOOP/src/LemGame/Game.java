package LemGame;

import java.util.*;

public class Game {

    Scanner input = new Scanner(System.in);
    Room centrum = new Room("Centrum", 0);
    Room north = new Room("North", 1);
    Room south = new Room("North", 2);
    Room east = new Room("North", 3);
    Room west = new Room("North", 4);
//    Room fruMadsensHouse = new Room("Frumadsens house", 5);
//    Room taxi = new Room("The taxi ", 6);
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop ciggarets = new Prop("ciggarets", 25);
    Player player1 = new Player("Kristian");
    String quit = input.nextLine();
    //Behøver vi overhovedet en NPC class? Man kan bare calle metoderne på selv rummet -> se frumandsensHus
    NPC fruMadsen = new NPC("Fru Madsen", "fru madsen kan godt lide unge mænd", centrum);
    NPC tuborgMan = new NPC("Tuborg Manden", "ham her kan godt lide bajer", centrum);
    NPC bartender = new NPC("Jimmy", "Han er bartender", centrum);
    // NPC cabDriver = new NPC("NAME", "Han er taximand", centrum);

    public static void main(String[] args) {

        Game play = new Game();
        play.play();

    }

    public void play() { //ændringer:
        // ændringer: fikset så den kun initizialiser game 1 gang
        this.initializeGame();
        while (true) {
            this.commands();

        }
    }

    public void initializeGame() {
        System.out.println("Welcome to World Of Lem!");
        System.out.println("He");
        System.out.println("You wake up after a night out, you don't know where you are and you lost your wallet. You spot a cab that might drive you home");
        System.out.println("Type 'help' to print your commands.");
        player1.setCurrentRoom(centrum);
        centrum.setRoomExit(north);
        centrum.setRoomExit(east);
        centrum.setRoomExit(south);
        centrum.setRoomExit(west);
        centrum.addRoomItem(wallet);
//        west.setRoomExit(fruMadsensHouse);
//        north.setRoomExit(centrum);
        north.addRoomItem(beef);
//        east.setRoomExit(centrum);
//        west.setRoomExit(centrum);
//        south.setRoomExit(centrum);
//        fruMadsensHouse.setRoomBehavior(1);
        // TO DO INTIZIALIZE GAME FÆRDIGT

    }

    private void printHelp() {
        // LAV PRINT HELP FÆRDIGT
        System.out.println("Your command words are:");
        System.out.println("- help");
        System.out.println("- pickup");
//        System.out.println("- showCurrency");
//      System.out.println("- quit (quits the game)");
//      System.out.println("- map");
//      System.out.println("- bag");    
    }

    public void commands() {
        String command = input.nextLine();

        switch (command) {
            case "help":
                printHelp();
                break;

            case "pickup":
                player1.pickUp();
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

//            case "showCurrency":
//                System.out.println("You have " + player1.getPlayerCurrency() + " coins in your bag");
//                break;
// FIX MAP
//                case "map":
//                    System.out.println("You are in " + player1.getCurrentPlayerRoom());
//                    System.out.println("You can go "+player1.getCurrentPlayerRoom().getRoomExit());
//                    break;
//                    
//                case "bag":
//                    player1.showBag();
//                    
//                default: 
////                    System.out.println("Your command was invalid, try agian ");
//            case "fruMadsensHouse":
//                caseFruMadsensHouse();
//                break;
//            case "CutHegde":
//                cutHegde();
//                break;
        }

    }

    private void caseNorth() {
        if (player1.getCurrentPlayerRoom() == north) {
            System.out.println("You are already in north");
        } else {
            player1.move(north);
            System.out.println("You moved to north");

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

//    private void caseFruMadsensHouse() {
//        if (player1.getCurrentPlayerRoom() != west) {
//            System.out.println("There is no house ");
//        } else {
//            player1.move(fruMadsensHouse);
//            System.out.println("You moved to Fru Madsens House ");
//
//        }
//    }

//    måske erstat denne metode med en player metode doAciton() hvor playeren gør en specifik action alt efter hvor han er
//    private void cutHegde() {
//        if (fruMadsensHouse.getRoomBehavior() == 1) {
//            if (player1.getCurrentPlayerRoom() == fruMadsensHouse) {
//                player1.addCurrency(25);
//                System.out.println("You cut Fru Madsens Hegde and was rewarded 25 coins ");
//                fruMadsensHouse.setRoomBehavior(0);
//            } else {
//                System.out.println("There is no hegde to cut! ");
//            }
//        } else {
//            System.out.println("You already cut the hegde! ");
//        }
//    }
}
