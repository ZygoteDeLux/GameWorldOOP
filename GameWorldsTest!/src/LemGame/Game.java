//package LemGame;
//// TO DO:
///*
//fix hand in beefs så den ikke dispalyer 2, 1, 1
//gør spillet pænere
//Lav et GUI
//Fix play agian
//kommentarer
//fix play agian
//rapport
// */
//
//import java.util.*;
//
//public class Game {
//
//
//    public static void main(String[] args) {
//
//        Game play = new Game();
//        play.play();
//
//    }
//
//    public void play() { //ændringer:
//        initializeGame();
//        while (true) {
//            commands();
//            if (beefcount >= 4) {
//                System.out.println("The taxi driver takes you home! You won! thanks for playing. Do you want to play agian?");
//                scoreBoard();
//                System.exit(1);
//            }
//        }
//    }
//
//    public void initializeGame() {
//        
////         TO DO INTIZIALIZE GAME FÆRDIGT
//    }
//
//    private void printHelp() {
//        // LAV PRINT HELP FÆRDIGT
//        System.out.println("Your command words are:");
//        System.out.println("- help");
//        System.out.println("- pickup");
//        System.out.println("- show currency");
//        System.out.println("- quit (quits the game)");
//        System.out.println("- map");
//        System.out.println("- bag");
//        System.out.println("- hand in");
//    }
//
//    public void commands() {
//        String command = input.nextLine();
//
//        switch (command) {
//            case "help":
//                printHelp();
//                break;
//            case "pickup":
//                player1.pickUp();
//                break;
//            case "north":
//                caseNorth();
//                break;
//            case "east":
//                caseEast();
//                break;
//            case "south":
//                caseSouth();
//                break;
//            case "centrum":
//                caseCentrum();
//                break;
//            case "west":
//                caseWest();
//                break;
//            case "show currency":
//                System.out.println("You have " + player1.getPlayerCurrency() + " coins in your bag");
//                break;
//            case "map":
//                caseMap();
//                break;
//            case "bar":
//                caseBar();
//                break;
//            case "do dishes":
//                doDishes();
//                break;
//            case "bag":
//                player1.showBag();
//                break;
//            case "fru madsens house":
//                caseFruMadsensHouse();
//                break;
//            case "taxi":
//                caseTaxi();
//                break;
//            case "the fish market":
//                caseFishMarket();
//                break;
//            case "cut hedge":
//                cutHegde();
//                break;
//            case "talk":
//                talk();
//                break;
//            case "buy beef":
//                buyBeef();
//                break;
//            case "quit":
//                System.out.println("Thanks for playing, bye!");
//                System.exit(1);
//            case "hand in":
//                handIn();
//                break;
//            case "keep":
//                keep();
//                break;
//            case "consume":
//                consume();
//                break;
//            default:
//                System.out.println("Your command was invalid, try agian ");
//        }
//
//    }
//
//    private void caseNorth() {
//        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == fishMarket) {
//            if (player1.getCurrentPlayerRoom() == north) {
//                System.out.println("You are already in north");
//            } else {
//                move(north);
//                System.out.println("You moved to the Northern part of Lem.");
//            }
//        } else {
//            System.out.println("You cant go there");
//        }
//
//    }
//
//    private void caseCentrum() {
//        if (player1.getCurrentPlayerRoom() == north || player1.getCurrentPlayerRoom() == south || player1.getCurrentPlayerRoom() == east || player1.getCurrentPlayerRoom() == west || player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == taxi) {
//            if (player1.getCurrentPlayerRoom() == centrum) {
//                System.out.println("You are already in centrum");
//            } else {
//                move(centrum);
//                System.out.println("You moved to centrum of Lem.");
//            }
//        } else {
//            System.out.println("You cant go there");
//        }
//    }
//
//    private void caseSouth() {
//        if (player1.getCurrentPlayerRoom() == centrum) {
//            if (player1.getCurrentPlayerRoom() == south) {
//                System.out.println("You are already in the southern part of Lem");
//            } else {
//                move(south);
//                System.out.println("You moved to the southern part of Lem!");
//            }
//        } else {
//            System.out.println("You cant go there");
//        }
//    }
//
//    private void caseEast() {
//        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == bar) {
//            if (player1.getCurrentPlayerRoom() == east) {
//                System.out.println("You are already in east");
//            } else {
//                move(east);
//                System.out.println("You moved to the eastern part of Lem!");
//            }
//        } else {
//            System.out.println("You cant go there");
//        }
//
//    }
//
//    private void caseWest() {
//        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == fruMadsensHouse) {
//            if (player1.getCurrentPlayerRoom() == west) {
//                System.out.println("You are already in the western part of Lem");
//            } else {
//                move(west);
//                System.out.println("You moved to the western part of Lem!");
//            }
//        } else {
//            System.out.println("You cant go there");
//        }
//    }
//
//    private void caseFruMadsensHouse() {
//        if (player1.getCurrentPlayerRoom() == west) {
//            move(fruMadsensHouse);
//            System.out.println("You walked over to frumadsens house");
//        } else {
//            System.out.println("You cant go there right now");
//        }
//
//    }
//
//    private void caseBar() {
//        if (player1.getCurrentPlayerRoom() == east) {
//            move(bar);
//            System.out.println("You walked in the the bar");
//        } else {
//            System.out.println("You cant go there right now");
//        }
//    }
//
//    private void caseFishMarket() {
//        if (player1.getCurrentPlayerRoom() != north) {
//            System.out.println("There is no fish market here");
//        } else {
//            if (player1.getBag().contains(key)) {
//                System.out.println("You have the key. Welcome to the fish market");
//                move(fishMarket);
//                System.out.println(fishMarket.getRoomDescription());
//            } else {
//                System.out.println("Looks you need a key to get in here.");
//            }
//        }
//    }
//
//    private void caseTaxi() {
//        if (player1.getCurrentPlayerRoom() != centrum) {
//            System.out.println("There is no taxi");
//        } else {
//            move(taxi);
//            System.out.println("You walked over to the taxi!");
//        }
//    }
//
//    private void buyBeef() {
//
//        while (true) {
//            if (player1.getCurrentPlayerRoom() == fishMarket) {
//            }
//            if (player1.getPlayerCurrency() < 25) {
//                System.out.println("You don't have enough money to buy a beef");
//                break;
//            } else {
//                player1.addProp(beef);
//                System.out.println("You brought a beef for 25 coins" + beef.getPropDescription());
//                player1.removeCurrency(25);
//                break;
//            }
//        }
//    }
//
//    
//
//    private void cutHegde() {
//        if (player1.getCurrentPlayerRoom() == fruMadsensHouse) {
//            if (fruMadsensHouse.getRoomBehavior() == 1) {
//                player1.addCurrency(50);
//                System.out.println("You cut Fru Madsens Hegde and was rewarded 50 coins ");
//                System.out.println("fru madsens kisses you on the cheek as a thanks");
//                fruMadsensHouse.setRoomBehavior(0);
//            } else {
//                System.out.println("You already cut the hegde! ");
//
//            }
//        } else {
//            System.out.println("There is no hegde to cut! ");
//
//        }
//    }
//
//    private void handIn() {
//        int count = 0;
//        int fifty = 50;
//        int nothing = 0;
//        int randoms = random.nextBoolean() ? fifty : nothing;
//        if (player1.getCurrentPlayerRoom() == south) {
//            if (player1.getCurrentPlayerRoom().getRoomBehavior() == 1) {
//                if (player1.getBag().contains(ciggarets)) {
//                    System.out.println("The man accepts your ciggarets and in return he gives you 25 coins");
//                    player1.removeItem(ciggarets);
//                    player1.addCurrency(25);
//                    player1.getCurrentPlayerRoom().setRoomBehavior(0);
//                } else {
//                    System.out.println("I have no ciggarets for you right now fam");
//                }
//
//            }
//        }
//        if (player1.getCurrentPlayerRoom() == west) {
//            if (player1.getCurrentPlayerRoom().getRoomBehavior() == 1) {
//                if (player1.getBag().contains(wallet)) {
//                    if (randoms == 0) {
//                        System.out.println("The man gladlys accepts the wallet but you get nothing in return. Just a smile to continue your adventure");
//                        player1.addCurrency(randoms);
//                        player1.removeItem(wallet);
//                        player1.getCurrentPlayerRoom().setRoomBehavior(0);
//                    } else if (randoms == 50) {
//                        System.out.println("The man jumps of joy and as a reward for finding his wallet he gives you 50 coins.");
//                        player1.addCurrency(50);
//                        player1.removeItem(wallet);
//                        player1.getCurrentPlayerRoom().setRoomBehavior(0);
//                    }
//
//                } else {
//                    System.out.println("You have nothing to hand in.");
//                }
//            } else {
//                System.out.println("You already returned the wallet");
//            }
//        }
//
//        if (player1.getCurrentPlayerRoom() == taxi) {
//            if (player1.getBag().contains(beef)) {
//                count = 0;
//                for (int i = player1.getBag().size(); i > 0; i--) {
//                    if (player1.getBag().contains(beef)) {
//                        player1.getBag().remove(beef);
//                        count++;
//                        beefcount++;
//                    }
//                }
//
//                System.out.println("You handed in " + count + " beefs to the taxi driver");
//
//            } else {
//                System.out.println("You have no beefs to hand in");
//            }
//        }
//
//        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == north || player1.getCurrentPlayerRoom() == fishMarket || player1.getCurrentPlayerRoom() == bar || player1.getCurrentPlayerRoom() == fruMadsensHouse || player1.getCurrentPlayerRoom() == east) {
//            System.out.println("you have nothing to hand in right now");
//
//        }
//    }
//
//    private void doDishes() {
//        if (player1.getCurrentPlayerRoom() == bar) {
//            if (bar.getRoomBehavior() == 1) {
//                System.out.println("You cleaned the dishes and as a reward you added 25 coins to your bag");
//                player1.addCurrency(25);
//                bar.setRoomBehavior(0);
//            } else {
//                System.out.println("You already cleaned the dishes");
//
//            }
//        } else {
//            System.out.println("There is no dishes to do ");
//
//        }
//    }
//
//    private void keep() {
//        if (player1.getBag().contains(wallet)) {
//            System.out.println("You kept the coins in the wallet and added 25 coins to your bag");
//            player1.addCurrency(25);
//            player1.getBag().remove(wallet);
//            walletTracker = 1;
//        } else {
//            System.out.println("You dont have anything to keep");
//        }
//    }
//
//    private void caseMap() {
//       
//    }
//
//    private void move(Room room) {
//        checkTime();
//        player1.move(room);
//        tuborgMan.npcMove();
//        if (tuborgMan.getNpcRoom() == taxi) {
//            tuborgMan.setNpcRoom(centrum);
//        }
//        if (tuborgMan.getNpcRoom() == fruMadsensHouse) {
//            tuborgMan.setNpcRoom(east);
//        }
//        if (player1.getCurrentPlayerRoom() == tuborgMan.getNpcRoom()) {
//            player1.drink();
//            System.out.println("You met the turborg guy!");
//        }
//    }
//
//    public void consume() {
//        if (player1.getBag().contains(timePotion)) {
//            player1.setStartTime(player1.getStartTime() + 60 * 1000);
//            player1.getBag().remove(timePotion);
//            System.out.println("You consumed the time potion and added 1 minute to your clock!");
//        }
//    }
//
//    private void checkTime() {
//        drunkPenalty += player1.getPlayerDrunk();
//        if (player1.getStartTime() + 5 * 60 * 1000 < System.currentTimeMillis() + drunkPenalty * 1000) {
//            lose();
//        }
//    }
//
//    private void lose() {
//        scoreBoard();
//        System.exit(1);
//
//    }
//
//    private void scoreBoard() {
//        endTimeInMinutes = ((System.currentTimeMillis() + drunkPenalty * 1000 - player1.getStartTime()) / 1000 / 60) ;
//        endTimeInSeconds = ((System.currentTimeMillis() + drunkPenalty * 1000 - player1.getStartTime()) / 1000) % 60 ;
//        if (beefcount >= 4) {
//            if (player1.getStartTime() + 1 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000) {
//                System.out.println("You got 10 points and used " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
//                score = 10;
//            } else if (player1.getStartTime() + 2 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000) {
//                System.out.println("You got 8 points! " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
//                score = 8;
//            } else if (player1.getStartTime() + 3 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000) {
//                System.out.println("You got 6 points! " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
//                score = 6;
//            } else if (player1.getStartTime() + 4 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000 ) {
//                System.out.println("You got 4 points! and used " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
//                score = 4;
//            } else {
//                System.out.println("You got 2 points! " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
//                score = 2;
//            }
//        } else {
//            System.out.println("You got 0 points" + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
//            score = 0;
//        }
//
//    }
//
//}
