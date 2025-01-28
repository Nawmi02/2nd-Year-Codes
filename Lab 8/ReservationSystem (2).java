package uap;
import java.util.ArrayList;

public class ReservationSystem {
	private String name;
	private ArrayList<Item>items;
	Item item;
	public ReservationSystem(String name) {
		this.name=name;
		this.items=new ArrayList<>();
	}
	public String get_Name() {
		return this.name;
	}
	public void addItem(String id,double rate,String model,int capacity,double enginePower) {
		item= new Vehicle( model,capacity,enginePower,id,rate);
		items.add(item);
	}
	public void addItem(String id, double rate,String hotelName, int hotelRank, int occupancy, boolean hasAC) {
		item=new HotelRoom(hotelName,hotelRank,occupancy,hasAC,id,rate);
		items.add(item);
	}
	public void addItem(String id,double rate,String restaurantName,int capacity) {
		item=new Restaurant(restaurantName,capacity,id,rate);
		items.add(item);
	}
	public ArrayList<HotelRoom> findRooms(String hotelName, int occupancy, boolean hasAC){
		ArrayList<HotelRoom>rooms=new ArrayList<>();
		for(Item i:items) {
			if(i instanceof HotelRoom) {
			  HotelRoom r=(HotelRoom)i;
			  if(r.getHotelName().equals(hotelName) && r.getOccupancy()==occupancy && r.getHasAC()==hasAC) {
				  rooms.add(r);
			  }
			}
		}
		return rooms;
	}
	public ArrayList<HotelRoom> findRooms(int occupancy, boolean hasAC, double minRate, double maxRate){
		ArrayList<HotelRoom>rooms=new ArrayList<>();
		for(Item i:items) {
			if(i instanceof HotelRoom) {
			  HotelRoom r=(HotelRoom)i;
			  if(r.getOccupancy()==occupancy && r.getHasAC()==hasAC && r.getRate()>=minRate && r.getRate()<=maxRate) {
				   rooms.add(r);
			  }
	     }
			
		}
		return rooms;
   }
	public ArrayList<Vehicle> findVehicles(int capacity, double minRate, double maxRate){
		ArrayList<Vehicle>vehicles=new ArrayList<>();
		for(Item i:items) {
			if(i instanceof Vehicle) {
				Vehicle v=(Vehicle)i;
				if(v.getCapacity()>=capacity && v.getRate()>=minRate && v.getRate()<=maxRate) {
					vehicles.add(v);
				}
			}
			
		}
		return vehicles;
	}
	public ArrayList<Restaurant>findRestaurants(int noOfGuest, double minRate,double maxRate){
		ArrayList<Restaurant>Rs=new ArrayList<>();
		for(Item i:items) {
			if(i instanceof Restaurant) {
				Restaurant r=(Restaurant)i;
				r.setOccupied(noOfGuest);
				if((r.getCapacity()-r.getOccupied())>0 && r.getRate()>=minRate && r.getRate()<=maxRate ) {
					Rs.add(r);
				}
			}
			
		}	
		return Rs;
	}
	public Restaurant findRestaurant(String restaurantName, int noOfGuest, double minRate,double maxRate) {
		
		for(Item i:items) {
			if(i instanceof Restaurant) {
				Restaurant r=(Restaurant)i;
				r.setOccupied(noOfGuest);
				if(r.getName().equals(restaurantName) && (r.getCapacity()-r.getOccupied())>0 && r.getRate()>=minRate && r.getRate()<=maxRate ) {
					return r;
				}
			}
			
		}
		return null;
		
	}
	public Item findItem(String id) {
		int i;
		for(i=0;i<items.size();i++) {
			if(items.get(i)==null)
			{
				break;
			}
			if(items.get(i).getId().equals(id)) {
					return items.get(i);
				}
		}
		return null;
	}
	
	public void Reserve(String id,String ReservedBy) {
		Item i=findItem(id);
		if(i!=null) {
		i.reserveItem(ReservedBy);}
		else {
			System.out.println("Item not found");
		}
	}
	public void reservationComplete(String id) {
		Item i=findItem(id);
		if(i!=null) {
		i.reservationOver();}
		else {
			System.out.println("Item not found");
		}
	}
	public void cancelReservation(String id) {
		Item i=findItem(id);
		if(i!=null) {
		i.cancelReservation();}
		else {
			System.out.println("Item not found");
		}
	}
	public ArrayList<Item> getItems(){
		return items;
	}
	public void viewAll() {
		System.out.println("Vehicles");
		for(Item i:items) {
			if(i instanceof Vehicle) {
				System.out.println(i);
			}
		}
		System.out.println("Hotel Rooms");
		for(Item i:items) {
			if(i instanceof HotelRoom) {
				System.out.println(i);
			}
		}
		System.out.println("Restaurants");
		for(Item i:items) {
			if(i instanceof Restaurant) {
				System.out.println(i);
			}
		}
	}
	
	
	public void viewDetails(String id) {
		Item i=findItem(id);
		if(i!=null) {
		System.out.println(i);}
		else {
			System.out.println("Item not found");
		}
		
	}
}
