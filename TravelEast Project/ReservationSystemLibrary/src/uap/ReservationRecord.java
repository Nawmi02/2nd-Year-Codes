package uap;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class ReservationRecord implements Serializable{
	private String id, itemId, userId, note;
	private LocalDate reservation_start_date, reservation_end_date;
	private int quantity;
	
	public ReservationRecord(String itemId, String userId, LocalDate reservation_start_date,
	    LocalDate reservation_end_date) {
		super();
		this.id = "00-" + String. format("%04d", new Random().nextInt(10000));
		this.itemId = itemId;
		this.userId = userId;
		this.reservation_start_date = reservation_start_date;
		this.reservation_end_date = reservation_end_date;
		this.quantity = 1;
	}
	
	public ReservationRecord(String itemId, String userId, LocalDate reservation_start_date,
			LocalDate reservation_end_date, int quantity) {
		super();
		this.id = "00-" + String. format("%04d", new Random().nextInt(10000));
		this.itemId = itemId;
		this.userId = userId;
		this.reservation_start_date = reservation_start_date;
		this.reservation_end_date = reservation_end_date;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getItemId() {
		return itemId;
	}

	public String getUserId() {
		return userId;
	}

	public String getNote() {
		return note;
	}

	public LocalDate getReservation_start_date() {
		return reservation_start_date;
	}

	public LocalDate getReservation_end_date() {
		return reservation_end_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setReservation_start_date(LocalDate reservation_start_date) {
		this.reservation_start_date = reservation_start_date;
	}

	public void setReservation_end_date(LocalDate reservation_end_date) {
		this.reservation_end_date = reservation_end_date;
	}
	
	
	
}
