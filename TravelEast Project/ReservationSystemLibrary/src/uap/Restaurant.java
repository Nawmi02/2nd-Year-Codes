package uap;

public class Restaurant extends Item {
	private String restaurantName;
	private int capacity, occupied;
	
	public Restaurant(String restaurantName, int capacity, double rate) {
		super(rate);
		this.restaurantName = restaurantName;
		this.capacity = capacity;
		prependWithId("r-");
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void reserve(int noOfGuest) throws NotAvailableException {
		super.reserve();
		if (noOfGuest > capacity - occupied)
			throw new NotAvailableException("Not enough room available for "+ noOfGuest + " guests.");
		
		occupied += noOfGuest;
		
	}

	@Override
	public String info() {
		return String.format("Name:%s Capacity:%d", restaurantName,capacity);
	}
	
	

}
