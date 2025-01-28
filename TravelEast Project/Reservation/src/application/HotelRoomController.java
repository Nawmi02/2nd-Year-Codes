package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import uap.HotelRoom;
import uap.NotAvailableException;
import javafx.collections.ObservableList;

public class HotelRoomController implements Initializable {
	
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
	private CheckBox acCB;
    @FXML
	private TableColumn<HotelRoom, String> hName;
    @FXML
    private TableColumn<HotelRoom, Integer> hRank;
    @FXML
	private TableColumn<HotelRoom, Integer> hCap;
    @FXML
    private TableColumn<HotelRoom, Boolean> hAC;
    @FXML
    private TableColumn<HotelRoom, Double> hRate;
    @FXML
    private TableColumn<HotelRoom, Boolean> hAvailable;
    @FXML
	private TableColumn<HotelRoom, String> hID;
    @FXML
    private TableView<HotelRoom> hotelRoomTable;
  
    
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
		hName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));  
		hRank.setCellValueFactory(new PropertyValueFactory<>("rankOfHotel"));
		hCap.setCellValueFactory(new PropertyValueFactory<>("maxCapacity"));
   	    hRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
      	hAvailable.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAvailable()));
   	    hAC.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().hasAC()));
   	    hID.setCellValueFactory(new PropertyValueFactory<>("id"));
   	    showHotelRooms();
   	}
	private void showHotelRooms() {
	    ArrayList<HotelRoom>rooms = null;
	    try {
			rooms=Main.Items.getRooms();
		} catch (NotAvailableException e) {
			JOptionPane.showMessageDialog(null,"No room available.");
		}
	    ObservableList<HotelRoom> hotelList = FXCollections.observableArrayList(rooms);
	    hotelRoomTable.setItems(hotelList);
	}
	public void findHotel(ActionEvent event) throws IOException {
		 ArrayList<HotelRoom>rooms = null;
		String Name = NameTf.getText();
		int capacity = Integer.parseInt( CapTf.getText());
		int MaxRate = Integer.parseInt(MaxTf.getText());
		int MinRate = Integer.parseInt( MinTf.getText());
		boolean hasAc = acCB.isSelected();
		try {
			
			if(MaxTf.getText().isBlank()||MinTf.getText().isBlank()) {
				rooms=Main.Items.findRooms(Name,capacity,hasAc);
				ObservableList<HotelRoom> hotelList = FXCollections.observableArrayList(rooms);
				 hotelRoomTable.setItems(hotelList);
			}else {
				rooms=Main.Items.findRooms(Name,capacity,hasAc,MinRate,MaxRate);
				ObservableList<HotelRoom> hotelList = FXCollections.observableArrayList(rooms);
				hotelRoomTable.setItems(hotelList);
			}
			
		} catch (NotAvailableException e) {
			JOptionPane.showMessageDialog(null,"No room found in the search criteria.");
		}
		

	}
}
