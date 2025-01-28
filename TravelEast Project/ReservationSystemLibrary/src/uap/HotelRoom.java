package uap;

public class HotelRoom extends Item {
	private String hotelName;
	private int rankOfHotel, maxCapacity;
	private boolean hasAC;
	
	public HotelRoom(String hotelName, int rankOfHotel, int maxCapacity, boolean hasAC, double rate) {
		super(rate);
		this.hotelName = hotelName;
		this.rankOfHotel = rankOfHotel;
		this.maxCapacity = maxCapacity;
		this.hasAC = hasAC;
		prependWithId("h-");
	}

	public String getHotelName() {
		return hotelName;
	}

	public int getRankOfHotel() {
		return rankOfHotel;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public boolean hasAC() {
		return hasAC;
	}

	@Override
	public String info() {
		return String.format("HotelName:%s, Max Capacity:%d, Has AC:%s", hotelName, maxCapacity, hasAC);
	}
	
	
}
