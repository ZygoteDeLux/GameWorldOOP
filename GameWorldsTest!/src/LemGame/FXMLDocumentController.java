/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LemGame;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mehgn
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button pickupButton;
    @FXML
    private Button talkButton;
    @FXML
    private Label textLabel;
    @FXML
    private Button map;
    @FXML
    private TextArea mapPrint;
    @FXML
    private TextArea messages;
    @FXML
    private Button northButton;
    @FXML
    private Button eastButton;
    @FXML
    private Button westButton;
    @FXML
    private Button southButton;
    @FXML
    private Button taxiButton;

    int score;
    int highscore = 0;
    int walletTracker = 0;
    int drunkPenalty;
    long endTimeInMinutes;
    long endTimeInSeconds;
    int beefcount = 0;
    Player player1 = new Player();
    Room centrum = new Room("centrum");
    Room north = new Room("north");
    Room south = new Room("south");
    Room east = new Room("east");
    Room west = new Room("west");
    Room fruMadsensHouse = new Room("fru madsens house");
    Room bar = new Room("bar");
    Room taxi = new Room("taxi ");
    Room fishMarket = new Room("the fish market");
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop timePotion = new Prop("time potion", 25, true);
    Prop key = new Prop("key", 0);
    Prop ciggarets = new Prop("ciggarets", 25);
    NPC tuborgMan = new NPC("Tuborg Manden", bar);

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        picture.setImage(fruMadsensImage);
        messages.appendText("Welcome to World Of Lem! "
                + "You wake up in the middle of a city. "
                + "You see a city sign that says 'Centrum of Lem. "
                + "You lost your wallet and you want to go home. You spot a cab that might drive you home. "
                + "You move by useing WASD ");
        System.out.println("Enter your name");
        String name = input.nextLine();
        player1.setPlayerName(name);
        System.out.println("The timer has begun! Hurry up");
        player1.setStartTime(System.currentTimeMillis());
        wallet.setPropDescription(" you can either keep the wallet for 25 coins or find the owner for a potential greater reward");
        beef.setPropDescription(" Give atleast 4 of these to the cab driver to get home");
        ciggarets.setPropDescription(" someone might be intrested in these");
        timePotion.setPropDescription(" Maybe i should try to drink it");
        key.setPropDescription(". Looks like a key for the fish market");
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
        south.addRoomItem(timePotion);
        south.setRoomDescription("South ");
        fruMadsensHouse.setRoomExit(west);
        fishMarket.setRoomExit(north);
        fishMarket.setRoomDescription("You arrived at a fish market. Maybe you can buy some beefs for the cab driver here. ");
        bar.setRoomExit(east);
        bar.addRoomItem(key);
        taxi.setRoomExit(centrum);
        player1.addProp(beef);
        player1.addProp(beef);
        player1.addProp(beef);
        player1.addProp(beef);
    }

    @FXML
    private void pickup(ActionEvent event) {
        int count = 0;
        Scanner input = new Scanner(System.in); //creates a Scanner object with a variable input
        if (!player1.getCurrentPlayerRoom().roomItems.isEmpty()) { //checks if the players room has any items. the ! indicator reverses the isEmpty() method.
            System.out.println("What do you want to pickup? Type 'done' to move on.");

            for (Prop StuffToPrint : player1.getCurrentPlayerRoom().roomItems) { //for loop to iterate through items in room.
                System.out.println(count + " " + StuffToPrint.getPropName()); //prints items
                count++; //increment count variable with 1.
            }
            String inputString; //variable of String type
            while (true) {
                if (!(inputString = input.nextLine()).equalsIgnoreCase("done")) { // exit loop if input = "done" (ignore case)
                    try { //try the following
                        try { // try the following
                            int next = Integer.parseInt(inputString); // Parse input to integer
                            if (player1.getCurrentPlayerRoom().roomItems.get(next).isConsumable()) {
                            }
                            player1.getBag().add(player1.getCurrentPlayerRoom().roomItems.get(next)); // refer to the index in the arraylist roomItems. 
                            System.out.println("You added a " + player1.getCurrentPlayerRoom().roomItems.get(next).getPropName() + " to your bag" + player1.getCurrentPlayerRoom().roomItems.get(next).getPropDescription());
                            player1.getCurrentPlayerRoom().roomItems.remove(next); //remove item from room.
                            count = 0; //reset count variable
                            for (Prop StuffToPrint : player1.getCurrentPlayerRoom().roomItems) { //for loop to iterate through items in room
                                System.out.println(count + " " + StuffToPrint.getPropName()); //print items
                                count++; //increment count variable with 1.
                            }
                        } catch (IndexOutOfBoundsException e) { //if the program gets IndexOutOfBoundsException (If the user enters a number that canøt be referenced in the array list)
                            System.out.println("Enter a valid number"); //print
                        }
                    } catch (NumberFormatException e) { // if the program gets NumberFormatException (if the user inputs something thats not a number)
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

    @FXML
    private void talk(ActionEvent event) {

        if (player1.getCurrentPlayerRoom() == south) {
            if (south.getRoomBehavior() == 1) {
                System.out.println("I could really use a smoke. Do you have any ciggarets my friend? (Type 'hand in' to give the man your ciggarets)");
            } else {
                System.out.println("Thanks for the smoke fam!");
            }
        }

        if (player1.getCurrentPlayerRoom() == taxi) {
            if (taxi.getRoomBehavior() == 1) {
                textLabel.setText("I can take you home for 4 beefs.(Type 'hand in' to give him your beefs.)");
                taxi.setRoomBehavior(0);
            } else {
                textLabel.setText("I have not gotten 4 beefs from you yet, so i cant take you home until i do. (Type 'hand in' to give him your beefs.)");
            }
        }
        if (player1.getCurrentPlayerRoom() == fruMadsensHouse) {
            if (fruMadsensHouse.getRoomBehavior() == 1) {
                System.out.println("Can you help me cut my hedge? (Type 'cut hedge' to help her)");
            } else {
                System.out.println("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentPlayerRoom() == bar) {
            if (bar.getRoomBehavior() == 1) {
                System.out.println("Can you do the dishes for us? (Type 'do dishes' to do the dishes in the bar).");
            } else {
                System.out.println("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentPlayerRoom() == west) {
            if (west.getRoomBehavior() == 1) {
                System.out.println("Did you find my wallet? (Type 'hand in' to give the man your wallet)");
            } else {
                System.out.println("Thanks for the help with finding my wallet!");
            }
        }
        if (player1.getCurrentPlayerRoom() == fishMarket) {
            System.out.println("Here you can buy beefs.");
        }
    }

//    @FXML
//    public void keyPress(ActionEvent event) {
//        
//        
//        switch(event.get)
//        
//        W.setOnKeyPressed(
//                event -> {
//                    switch (event.getCode()) {
//                        case W:
//                            if (player1.getCurrentPlayerRoom() == south) {
//                                move(centrum);
//                            }
//                            if (player1.getCurrentPlayerRoom() == centrum) {
//                                move(north);
//                            }
//                            if (player1.getCurrentPlayerRoom() == north) {
//                                move(fishMarket);
//                            }
//                    }
//                }
//        );
//
//    }
    @FXML
    public void map(ActionEvent event) {
        mapPrint.clear();
        mapPrint.appendText("You are in " + player1.getCurrentPlayerRoom().toString() + "\n" + "You can go :" + "\n");
        for (Room StuffToPrint : player1.getCurrentPlayerRoom().roomExits) {
            mapPrint.appendText("\n");
            mapPrint.appendText("" + StuffToPrint.getRoomName());
        }

        mapPrint.appendText("Tuborg dude is in " + tuborgMan.getNpcRoom());
    }

    @FXML
    private void eastButton(ActionEvent event) {
        
        if (player1.getCurrentPlayerRoom() == centrum) {
            player1.move(east);
            southButton.setVisible(false);
            northButton.setVisible(false);
            westButton.setText("Centrum");
            eastButton.setText("Bar");
            taxiButton.setVisible(false);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == east) {
            player1.move(bar);
            southButton.setVisible(false);
            westButton.setVisible(true);
            northButton.setVisible(false);
            eastButton.setVisible(false);
            taxiButton.setVisible(false);
            westButton.setText("East");
            player1.getCurrentPlayerRoom().getRoomDescription();
           

        } else if (player1.getCurrentPlayerRoom() == west) {
            player1.move(centrum);
            southButton.setVisible(true);
            westButton.setVisible(true);
            northButton.setVisible(true);
            northButton.setText("North");
            southButton.setText("South");
            eastButton.setText("East");
            westButton.setText("West");
            taxiButton.setVisible(true);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == fruMadsensHouse) {
            player1.move(west);
            southButton.setVisible(false);
            westButton.setVisible(true);
            northButton.setVisible(false);
            eastButton.setVisible(true);
            eastButton.setText("Centrum");
            westButton.setText("FruMadsens House");
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == east){
            player1.move(bar);
            southButton.setVisible(false);
            westButton.setVisible(true);
            eastButton.setVisible(false);
            northButton.setVisible(false);
            taxiButton.setVisible(false);
            westButton.setText("East");
            player1.getCurrentPlayerRoom().getRoomDescription();
        }
    }

    @FXML
    private void westButton(ActionEvent event) {
        if (player1.getCurrentPlayerRoom() == centrum) {
            player1.move(west);
            northButton.setVisible(false);
            southButton.setVisible(false);
            eastButton.setVisible(true);
            westButton.setVisible(true);
            eastButton.setText("Centrum");
            westButton.setText("Frumadsens House");
            taxiButton.setVisible(false);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == east) {
            player1.move(centrum);
            southButton.setVisible(true);
            westButton.setVisible(true);
            northButton.setVisible(true);
            eastButton.setVisible(true);
            southButton.setText("South");
            northButton.setText("North");
            eastButton.setText("East");
            westButton.setText("West");
            taxiButton.setVisible(true);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == west) {
            player1.move(fruMadsensHouse);
            southButton.setVisible(false);
            westButton.setVisible(false);
            northButton.setVisible(false);
            eastButton.setVisible(true);
            eastButton.setText("West");
            player1.getCurrentPlayerRoom().getRoomDescription();
        }
        else if (player1.getCurrentPlayerRoom() == bar){
            player1.move(east);
            southButton.setVisible(false);
            westButton.setVisible(false);
            eastButton.setVisible(true);
            westButton.setVisible(true);
            taxiButton.setVisible(false);
            westButton.setText("Centrum");
            eastButton.setText("Bar");
            player1.getCurrentPlayerRoom().getRoomDescription();
        }

    }

    @FXML
    private void northButton(ActionEvent event) {
        if (player1.getCurrentPlayerRoom() == centrum) {
            player1.move(north);
            eastButton.setVisible(false);
            westButton.setVisible(false);
            southButton.setText("Centrum");
            northButton.setText("Fish Market");
            taxiButton.setVisible(false);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == south) {
            player1.move(centrum);
            southButton.setVisible(true);
            westButton.setVisible(true);
            northButton.setVisible(true);
            eastButton.setVisible(true);
            southButton.setText("South");
            northButton.setText("North");
            eastButton.setText("East");
            westButton.setText("West");
            taxiButton.setVisible(true);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == north) {
            player1.move(fishMarket);
            southButton.setVisible(true);
            westButton.setVisible(false);
            northButton.setVisible(false);
            eastButton.setVisible(false);
            southButton.setText("North");
            player1.getCurrentPlayerRoom().getRoomDescription();
        }
    }

    @FXML
    private void southButton(ActionEvent event) {
        if (player1.getCurrentPlayerRoom() == north) {
            player1.move(centrum);
            southButton.setVisible(true);
            westButton.setVisible(true);
            northButton.setVisible(true);
            eastButton.setVisible(true);
            southButton.setText("South");
            northButton.setText("North");
            eastButton.setText("East");
            westButton.setText("West");
            taxiButton.setVisible(true);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == centrum) {
            player1.move(south);
            westButton.setVisible(false);
            eastButton.setVisible(false);
            southButton.setVisible(false);
            northButton.setText("Centrum");
            taxiButton.setVisible(false);
            player1.getCurrentPlayerRoom().getRoomDescription();

        } else if (player1.getCurrentPlayerRoom() == fishMarket) {
            player1.move(north);
            westButton.setVisible(false);
            eastButton.setVisible(false);
            northButton.setVisible(true);
            southButton.setVisible(true);
            taxiButton.setVisible(false);
            southButton.setText("Centrum");
            northButton.setText("Fish Market");
            player1.getCurrentPlayerRoom().getRoomDescription();

        }
    }

}
