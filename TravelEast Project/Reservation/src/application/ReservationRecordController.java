package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import uap.NotAvailableException;
import uap.ReservationRecord;



public class ReservationRecordController implements Initializable{
	ObservableList<ReservationRecord> recordList = FXCollections.observableArrayList();
	@FXML
	private Button Back;
	@FXML
	private Button LogOut;
	@FXML
	private TableColumn<ReservationRecord, String> itemID;
	@FXML
	private TableColumn<ReservationRecord, String> userID;
	@FXML
	private TableColumn<ReservationRecord, String> recordID;
    @FXML
	private TableColumn<ReservationRecord, LocalDate> rStartdate;
	@FXML
	private TableColumn<ReservationRecord, LocalDate> rEnddate;
	@FXML 
	private TableView<ReservationRecord> recordTable;
	
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
		  itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));  
		  userID.setCellValueFactory(new PropertyValueFactory<>("userID"));  
		  recordID.setCellValueFactory(new PropertyValueFactory<>("id")); 
		  rStartdate.setCellValueFactory(new PropertyValueFactory<>("reservation_start_date")); 
		  rEnddate.setCellValueFactory(new PropertyValueFactory<>("reservation_end_date")); 
		  try {
			showRecords();
		} catch (NotAvailableException e) {
			e.printStackTrace();
		}
	}
	private void showRecords() throws NotAvailableException {
		ArrayList<ReservationRecord>records = Main.Items.getRecords();
	    recordList.setAll(records);
	    recordTable.setItems(recordList);
	}
	
}
