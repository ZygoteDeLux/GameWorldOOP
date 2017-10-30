package LemGame;
// TO DO:
/*
fix hand in beefs så den ikke dispalyer 2, 1, 1
gør spillet pænere
Lav et GUI
Fix play agian
kommentarer
fix play agian
rapport
 */

import java.util.*;

public class Game {

    int drunkPenalty;
    long startTime;
    int beefcount = 0;
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    Room centrum = new Room("centrum", 0);
    Room north = new Room("north", 1);
    Room south = new Room("south", 2);
    Room east = new Room("east", 3);
    Room west = new Room("west", 4);
    Room fruMadsensHouse = new Room("fru madsens house", 5);
    Room bar = new Room("bar", 6);
    Room taxi = new Room("taxi ", 7);
    Room fishMarket = new Room("the fish market", 8);
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop ciggarets = new Prop("ciggarets", 25);
    Player player1 = new Player("Kristian");
    NPC tuborgMan = new NPC("Tuborg Manden", "ham her kan godt lide bajer", bar);

    public static void main(String[] args) {

        Game play = new Game();
        play.play();

    }

    public void play() { //ændringer:
        initializeGame();
        while (true) {
            commands();
            if (beefcount == 4) {
                System.out.println("You won the game, thanks for playing. Do you want to play agian? ");
                scoreBoard();
                System.exit(1);
            }
        }
    }

