package uap;

import java.io.Serializable;
import java.util.Random;

public abstract class Item implements Serializable{
	private String id, latestReservationRecordId;
	private boolean isAvailable;
	private double rate;
	
	
	public double getRate() {
		return rate;
	}

	public Item(double rate) {
		this.rate = rate;
		this.id = String. format("%04d", new Random().nextInt(10000));
		this.isAvailable = true;
	}
	
	protected void prependWithId(String prefix) {
		this.id = prefix + this.id;
	}

	public String getReservationHistoryItemId() {
		return latestReservationRecordId;
	}

	public void setlatestReservationRecordId(String latestReservationRecordId) {
		this.latestReservationRecordId = latestReservationRecordId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getId() {
		return id;
	}
	
	public void reserve() throws NotAvailableException {
		if (!isAvailable()) 
			throw new NotAvailableException("This item is already reserved.");
		else
			isAvailable = false;
	}
	
	public abstract String info();
	
}
