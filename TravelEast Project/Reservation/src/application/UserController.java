package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import uap.InvalidUserException;
import uap.User;


public class UserController implements Initializable {
	ObservableList<User> userList = FXCollections.observableArrayList();
	@FXML
	private TextField UserIdTf;
	@FXML
	private Button Search;
	@FXML
	private Button Back;
	@FXML
	private Button LogOut;
	@FXML
	private TableColumn<User, String> uName;
	@FXML
	private TableColumn<User, String>uID;
	@FXML
	private TableColumn<User, Integer>age;
	@FXML
	private TableColumn<User, Boolean>admin;
	@FXML 
	private TableView<User> userTable;

	
	public void LogOut(ActionEvent event) throws IOException {
	    Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/LogIn.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
	public void Back(ActionEvent event) throws IOException {
	    Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/AdminViewAno.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 uName.setCellValueFactory(new PropertyValueFactory<>("name"));
		 uID.setCellValueFactory(new PropertyValueFactory<>("id"));
		 age.setCellValueFactory(new PropertyValueFactory<>("age"));
		 admin.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAdmin()));
		 showUsers();
	}
	private void showUsers() {
	    ArrayList<User> users = Main.Items.getUsers();
	    userList.setAll(users);
	    userTable.setItems(userList);
	}
	
	public void findUser(ActionEvent event) throws IOException {
		String userID=UserIdTf.getText();
		
		try {
			userList.clear();
			userList.setAll(Main.Items.findUser(userID));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
		
		
		
	}
		
	

}
