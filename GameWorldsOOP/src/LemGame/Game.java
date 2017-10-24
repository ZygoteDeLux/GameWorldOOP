package LemGame;

import java.util.*;

public class Game {

    Random random = new Random();
    Scanner input = new Scanner(System.in);
    Room centrum = new Room("Centrum", 0);
    Room north = new Room("North", 1);
    Room south = new Room("South", 2);
    Room east = new Room("East", 3);
    Room west = new Room("West", 4);
    Room fruMadsensHouse = new Room("Frumadsens house", 5);
    Room taxi = new Room("The taxi ", 6);
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
    int playerCountFruMadsensHouse;

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
        wallet.setPropDescription("You picked up a wallet! It contains 25 coins. You can either keep the wallet or maybe find the owner for a greater reward");
        beef.setPropDescription("You bought a beef");
        ciggarets.setPropDescription("You found some ciggarets! Someone might be intresrested in these.");
        player1.setCurrentRoom(centrum);
        centrum.setRoomExit(north);
        centrum.setRoomExit(east);
        centrum.setRoomExit(south);
        centrum.setRoomExit(west);
        centrum.setRoomExit(taxi);
        centrum.addRoomItem(wallet);
        west.setRoomExit(fruMadsensHouse);
        west.setRoomExit(centrum);
        north.setRoomExit(centrum);
        north.addRoomItem(beef);
        east.setRoomExit(centrum);
        south.setRoomExit(centrum);
        fruMadsensHouse.setRoomBehavior(1);

//         TO DO INTIZIALIZE GAME FÆRDIGT
    }

    private void printHelp() {
        // LAV PRINT HELP FÆRDIGT
        System.out.println("Your command words are:");
        System.out.println("- help");
        System.out.println("- pickup");
        System.out.println("- show currency");
        System.out.println("- quit (quits the game)");
        System.out.println("- map");
        System.out.println("- bag");
        System.out.println("- hand in");
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

            case "show currency":
                System.out.println("You have " + player1.getPlayerCurrency() + " coins in your bag");
                break;
            case "map":
                System.out.println("You are in " + player1.getCurrentPlayerRoom());
                System.out.println("You can go " + player1.getCurrentPlayerRoom().getRoomExit());
                break;

            case "bag":
                player1.showBag();
                break;

            case "fru madsens house":
                caseFruMadsensHouse();
                break;
            case "cut hegde":
                cutHegde();
                break;

            case "quit":
                System.out.println("Thanks for playing, bye!");
                System.exit(1);
            case "hand in":
                handIn();
                break;
            default:
                System.out.println("Your command was invalid, try agian ");
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

    private void caseFruMadsensHouse() {
        if (player1.getCurrentPlayerRoom() != west) {
            System.out.println("There is no house ");
        } else {
            player1.move(fruMadsensHouse);
            System.out.println("You moved to Fru Madsens House ");
            System.out.println("A beautiful women named Fru Madsen appears in the door asks you to cut her hegde and in return give you 25 coins, type 'cut hegde' to help her.");
        }

    }

//    måske erstat denne metode med en player metode doAciton() hvor playeren gør en specifik action alt efter hvor han er
    private void cutHegde() {
        if (fruMadsensHouse.getRoomBehavior() == 1) {
            if (player1.getCurrentPlayerRoom() == fruMadsensHouse) {
                player1.addCurrency(25);
                System.out.println("You cut Fru Madsens Hegde and was rewarded 25 coins ");
                System.out.println("fru madsens kisses you on the cheek as a thanks");
                fruMadsensHouse.setRoomBehavior(0);
            } else {
                System.out.println("There is no hegde to cut! ");
            }
        } else {
            System.out.println("You already cut the hegde! ");
        }
    }

    //ændret
    private void handIn() {
        int count = 0;
        int fifty = 50;
        int nothing = 0;
        int randoms = random.nextBoolean() ? fifty : nothing;
        if (player1.getCurrentPlayerRoom() == south) {
            if (player1.getBag().containsKey(ciggarets)) {
                System.out.println("You handed ciggarets in 25 coins");
                player1.removeItem(ciggarets);
                player1.addCurrency(25);
            }
        }
        System.out.println(" you have nothing to hand in");
        if (player1.getCurrentPlayerRoom() == east) {
            if (player1.getPlayerCurrency() < 25) {
                System.out.println("You handed in 25 coins and got a beef!");
                player1.removeCurrency(25);
                player1.addProp(beef);
            } else {
                System.out.println("You dont have enough money");
            }

        }
        if (player1.getCurrentPlayerRoom() == west) {
            if (player1.getBag().containsKey(wallet)) {
                System.out.println("You handed in the wallet and added " + randoms + " coins to your bag");
                player1.addCurrency(randoms);
                player1.removeItem(wallet);
            } else {
                System.out.println("You have nothing to hand in");
            }
        }
        if (player1.getCurrentPlayerRoom() == taxi) {
            if (player1.getBag().containsKey(beef)) {
                for (int i = 0; i < player1.getBag().size(); i++) {
                    player1.getBag().remove(beef);
                    count++;
                }
                System.out.println("You handed in  " + count + " beefs to the taxi driver and payed " + player1.removeCurrency(count * 25) + " coins");
                
            }
        }
    }
}
