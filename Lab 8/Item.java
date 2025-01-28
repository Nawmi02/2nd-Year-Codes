package uap;

public abstract class Item {
	private String id;
	private double rate;
	private boolean isAvailable;
	private String reservedBy;
	
	public Item(String id,double rate) {
		this.id=id;
		this.rate=rate;
		this.isAvailable=true;
	}
	
	public String getId() {
		return id;
	}
	
	public double getRate() {
		return rate;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	public String getReservedBy() {
		return reservedBy;
	}
	
	public void setRate(double rate) {
		this.rate=rate;
	}
	
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable= isAvailable;
	}
	
	public void setReservedBy(String reservedBy) {
		this.reservedBy=reservedBy;
	}
	
	public void reserveItem(String reservedBy) {
		setIsAvailable(false);
		setReservedBy(reservedBy);
	}
	
	public void reservationOver() {
		setIsAvailable(true);
		setReservedBy(null);
	}
	
	public void cancelReservation() {
		setIsAvailable(true);
		setReservedBy(null);
	}
	
	public abstract double getPayment(int quantity) ;
	
	@Override
	public String toString() {
		return String.format("ID: %s, Rate: %.2f, Availibility: %b, Customer: %s",id,rate,isAvailable,reservedBy);
	}
		

}
