package LemGame;

import java.util.*;

public class Game {
    int beefcount = 0;
    
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    Room centrum = new Room("Centrum", 0);
    Room north = new Room("North", 1);
    Room south = new Room("South", 2);
    Room east = new Room("East", 3);
    Room west = new Room("West", 4);
    Room fruMadsensHouse = new Room("Frumadsens house", 5);
    Room bar = new Room("The bar", 6);
    Room taxi = new Room("taxi ", 7);
    Room fishMarket = new Room("the Fish Market", 8);
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop ciggarets = new Prop("ciggarets", 25);
    Player player1 = new Player("Kristian");
    String quit = input.nextLine();
    NPC tuborgMan = new NPC("Tuborg Manden", "ham her kan godt lide bajer", centrum);

    public static void main(String[] args) {

        Game play = new Game();
        play.play();

    }

    public void play() { //ændringer:
        this.initializeGame();
        while (true) {
            this.commands();
            if(beefcount == 4){
                System.out.println("You won the game, thanks for playing. Do you want to play agian? ");
                System.exit(1);
            }
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
        north.setRoomExit(fishMarket);
        east.setRoomExit(bar);
        east.setRoomExit(centrum);
        south.setRoomExit(centrum);
        east.addRoomItem(ciggarets);
        fruMadsensHouse.setRoomBehavior(1);
        player1.addCurrency(100);

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
            case "east":
                caseEast();
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
            case "bar":
                caseBar();
                break;
            case "do dishes":
                doDishes();
                break;
            case "bag":
                player1.showBag();
                break;
            case "fru madsens house":
                caseFruMadsensHouse();
                break;
            case "taxi":
                caseTaxi();
                break;
            case "fish market":
                caseFishMarket();
                break;
            case "cut hegde":
                cutHegde();
                break;
            case "buy beef":
                buyBeef();
                break;
            case "quit":
                System.out.println("Thanks for playing, bye!");
                System.exit(1);
            case "hand in":
                handIn();
                break;
            case "Do Dishes":
                doDishes();
                break;
            case "keep":
                keep();
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

    private void caseBar() {
        if (player1.getCurrentPlayerRoom() != east) {
            System.out.println("there is no bar ");
        } else {
            player1.move(bar);
            System.out.println("You moved to a bar! The owner asks if you want to help do the dishes and earn 25 coins.");

        }
    }

    private void caseFishMarket() {
        if (player1.getCurrentPlayerRoom() != north) {
            System.out.println("There is no fish market here");
        } else {
            player1.move(fishMarket);
            System.out.println("You moved to the fish market! You might be able to buy some beefs here.");
        }
    }
    private void caseTaxi(){
        if(player1.getCurrentPlayerRoom() != centrum)
            System.out.println("There is no taxi");
        else {
            player1.move(taxi);
            System.out.println("You moved to the taxi");
        }
    }

    private void buyBeef() {
        while (true) {
            if (player1.getCurrentPlayerRoom() == fishMarket) {
                if (player1.getBag().size() >= 2) {
                    System.out.println("Your dont have space");
                    break;
                } else if (player1.getPlayerCurrency() < 25) {
                    System.out.println("You dont have enough money");
                    break;
                } else {
                    player1.addProp(beef);
                }
                System.out.println("You brought a beef for 25 coins");
                player1.removeCurrency(25);
                break;

            } else {
                System.out.println("You can't buy beefs here");
                break;
            }
        }
    }

    private void cutHegde() {
        if (player1.getCurrentPlayerRoom() == fruMadsensHouse) {
            if (fruMadsensHouse.getRoomBehavior() == 1) {
                player1.addCurrency(25);
                System.out.println("You cut Fru Madsens Hegde and was rewarded 25 coins ");
                System.out.println("fru madsens kisses you on the cheek as a thanks");
                fruMadsensHouse.setRoomBehavior(0);
            } else {
                System.out.println("You already cut the hegde! ");

            }
        } else {
            System.out.println("There is no hegde to cut! ");

        }
    }

    private void handIn() {
        int beefcount = 0;
        int count = 0;
        int fifty = 50;
        int nothing = 0;
        int randoms = random.nextBoolean() ? fifty : nothing;
        if (player1.getCurrentPlayerRoom() == south) {
            if (player1.getBag().containsKey(ciggarets)) {
                System.out.println("You handed ciggarets in for 25 coins");
                player1.removeItem(ciggarets);
                player1.addCurrency(25);
            } else {
                System.out.println(" you have nothing to hand in");
            }
        }
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
                //fix 
                for (int i = 0; i < player1.getBag().size(); i++) {
                    player1.getBag().remove(beef);
                    count++;
                    beefcount++;
                }

                //fix
                System.out.println("You handed in  " + count + " beefs to the taxi driver");
        
            }
        }
    }

    private void doDishes() {

        if (player1.getCurrentPlayerRoom() == bar) {
            if (bar.getRoomBehavior() == 1) {
                System.out.println("You cleaned the dishes and as a reward you added 25 coins to your bag");
                player1.addCurrency(25);
                bar.setRoomBehavior(0);
            } else {
                System.out.println("You already cleaned the dishes");

            }
        } else {
            System.out.println("There is no dishes to do ");

        }
    }

    private void keep() {
        if (player1.getBag().containsKey(wallet)) {
            System.out.println("You kept the coins in the wallet and added 25 coins to your bag");
            player1.addCurrency(25);
            player1.getBag().remove(wallet);
        } else {
            System.out.println("You dont have anything to keep");
        }
    }

}