    public void initializeGame() {
        startTime = System.currentTimeMillis();
        System.out.println("Welcome to World Of Lem!");
        System.out.println("You wake up in the middle of a city. You see a city sign that says 'Centrum of Lem'. You lost your wallet and you want to go home. You spot a cab that might drive you home");
        System.out.println("Type 'help' to print your commands.");
        wallet.setPropDescription(" you can either keep the wallet for 25 coins or find the owner for a potential greater reward");
        beef.setPropDescription(" Give 4 of these to the cab driver to get home");
        ciggarets.setPropDescription(" someone might be intrested in these");
        player1.setCurrentRoom(centrum);
        centrum.setRoomExit(north);
        centrum.setRoomExit(east);
        centrum.setRoomExit(south);
        centrum.setRoomExit(west);
        centrum.setRoomExit(taxi);
        centrum.addRoomItem(wallet);
        west.setRoomExit(fruMadsensHouse);
        west.setRoomExit(centrum);
        west.setRoomDescription("West");
        north.setRoomExit(fishMarket);
        north.setRoomExit(centrum);
        north.setRoomDescription("North");
        east.setRoomExit(bar);
        east.setRoomExit(centrum);
        east.addRoomItem(ciggarets);
        east.setRoomDescription("East");
        south.setRoomExit(centrum);
        south.setRoomDescription("South ");
        fruMadsensHouse.setRoomExit(west);
        fruMadsensHouse.setRoomDescription("You walked over to fru madsens house. A beautiful women named Fru Madsen appears in the door asks you to cut her hegde and in return give you 25 coins, type 'cut hegde' to help her.");
        fishMarket.setRoomExit(north);
        fishMarket.setRoomDescription("You arrived at a fish market. Maybe you can buy some beefs for the cab driver here. ");
        bar.setRoomExit(east);
        bar.setRoomDescription("You walked into a bar. The bartender asks you to do the dishes and as a reward he will give 25 coins.");
        taxi.setRoomExit(centrum);
        taxi.setRoomDescription("You walked over to the taxi. Here you can hand in your beefs");
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
                caseMap();
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
            case "the fish market":
                caseFishMarket();
                break;
            case "cut hedge":
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
            case "keep":
                keep();
                break;
            default:
                System.out.println("Your command was invalid, try agian ");
        }

    }

    private void caseNorth() {
        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == fishMarket) {
            if (player1.getCurrentPlayerRoom() == north) {
                System.out.println("You are already in north");
            } else {
                move(north);
                System.out.println("You moved to north");
            }
        } else {
            System.out.println("You cant go there");
        }

    }

    private void caseCentrum() {
        if (player1.getCurrentPlayerRoom() == north || player1.getCurrentPlayerRoom() == south || player1.getCurrentPlayerRoom() == east || player1.getCurrentPlayerRoom() == west || player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == taxi) {
            if (player1.getCurrentPlayerRoom() == centrum) {
                System.out.println("You are already in centrum");
            } else {
                move(centrum);
                System.out.println("You moved to centrum.");
            }
        } else {
            System.out.println("You cant go there");
        }
    }

    private void caseSouth() {
        if (player1.getCurrentPlayerRoom() == centrum) {
            if (player1.getCurrentPlayerRoom() == south) {
                System.out.println("You are already in south");
            } else {
                move(south);
                System.out.println("You moved to south");
            }
        } else {
            System.out.println("You cant go there");
        }
    }

    private void caseEast() {
        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == bar) {
            if (player1.getCurrentPlayerRoom() == east) {
                System.out.println("You are already in east");
            } else {
                move(east);
                System.out.println("You moved to east");
            }
        } else {
            System.out.println("You cant go there");
        }

    }

    private void caseWest() {
        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == fruMadsensHouse) {
            if (player1.getCurrentPlayerRoom() == west) {
                System.out.println("You are already in west");
            } else {
                move(west);
                System.out.println("You moved to west");
            }
        } else {
            System.out.println("You cant go there");
        }

    }

    private void caseFruMadsensHouse() {
        if (player1.getCurrentPlayerRoom() == west) {
            move(fruMadsensHouse);
            if (fruMadsensHouse.getRoomBehavior() == 1) {
                System.out.println(fruMadsensHouse.getRoomDescription());
            } else {
                System.out.println("You walked over to frumadsens house");
            }
        } else {
            System.out.println("You cant go there right now");
        }

    }

    private void caseBar() {
        if (player1.getCurrentPlayerRoom() == east) {
            move(bar);
            if (bar.getRoomBehavior() == 1) {
                System.out.println(bar.getRoomDescription());
            } else {
                System.out.println("You walked in the the bar");
            }
        } else {
            System.out.println("You cant go there right now");
        }
    }

    private void caseFishMarket() {
        if (player1.getCurrentPlayerRoom() != north) {
            System.out.println("There is no fish market here");
        } else {
            move(fishMarket);
            System.out.println(fishMarket.getRoomDescription());
        }
    }

    private void caseTaxi() {
        if (player1.getCurrentPlayerRoom() != centrum) {
            System.out.println("There is no taxi");
        } else {
            move(taxi);
            System.out.println(taxi.getRoomDescription());
        }
    }

    private void buyBeef() {
        while (true) {
            if (player1.getCurrentPlayerRoom() == fishMarket) {
                if ((player1.getBag().size() > 10)) {
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
        int count = 0;
        int fifty = 50;
        int nothing = 0;
        int randoms = random.nextBoolean() ? fifty : nothing;
        if (player1.getCurrentPlayerRoom() == south) {
            if (player1.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                if (player1.getBag().contains(ciggarets)) {
                    System.out.println("The man accepts your ciggarets and in return he gives you 25 coins");
                    player1.removeItem(ciggarets);
                    player1.addCurrency(25);
                    count++;
                    player1.getCurrentPlayerRoom().setRoomBehavior(0);
                } else {
                    System.out.println("The man grumps and looks away.");
                }
            } else {
                System.out.println("You already gave the man ciggarets");
            }

        }

        if (player1.getCurrentPlayerRoom() == west) {
            if (player1.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                if (player1.getBag().contains(wallet)) {
                    if (randoms == 0) {
                        System.out.println("The man gladlys accepts the wallet but you get nothing in return. Just a smile to continue your adventure");
                        player1.addCurrency(randoms);
                        player1.removeItem(wallet);
                        player1.getCurrentPlayerRoom().setRoomBehavior(0);
                    } else if (randoms == 50) {
                        System.out.println("The man jumps of joy and as a reward for finding his wallet he gives you 50 coins.");
                        player1.addCurrency(50);
                        player1.getCurrentPlayerRoom().setRoomBehavior(0);
                    }

                } else {
                    System.out.println("You have nothing to hand in.");
                }
            } else {
                System.out.println("You already returned the wallet");
            }
        }

        if (player1.getCurrentPlayerRoom() == taxi) {
            if (player1.getBag().contains(beef)) {
                count = 0;
                for (int i = 0; i < player1.getBag().size(); i++) {
                    if (player1.getBag().contains(beef)) {
                        player1.getBag().remove(beef);
                        count++;
                        beefcount++;
                    }
                }

                System.out.println("You handed in  " + count + " beefs to the taxi driver");

            } else {
                System.out.println("You have no beefs to hand in");
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
        if (player1.getBag().contains(wallet)) {
            System.out.println("You kept the coins in the wallet and added 25 coins to your bag");
            player1.addCurrency(25);
            player1.getBag().remove(wallet);
        } else {
            System.out.println("You dont have anything to keep");
        }
    }

    private void caseMap() {
        System.out.println("You are in " + player1.getCurrentPlayerRoom());
        System.out.println("You can go: ");
        for (Room StuffToPrint : player1.getCurrentPlayerRoom().roomExits) {
            System.out.println(" " + StuffToPrint.getRoomName());
        }

        System.out.println("Tuborg dude is in " + tuborgMan.getNpcRoom());
    }

    private void move(Room room) {
        checkTime();
        player1.move(room);
        tuborgMan.npcMove();
        if (tuborgMan.getNpcRoom() == taxi) {
            tuborgMan.setNpcRoom(centrum);
        }
        if (tuborgMan.getNpcRoom() == fruMadsensHouse) {
            tuborgMan.setNpcRoom(east);
        }
        if (player1.getCurrentPlayerRoom() == tuborgMan.getNpcRoom()) {
            player1.drink();
            System.out.println("You met the turborg guy!");
        }
    }

    private void checkTime() {
        drunkPenalty += player1.getPlayerDrunk();
        if (startTime + 5 * 60 * 1000 < System.currentTimeMillis() + drunkPenalty * 1000) {
            lose();
        }
    }

    private void lose() {
        System.out.println("You lost the game");
        scoreBoard();
        System.exit(1);

    }

    private void scoreBoard() {
        if (beefcount == 4) {
            if (startTime + 1 * 60 * 1000 > System.currentTimeMillis()) {
                System.out.println("You got 10 points! ");
            } else if (startTime + 2 * 60 * 1000 > System.currentTimeMillis()) {
                System.out.println("You got 8 points! ");
            } else if (startTime + 3 * 60 * 1000 > System.currentTimeMillis()) {
                System.out.println("You got 6 points! ");
            } else if (startTime + 4 * 60 * 1000 > System.currentTimeMillis()) {
                System.out.println("You got 4 points! ");
            } else {
                System.out.println("You got 2 points! ");
            }
        } else {
            System.out.println("You got 0 points");
        }

    }
}
