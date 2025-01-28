package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import uap.DataHandler;
import uap.Item;
import uap.NotAvailableException;
import uap.User;

public class AdminViewController {
	@FXML
	private Button Add;
	@FXML
    private Button Vehicle;
	@FXML
    private Button HotelRoom;
	@FXML
    private Button Restaurant;
	@FXML
    private Button User;
	@FXML
    private Button ReservationRecord;
	@FXML
    private Button LogOut;
	@FXML
    private Button Cancel;
	@FXML
    private Button reserve;
	@FXML
    private Button makePayment;
	@FXML
	private TextField ItemIDTf;
	@FXML
	private TextField UserTf;
	@FXML
	private TextField NoGTf;
	@FXML
    private DatePicker start;
	@FXML
    private DatePicker end;
	
	public void Add(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/Add1.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
	
	public void Vehicle(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/vehicle.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void HotelRoom(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/hotelRoom.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void Restaurant(ActionEvent event) throws IOException {
	   Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/restaurant.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void User(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/User.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void ReservationRecord(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/ReservationRecord.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void LogOut(ActionEvent event) throws IOException {
	    Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/LogIn.fxml"));
		Scene scene = new Scene(root);			
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void cancleReservation(ActionEvent event) throws NotAvailableException, FileNotFoundException, IOException 
	{
		String ItemID=ItemIDTf.getText();
		
	    Main.Items.cancelReservation(ItemID);
	    DataHandler.saveData(Main.Items);
	   
	}
	public void reserve(ActionEvent event) throws Exception {
		 String ItemId = ItemIDTf.getText();
		 Item item;
		item = Main.Items.findItem(ItemId);
		 String UserId= UserTf.getText();
		 User user;
	     user = Main.Items.findUser(UserId);
		// String StartDate =  start.getValue().toString();
		 LocalDate selectedDate1 = start.getValue();
		 DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d MMM yyyy");
		 String StartDate = selectedDate1.format(formatter1);
		 //String EndDate =  end.getValue().toString();
		 LocalDate selectedDate2 = end.getValue();
		 DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d MMM yyyy");
		 String EndDate = selectedDate2.format(formatter2);
		 String noG = NoGTf.getText();
		 
		 
		 if(NoGTf.getText().isEmpty()) {
			 Main.Items.reserve(item,user.getName(), StartDate, EndDate);
			// JOptionPane.showMessageDialog(null,"Item reserved.");
			 DataHandler.saveData(Main.Items);
		 }
		 else {
			 int noOfGuests=Integer.parseInt(noG);
		 Main.Items.reserve(item,user,noOfGuests,StartDate);
		// JOptionPane.showMessageDialog(null,"Item reserved.");
		 DataHandler.saveData(Main.Items);
		 }
	}
	public void makePayment(ActionEvent event) throws NotAvailableException, Exception {
		String ItemId = ItemIDTf.getText();
		Main.Items.makePayment(ItemId);
		DataHandler.saveData(Main.Items);
	}
	
	
	
}
