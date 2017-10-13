package LemGame;
import java.util.*;
public class Game {

    private Room currentroom;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name! ");
        String insertName = input.nextLine();
        Player playerName = new Player(insertName);
        Prop wallet = new Prop("wallet", 25);
        Prop beef = new Prop("beef", 25);
        Prop cigarettes = new Prop("ciggarets", 25);
        System.out.println(playerName.getPlayerName());
        System.out.println(playerName.getPlayerCurrency());
        playerName.addItem(beef);
        playerName.addItem(wallet);
        playerName.addItem(cigarettes);
        playerName.showBag();
    }

    
}
