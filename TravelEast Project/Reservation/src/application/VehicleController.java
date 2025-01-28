package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import uap.DataHandler;
import uap.InvalidUserException;
import uap.Item;
import uap.NotAvailableException;
import uap.User;
import uap.Vehicle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class VehicleController implements Initializable {
	
	@FXML
	private TextField CapTf;
	@FXML
	private TextField MinTf;
	@FXML
	private TextField MaxTf;
	@FXML
	private Button Search;
	@FXML
	private Button Back;
	
	@FXML
    private TableColumn<Vehicle, String> vModel;
	@FXML
    private TableColumn<Vehicle, Integer> vCapacity;
     @FXML
    private TableColumn<Vehicle, Integer> vRate;
     @FXML
     private TableColumn<Vehicle, Float> EgPower;
     @FXML
     private TableColumn<Vehicle, Boolean> vAvailable;
     @FXML
 	private TableColumn<Vehicle, String> vID;
     @FXML
    private TableView<Vehicle> vehicleTable;
	
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
		//if(Main.currentUser.isAdmin()) {
			//Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/AdminViewAno.fxml"));
			//Scene scene = new Scene(root);			
			//Main.stage.setScene(scene);
			//Main.stage.show();
		//}
		//else {
			//Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/CustomerView1.fxml"));
			//Scene scene = new Scene(root);			
			//Main.stage.setScene(scene);
			//Main.stage.show();
		//}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
	    vModel.setCellValueFactory(new PropertyValueFactory<>("model"));  
    	vCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
    	vRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
    	EgPower.setCellValueFactory(new PropertyValueFactory<>("enginePower"));
    	vAvailable.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAvailable()));
    	vID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	
    	showVehicles();
		
	}
	private void showVehicles() { // error chole gese evabe sob controller thik korte hbe
		
	    ArrayList<Vehicle>vehicles = null;
	    try {
			//vehicles.addAll(Main.Items.getVehicles());
			vehicles = Main.Items.getVehicles();
			
		} catch (NotAvailableException e) {
		 JOptionPane.showMessageDialog(null,"No vehicle available.");
		}
	    ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList(vehicles);
	 //   vehicleList.setAll(vehicles);
	    vehicleTable.setItems(vehicleList);
	}

	
	public void findVehicle(ActionEvent event) throws IOException {
		
		ArrayList<Vehicle>vehicles=null;
		int capacity = Integer.parseInt(CapTf.getText());
		int MaxRate = Integer.parseInt( MaxTf.getText());
		int MinRate = Integer.parseInt(MinTf.getText());
		
		
		try {
			// vehicles.addAll(Main.Items.findVehicles(capacity, MinRate,MaxRate));
			 
			 vehicles = Main.Items.findVehicles(capacity, MinRate,MaxRate); 
			 ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList(vehicles);
			 vehicleTable.setItems(vehicleList);
			
		} catch (NotAvailableException e) {
			JOptionPane.showMessageDialog(null,"No vehicle found in this search criteria.");
		}
		

    }
	
}
	
