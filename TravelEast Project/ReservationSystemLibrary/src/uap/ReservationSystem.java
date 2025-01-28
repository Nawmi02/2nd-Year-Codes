package uap;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class ReservationSystem implements Serializable{
	private String name;
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<ReservationRecord> records = new ArrayList<>();	

	public ReservationSystem(String name) {
		this.name = name;
	}

	private String addItem(Item item) {
		items.add(item);
		return item.getId();
	}

	public String addItem(String model, int capacity, float enginePower, double rate) {
		Vehicle v = new Vehicle(model, capacity, enginePower, rate);
		return addItem(v);
	}

	public String addItem(String hotelName, int rankOfHotel, int maxCapacity, boolean hasAC, double rate) {
		HotelRoom hr = new HotelRoom(hotelName, rankOfHotel, maxCapacity, hasAC, rate);
		return addItem(hr);
	}

	public String addItem(String restaurantName, int capacity, double rate) {
		Restaurant rs = new Restaurant(restaurantName, capacity, rate);
		return addItem(rs);
	}

	public ArrayList<HotelRoom> findRooms(String hotelName, int capacity, boolean hasAC) throws NotAvailableException{
		ArrayList<HotelRoom> rooms = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof HotelRoom) {
				HotelRoom room = (HotelRoom)item;
//				System.out.println(room+":"+room.info());
				if ((hotelName==null || room.getHotelName().toLowerCase().contains(hotelName.toLowerCase())) && (room.hasAC()== hasAC) && room.getMaxCapacity()>=capacity) {
//					System.out.println(room.info());
					rooms.add(room);
				}
			}
		}		

		if (rooms.size()==0)
			throw new NotAvailableException("No room found with specfied criteria.");
		
		return rooms;
	}


	public ArrayList<HotelRoom> findRooms(String hotelName, int capacity, boolean hasAC, int minRent, int maxRent) throws NotAvailableException{
		ArrayList<HotelRoom> rooms = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof HotelRoom) {
				HotelRoom room = (HotelRoom)item;
				if ((hotelName==null || room.getHotelName().toLowerCase().contains(hotelName.toLowerCase())) && (room.hasAC()== hasAC) && room.getMaxCapacity()>= capacity && room.getRate()>=minRent && room.getRate()<=maxRent) {
					rooms.add(room);
				}
			}
		}		

		if (rooms.size()==0)
			throw new NotAvailableException("No room found with specfied criteria.");

		return rooms;
	}

	public ArrayList<HotelRoom> getRooms() throws NotAvailableException{
		ArrayList<HotelRoom> rooms = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof HotelRoom) {
				rooms.add((HotelRoom)item);
			}
		}		

		if (rooms.size()==0)
			throw new NotAvailableException("No room found with specfied criteria.");

		return rooms;
	}

	public ArrayList<Vehicle> getVehicles() throws NotAvailableException{
		ArrayList<Vehicle> vehicles = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof Vehicle) {
				vehicles.add((Vehicle)item);
			}
		}		

		if (vehicles.size()==0)
			throw new NotAvailableException("No room found with specfied criteria.");

		return vehicles;
	}

	public ArrayList<Restaurant> getRestaurants() throws NotAvailableException{
		ArrayList<Restaurant> restaurants = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof Restaurant) {
				restaurants.add((Restaurant)item);
			}
		}		

		if (restaurants.size()==0)
			throw new NotAvailableException("No room found with specfied criteria.");

		return restaurants;
	}

	public ArrayList<Vehicle> findVehicles(int capacity, int minRent, int maxRent) throws NotAvailableException{
		ArrayList<Vehicle> vehicles = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof Vehicle) {
				Vehicle vehicle = (Vehicle)item;
				if (vehicle.getCapacity()>= capacity && (minRent==0 || vehicle.getRate()>=minRent) && (maxRent==0 || vehicle.getRate()<=maxRent)) {
					vehicles.add(vehicle);
				}
			}
		}


		if (vehicles.size()==0)
			throw new NotAvailableException("No vehicle found with specfied criteria.");

		return vehicles;
	}

	public ArrayList<Restaurant> findRestaurants(int capacity, int minRent, int maxRent) throws NotAvailableException{
		ArrayList<Restaurant> restaurants = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof Restaurant) {
				Restaurant rest = (Restaurant)item;
				if (rest.getCapacity()>= capacity && (minRent==0 ||rest.getRate()>=minRent) && (maxRent==0 ||rest.getRate()<=maxRent)) {
					restaurants.add(rest);
				}
			}
		}


		if (restaurants.size()==0)
			throw new NotAvailableException("No restaurant found with specfied criteria.");

		return restaurants;
	}

	public ArrayList<Restaurant> findRestaurants(String restaurantName, int capacity, int minRent, int maxRent) throws NotAvailableException{
		ArrayList<Restaurant> restaurants = new ArrayList<>();

		for (Item item: items) {
			if (item instanceof Restaurant) {
				Restaurant rest = (Restaurant)item;
				if (rest.getRestaurantName().equalsIgnoreCase(restaurantName) && rest.getCapacity()>= capacity && rest.getRate()>=minRent && rest.getRate()<=maxRent) {
					restaurants.add(rest);
				}
			}
		}


		if (restaurants.size()==0)
			throw new NotAvailableException("No restaurant found with specfied criteria.");

		return restaurants;
	}

	public Item findItem(String id) throws NotAvailableException {
		for (Item item: items) {
			if (item.getId().equalsIgnoreCase(id))
				return item;
		}

		throw new NotAvailableException("Not a valid id");
	}

	public void reserve(Item item, User reservedFor, String start_date, String end_date) throws NotAvailableException, ParseException {
		item.reserve();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startDate =  LocalDate.parse(start_date, formatter);
		LocalDate endDate = LocalDate.parse(end_date, formatter);
		ReservationRecord record = new ReservationRecord(item.getId(), reservedFor.getId(), startDate, endDate);
		records.add(record);
		item.setlatestReservationRecordId(record.getId());
	}

	public void reserve(Item item, String reservedFor, String start_date, String end_date) throws NotAvailableException, ParseException {
		item.reserve();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startDate =  LocalDate.parse(start_date, formatter);
		LocalDate endDate = LocalDate.parse(end_date, formatter);
		ReservationRecord record = new ReservationRecord(item.getId(), reservedFor, startDate, endDate);
		records.add(record);		
		item.setlatestReservationRecordId(record.getId());
	}

	public void reserve(Item item, String reservedFor, LocalDate startDate, LocalDate endDate) throws NotAvailableException, ParseException {
		item.reserve();
		ReservationRecord record = new ReservationRecord(item.getId(), reservedFor, startDate, endDate);
		records.add(record);		
		item.setlatestReservationRecordId(record.getId());
	}

	public void reserve(Item item, User reservedFor, int noOfGuest, String start_date) throws NotAvailableException, ParseException, Exception {
		if (item instanceof Restaurant) {
			((Restaurant)item).reserve(noOfGuest);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate startDate =  LocalDate.parse(start_date, formatter);
			LocalDate endDate = LocalDate.parse(start_date, formatter);
			ReservationRecord record = new ReservationRecord(item.getId(), reservedFor.getId(), startDate, endDate, noOfGuest);
			records.add(record);	
			item.setlatestReservationRecordId(record.getId());
		}
		else
			throw new Exception("Invalid selection");
	}

	public double makePayment(String id) throws NotAvailableException, Exception {
		Item item = findItem(id);
		if (!item.isAvailable()) {
			ReservationRecord rec = findReservationRecord(item.getReservationHistoryItemId());
			item.setAvailable(true);
			item.setlatestReservationRecordId(null);
			if (item instanceof Restaurant) {
				item.setlatestReservationRecordId(null);
				return item.getRate()*rec.getQuantity();
			}
			else{
				if (!rec.getReservation_end_date().equals(LocalDate.now())) {
					rec.setReservation_end_date(LocalDate.now());							
				}

				long daysBetween = ChronoUnit.DAYS.between(rec.getReservation_start_date(), rec.getReservation_end_date());
				if (daysBetween<0)
					throw new Exception("Invalid checkout date.");
				item.setlatestReservationRecordId(null);
				return (double)item.getRate()*daysBetween;
			}


		}
		else
			throw new NotAvailableException("Item is not reserved. Please check the id");		

	}
	public ArrayList<ReservationRecord> getRecords() throws NotAvailableException{
		return records;
	}


	public void cancelReservation(String id) throws NotAvailableException {
		Item item = findItem(id);
		if (!item.isAvailable()) {	
			ReservationRecord rec = findReservationRecord(item.getReservationHistoryItemId());
			item.setAvailable(true);
			item.setlatestReservationRecordId(null);
			rec.setNote("Reservation Cancelled");
		}
		throw new NotAvailableException("Item is not reserved. Please check the id");
	}

	public void cancelReservation(Item item) throws NotAvailableException {
		if (!item.isAvailable()) {	
			ReservationRecord rec = findReservationRecord(item.getReservationHistoryItemId());
			item.setAvailable(true);
			item.setlatestReservationRecordId(null);
			rec.setNote("Reservation Cancelled");
		}
		else
			throw new NotAvailableException("Item is not reserved. Please check the id");
	}

	public User findUser(String id) throws InvalidUserException {
		for (User user: users) {
			if (user.getId().equalsIgnoreCase(id))
				return user;
		}

		throw new InvalidUserException(id);
	}

   public ArrayList<String> getReservationHistoryForUser(String userId) throws InvalidUserException, NotAvailableException{
		ArrayList<String> recs = new ArrayList<>();
		User user = findUser(userId);

		for(ReservationRecord rec: records) {
			if (rec.getUserId().equalsIgnoreCase(userId)) {
				Item item = findItem(rec.getItemId());
				String data;
				if (item instanceof Restaurant)
					data = String.format("Info:%s, No Of Guests:%d", item.info(), rec.getQuantity());
				else
					data = String.format("Info:%s, start_date:%, end_date:%s", item.info(), rec.getReservation_start_date(), rec.getReservation_end_date());

				recs.add(data);
			}
		}

		if (recs.size() == 0)
			recs.add("No record available");
		else
			recs.add(0, String.format("Reservation record for user: %s (%s)",user.getName(), user.getId()));
		return recs;
	}

	public ArrayList<String> getReservationHistoryForItem(String itemId) throws InvalidUserException, NotAvailableException{
		ArrayList<String> recs = new ArrayList<>();
		Item item = findItem(itemId);

		for(ReservationRecord rec: records) {
			if (rec.getItemId().equalsIgnoreCase(itemId)) {
				User user = findUser(rec.getUserId());
				String data;
				if (item instanceof Restaurant)
					data = String.format("Reserved By:%s, No Of Guests:%d", user.getName(), rec.getQuantity());
				else
					data = String.format("Reserved By:%s, start_date:%, end_date:%s", user.getName(), rec.getReservation_start_date(), rec.getReservation_end_date());

				recs.add(data);
			}
		}

		if (recs.size() == 0)
			recs.add("No record available");
		else
			recs.add(0, String.format("Reservation record for Item (%s): %s",itemId, item.info()));
		return recs;
	}

	public ReservationRecord findReservationRecord(String reservId) throws NotAvailableException {
		for(int i=records.size()-1; i>=0; i--) {
			ReservationRecord rec = records.get(i);
			if (rec.getId().equalsIgnoreCase(reservId)) 
				return rec;
		}

		throw new NotAvailableException("Reservation record not available. Check the id.");
	}

	public String addUser(String name, int age, boolean isAdmin) {
		User user = new User(name, age, isAdmin);
		users.add(user);
		return user.getId();
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public boolean logIn(String id) throws InvalidUserException {
		User user = findUser(id);
		return user.isAdmin();
	}

	public boolean isSuperAdmin(String id) {
		return id.equals("123");

	}

}
