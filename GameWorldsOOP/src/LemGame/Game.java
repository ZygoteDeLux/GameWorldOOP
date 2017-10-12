package LemGame;

public class Game {

    private Room currentroom;
            Command pickup = new Command();


    public static void main(String[] args) {
    }

    public String getCurrentRoom() {
        return currentroom.getShortDescription();
       
    }

    public void createRoom() {
        Room Centrum, northLem, southLem, eastLem, westLem;
        Centrum = new Room("You are in centrum now");
        northLem = new Room("You are in north Lem now");
        southLem = new Room("You are in south Lem now");
        eastLem = new Room("You are in east Lem now");
        westLem = new Room("You are in west Lem now");
        Centrum.getShortDescription();
        Centrum.setExit("North", northLem);
        Centrum.setExit("South", southLem);
        Centrum.setExit("East", eastLem);
        Centrum.setExit("West", westLem);
        currentroom = Centrum;
    }

    public void goRoom() {
        String direction = commandX;
        Room nextRoom;
        nextRoom = new Room(direction);

        if (nextRoom == null) {
            System.out.println("You cant go there");
        } else {
            nextRoom = currentroom;
        }
        //mangler command til "get descritopn of next room, and command to see if room is valid
    }
    
    
}
