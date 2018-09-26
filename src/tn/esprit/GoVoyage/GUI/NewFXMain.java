package tn.esprit.GoVoyage.GUI;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nizar
 */
public class NewFXMain extends Application {
    public static String dateString;
    
    @Override
    public void start(Stage primaryStage) throws IOException, ParseException {
    
SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd" ); 
Date currentTime_1 = new Date(); 
 dateString = formatter.format(currentTime_1);
 System.out.println(dateString);
 //Date dateee = SimpleDateFormat.parse(dateString);
       // Parent root =FXMLLoader.load(getClass().getResource("GestionOffre.fxml"));
      
    //         Parent root = FXMLLoader.load(getClass().getResource("FXMLGestionReservation.fxml"));
  Parent root = FXMLLoader.load(getClass().getResource("ClientXML.fxml"));
   primaryStage.setTitle("GoVoyage!");
   primaryStage.setScene(new Scene (root , 600 , 400));
   
  // primaryStage.setScene(new Scene (root , 1371 , 848));
   primaryStage.show();
   
   
   

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
