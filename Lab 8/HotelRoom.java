package uap;

public class HotelRoom extends Item{
	private String hotelName;
	private int rankOfHotel;
	private int occupancy;
	private boolean hasAC;
	public HotelRoom(String hotelName, int rankOfHotel, int occupancy, boolean hasAC,String id,double rate) {
		super(id,rate);
		this.hotelName=hotelName;
		this.rankOfHotel=rankOfHotel;
		this.occupancy=occupancy;
		this.hasAC=hasAC;
	}
	

	public String getHotelName() {
		return this.hotelName;
	}
	public int getRank() {
		return this.rankOfHotel;
	}
	public int getOccupancy() {
		return this.occupancy;
	}
	public boolean getHasAC() {
		return this.hasAC;
	}
	
	@Override
    public double getPayment(int quantity) {
		return getRate()*quantity;
	}
	@Override
	public String toString() {
		return String.format("ID: %s, Rate: %.2f, Hotel name: %s, Hotel Rank: %d, Occupancy: %d, HasAC: %b, Availibility: %b, Customer: %s",getId(),getRate(),hotelName,rankOfHotel,occupancy,hasAC,getIsAvailable(),getReservedBy());
	}
	

}