package LemGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiTest extends Application {

    Player player;
    Stage window;
    
    
    public static void main(String[] args){
        launch(args);
    }
    
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage = window;
        
        window.setTitle("Kristian's Hygge Program");
        
        VBox layout = new VBox(10);
        
        Button pickup = new Button("pickup");
        pickup.setOnAction( e -> player.pickUp());
        
        Scene scene = new Scene(layout, 300, 250);
        
        window.setScene(scene);
        window.show();
        
    }

}
