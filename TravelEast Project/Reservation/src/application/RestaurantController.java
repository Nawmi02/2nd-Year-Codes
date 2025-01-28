package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import uap.HotelRoom;
import uap.NotAvailableException;
import uap.Restaurant;


public class RestaurantController implements Initializable {
	
	@FXML
	private TextField NameTf;
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
	private Button LogOut;
	@FXML
	private TableColumn<Restaurant, Integer> rCap;
	@FXML
	private TableColumn<Restaurant, String> rName;
	@FXML
	private TableColumn<Restaurant, Integer> rRate;
	@FXML
    private TableColumn<Restaurant, Boolean> rAvailable;
	@FXML
	private TableColumn<Restaurant, String> rID;
	@FXML
	private TableView<Restaurant> restaurantTable;
	
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
	public void initialize(URL arg0, ResourceBundle arg1)  {
	        rName.setCellValueFactory(new PropertyValueFactory<>("restaurantName"));  
	    	rCap.setCellValueFactory(new PropertyValueFactory<>("capacity"));
	    	rRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
	    	rAvailable.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAvailable()));
	    	rID.setCellValueFactory(new PropertyValueFactory<>("id"));
		    showRestaurants();
	 }
	 
	 private void showRestaurants() {
		    ArrayList<Restaurant>restaurants = null;
		    try {
				restaurants=Main.Items.getRestaurants();
			
			} catch (NotAvailableException e) {
				JOptionPane.showMessageDialog(null,"No restaurant available.");
				//e.printStackTrace();
			}
		    ObservableList<Restaurant> restaurantList = FXCollections.observableArrayList(restaurants);
		    restaurantTable.setItems(restaurantList);
		   
		}

	public void findRestaurant(ActionEvent event) throws IOException {
		ArrayList<Restaurant>restaurants = null;
		String Name = NameTf.getText();
		int capacity = Integer.parseInt( CapTf.getText());
		int MaxRate = Integer.parseInt( MaxTf.getText());		
		int MinRate = Integer.parseInt( MinTf.getText());
				
				try {
				if(Name==null||Name.isBlank()) {
					restaurants=Main.Items.findRestaurants(capacity,MinRate,MaxRate);
					 ObservableList<Restaurant> restaurantList = FXCollections.observableArrayList(restaurants);
					 restaurantTable.setItems(restaurantList);
				}
				else {
					restaurants=Main.Items.findRestaurants(Name,capacity,MinRate,MaxRate);
					 ObservableList<Restaurant> restaurantList = FXCollections.observableArrayList(restaurants);
					 restaurantTable.setItems(restaurantList);
				}
				} catch (NotAvailableException e) {
					JOptionPane.showMessageDialog(null,"No restaurant found in the search criteria.");
					//e.printStackTrace();
				}
			}
			
		
		
		
		
	
	
}
