package LemGame;
import java.util.*;
public class Game {

    private Room currentroom;

    public static void main(String[] args) {
        
    }

    public String getCurrentRoom() {
        return currentroom.getShortDescription();
       
    }

    public void createRoom() {
        Room centrum, northLem, southLem, eastLem, westLem;
        centrum = new Room("You are in downtown Lem now");
        northLem = new Room("You are in north Lem now");
        southLem = new Room("You are in south Lem now");
        eastLem = new Room("You are in east Lem now");
        westLem = new Room("You are in west Lem now");
        centrum.getShortDescription();
        centrum.setExit("North", northLem);
        centrum.setExit("South", southLem);
        centrum.setExit("East", eastLem);
        centrum.setExit("West", westLem);
        currentroom = centrum;
    }

    public void goRoom(Command command) {
        String direction = command.getSecondWord();
        Room nextRoom;
        nextRoom = new Room(direction);
        

        if (nextRoom == null) {
            System.out.println("You cant go there");
        } else {
            nextRoom = currentroom;
        }
    }
    
    
}
