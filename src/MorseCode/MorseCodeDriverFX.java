package MorseCode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MorseCodeDriverFX extends Application{
	
   
   public static void main(String[] args){
	   launch(args);
   }
   
   public void start(Stage stage)
   {

	   //call the main scene which is a BorderPane
	   MorseCodeMain mainPane = new MorseCodeMain();
	   //PasswordMain root = mainPane.getTopContainer();
	   Scene scene = new Scene(mainPane, 550, 350);
	   stage.setScene(scene);
	   stage.setTitle("Morse Code Converter Driver");
	   stage.show();
   }
   
}
