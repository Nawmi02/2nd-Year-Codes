package application;

import java.io.FileNotFoundException;
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

public class AddController {
	@FXML
	private Button LogOut;
	@FXML
	private Button Back;
	@FXML
	private Button AddV;
	@FXML
	private Button AddH;
	@FXML
	private Button AddR;
	@FXML
	private TextField model;
	@FXML
	private TextField capV;
	@FXML
	private TextField rateV;
	@FXML
	private TextField enP;
	@FXML
	private TextField nameH;
	@FXML
	private TextField rank;
	@FXML
	private TextField rateH;
	@FXML
	private TextField capH;
	@FXML
	private CheckBox ac;
	@FXML
	private TextField nameR;
	@FXML
	private TextField rateR;
	@FXML
	private TextField capR;
	
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
		
	public void AddVehicle(ActionEvent event) throws FileNotFoundException, IOException {
		String Model=model.getText();
		String cap=capV.getText();
		int capacity=Integer.parseInt(cap);
		String ep=enP.getText() ;
		float enginePower=Float.parseFloat(ep);
		String r=rateV.getText();
		double rate=Double.parseDouble(r);
		Main.Items.addItem(Model,capacity,enginePower,rate);
		DataHandler.saveData(Main.Items);
		JOptionPane.showMessageDialog(null,"Vehicle added.");
	}
	public void AddHotelRoom(ActionEvent event) throws FileNotFoundException, IOException {
		String name=nameH.getText();
		String ran=rank.getText();
		int Rank=Integer.parseInt(ran);
		String r=rateH.getText();
		double rate=Double.parseDouble(r);
		String cap=capH.getText();
		int capacity=Integer.parseInt(cap);
		boolean AC= ac.isSelected();
		Main.Items.addItem(name,Rank,capacity,AC,rate);
		DataHandler.saveData(Main.Items);
		JOptionPane.showMessageDialog(null,"Hotelroom added.");
	}
	public void AddRestaurant(ActionEvent event) throws FileNotFoundException, IOException {
		String name=nameR.getText();
		String cap=capR.getText();
		int capacity=Integer.parseInt(cap);
		//String r=rateH.getText();
		double rate=Double.parseDouble(rateR.getText());
		Main.Items.addItem(name,capacity,rate);
		DataHandler.saveData(Main.Items);
		JOptionPane.showMessageDialog(null,"Restaurant added.");
	}
	
}
