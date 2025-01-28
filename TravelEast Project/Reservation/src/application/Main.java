package application;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import uap.DataHandler;
import uap.ReservationSystem;
import uap.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    public static Stage stage;
	public static ReservationSystem Items = new ReservationSystem("Nawmi");
	//public static User currentUser= null;
	@Override
	public void start(Stage primaryStage) {
		
		 Main.stage = primaryStage;
		try {
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("application/LogIn.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Items = DataHandler.loadData();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}
}
