package uap;

public class Restaurant extends Item {
	private String restaurantName;
	private int capacity;
	private int occupied;
	
	public Restaurant(String restaurantName, int capacity,String id,double rate) {
		super(id,rate);
		this.restaurantName=restaurantName;
		this.capacity=capacity;
	
	}
	public String getName() {
		return this.restaurantName;
	}
	public int getCapacity() {
		return this.capacity;
	}
	public int getOccupied() {
		return this.occupied;
	}
	public void setOccupied(int occupied) {
		this.occupied=occupied;
	}
	@Override
	public double getPayment(int quantity) {
		return getRate()*quantity;
	}
	@Override
	public String toString() {
		return String.format("ID: %s, Rate: %.2f, Restaurant Name: %s, Capacity: %d, Occupancy: %d, Availibility: %b, Customer: %s",getId(),getRate(),restaurantName,capacity,occupied,getIsAvailable(),getReservedBy());
	}
		
	

}