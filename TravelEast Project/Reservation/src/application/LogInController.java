package application;


import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import uap.DataHandler;
import uap.InvalidUserException;
import uap.User;

public class LogInController {
	 @FXML
	    private TextField userTf;
	 @FXML 
		private TextField nameTf;
		
	@FXML 
		private TextField ageTf;
		
	@FXML 
		private CheckBox adminCB;
	@FXML
        private Button LogIn;
	@FXML 
	    private Button SignUp;
	
	public void LogIn(ActionEvent event) throws IOException {
		String userID=userTf.getText();
		if(userID==null||userID.isBlank()) {
			return;
		}
			try {
				User user = Main.Items.findUser(userID);
				//Main.currentUser=user;
				if(user.isAdmin()) {
					Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/AdminViewAno.fxml"));
					Scene scene = new Scene(root);			
					Main.stage.setScene(scene);
					Main.stage.show();
				}
				else {
					Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/CustomerView1.fxml"));
					Scene scene = new Scene(root);			
					Main.stage.setScene(scene);
					Main.stage.show();
				}
			}catch (InvalidUserException e) {
					JOptionPane.showMessageDialog(null, "Login Failed");
					e.printStackTrace();
				}
	}
	
		//if(userID.startsWith("11-")) {
			//Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/AdminViewAno.fxml"));
			//Scene scene = new Scene(root);			
			//Main.stage.setScene(scene);
			//Main.stage.show();
		//}
		//else if(userID.startsWith("22-")) {
		//	Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/CustomerView1.fxml"));
		//	Scene scene = new Scene(root);			
		//	Main.stage.setScene(scene);
		//    Main.stage.show();
		//}
	
	public void SignUp(ActionEvent event) throws IOException{
		String name=nameTf.getText();
		String ageText = ageTf.getText();
		int age=Integer.parseInt(ageText);
		boolean isAdmin = adminCB.isSelected();
		Main.Items.addUser(name,age,isAdmin); 
		DataHandler.saveData(Main.Items);
		JOptionPane.showMessageDialog(null,"Signed up successfully.");
		
		if(isAdmin) {
			Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/AdminViewAno.fxml"));
			Scene scene = new Scene(root);			
			Main.stage.setScene(scene);
			Main.stage.show();
		}
		else {
			Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/CustomerView1.fxml"));
			Scene scene = new Scene(root);			
			Main.stage.setScene(scene);
			Main.stage.show();
		}

	}

}
