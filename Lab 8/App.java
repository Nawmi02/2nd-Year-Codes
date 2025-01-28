package uap.app;
import uap.Item;
import uap.Vehicle;
import uap.HotelRoom;
import uap.Restaurant;
import uap.ReservationSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		ReservationSystem reservation=new ReservationSystem("My Reservation System");
		String id;
		double rate;
		Menu:
    		while(true) {
    			System.out.println("1.Add Item");
    			System.out.println("2.Search Item");
    			System.out.println("3.View by category");
    			System.out.println("4.Reserve");
    			System.out.println("5.Reservation Over");
    			System.out.println("6.Cancel Reservation");
    			System.out.println("7.Exit");
    			
    			System.out.println("Enter Option: ");
    			int option=scan.nextInt();
    			
    			switch(option) {
    			case 1://Add Item
    						System.out.println("Which item to be added: ");
    						System.out.printf("\n1.Vehicle\n2.Hotel Room\n3.Restaurant\n");
    						System.out.println("Enter Option: ");
    						int opt=scan.nextInt();
    						switch(opt) {
    						case 1://Add Vehicle 
    							System.out.println("Enter ID: ");
    							id=scan.next();
    							System.out.println("Enter rate: ");
    							rate=scan.nextDouble();
    							System.out.println("Enter Model: ");
    							String model=scan.next();
    							System.out.println("Enter Capacity: ");
    							int c=scan.nextInt();
    							System.out.println("Enter Engine Power: ");
    							int power=scan.nextInt();
    							reservation.addItem(id,rate,model,c,power);
    							break;
    						case 2://Add Hotel Room
    							System.out.println("Enter ID: ");
    							id=scan.next();
    							System.out.println("Enter rate: ");
    							rate=scan.nextDouble();
    							System.out.println("Enter Hotel Name: ");
    							String name=scan.next();
    							System.out.println("Enter Hotel rank: ");
    							int rank=scan.nextInt();
    							System.out.println("Enter occupancy: ");
    							int o=scan.nextInt();
    							System.out.println("Enter if the room has AC: ");
    							boolean AC=scan.nextBoolean();
    							reservation.addItem(id,rate,name,rank,o,AC);
    							break;
    						case 3://Add Restaurant
    							System.out.println("Enter ID: ");
    							id=scan.next();
    							System.out.println("Enter rate: ");
    							rate=scan.nextDouble();
    							System.out.println("Enter name: ");
    							String n=scan.next();
    							System.out.println("Enter capacity: ");
    							int cap=scan.nextInt();
    							reservation.addItem(id,rate,n,cap);
    							break;
    			           default:
    			        	   System.out.println("Invalid input");
    			        	   break;
    						}	   
    						 System.out.println("Item added succesfully.");
    					
    				         break;
    			 
    			case 2://Search Item
    				  System.out.println("What do you want to search: ");
    				  System.out.printf("\n1.Hotel Rooms\n2.Hotels Rooms within a certain rate\n3.Vehicles\n4.Restaurants within a certain rate\n5.Restaurant\n");
    				  System.out.println("Enter option: ");
    				  int op=scan.nextInt();
    				  switch(op) {
    				  case 1://Hotel rooms
    					  System.out.print("Enter Hotel Name:");
    						 String hotelName=scan.next();
    						 System.out.print("Enter occupancy:");
    						 int occupancy=scan.nextInt();
    						 System.out.print("Has AC:");
    						 boolean Ac=scan.nextBoolean();
    	
    						 for(HotelRoom item:reservation.findRooms(hotelName, occupancy, Ac)) {
    							 System.out.println(item); }
    					  break;
    				  case 2://Hotels Rooms within a certain rate
    	
    						 System.out.print("Enter occupancy:");
    						 occupancy=scan.nextInt();
    						 System.out.print("Has AC:");
    						 boolean AC =scan.nextBoolean();
    						 System.out.print("Enter minimun range:");
    						 double min=scan.nextDouble();
    						 System.out.print("Enter maximun range:");
    						 double max=scan.nextDouble();
    						 for(HotelRoom item:reservation.findRooms(occupancy,AC,min,max)) {
    							 System.out.print(item); }
    					     break;
    				  case 3://Vehicles
    					  System.out.print("Enter capacity:");
    						 int capacity=scan.nextInt();
    						 System.out.print("Enter minimun range:");
    						 double Min=scan.nextInt();
    						 System.out.print("Enter maximun range:");
    						 double Max=scan.nextInt();
    						 for(Vehicle item:reservation.findVehicles(capacity,Min,Max)) {
    							 System.out.print(item); 
    					 }
    					     break;
    				  case 4://Restaurants within a certain rate
    					  System.out.print("Enter No of Guests:");
    						 int guests=scan.nextInt();
    						 System.out.print("Enter minimun range:");
    						 double Mini=scan.nextDouble();
    						 System.out.print("Enter maximun range:");
    						 double Maxi=scan.nextDouble();
    						 for(Restaurant item:reservation.findRestaurants(guests,Mini,Maxi)) {
    							 System.out.print(item); 
    					 }
    					      break;
    				  case 5://Restaurant
    					  System.out.print("Enter Restaurant Name:");
    						 String resturantName=scan.next();
    						 System.out.print("Enter no Of Guest:");
    						 int g=scan.nextInt();
    						 System.out.print("Enter minimun range:");
    						 double M=scan.nextDouble();
    						 System.out.print("Enter maximun range:");
    						 double X=scan.nextDouble();
    						 Restaurant R=reservation.findRestaurant(resturantName,g,M,X);
    						 System.out.println(R);
    					     break;
    				  default:
    					  System.out.println("Invalid input");
    			          break;
    				  
    				  }
    				  break;
    				  
    				
    			case 3://View by Category
    				reservation.viewAll();
    				break;
    			case 4://Reserve
    				System.out.println("Enter id: ");
    				id=scan.next();
    				System.out.println("Enter Customer Name: ");
    				String ReservedBy=scan.next();
    				reservation.Reserve(id, ReservedBy);
    				break;
    			case 5://Reservation over
    				System.out.println("Enter id: ");
    				id=scan.next();
    				reservation.reservationComplete(id);
    				break;
    			case 6://Cancel Reservation
    				System.out.println("Enter id: ");
    				id=scan.next();
    				reservation.cancelReservation(id);
    				break;
    			case 7:
    				break Menu;
    			default:
    				System.out.println("Invalid input");
    				break;
    				
    			}
    	
    		}
	}

}
