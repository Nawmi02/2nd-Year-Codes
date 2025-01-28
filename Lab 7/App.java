
package uap.app;
import java .util.ArrayList;
import java.util.Scanner;
import uap.Item;
import uap.ReservationSystem;
public class App {
    public static void main(String[] args) {
    	Scanner scan=new Scanner(System.in);
    	ReservationSystem reservation=new ReservationSystem("My Reservation System");
    	
    	String id;
    	Menu:
    		while(true) {
    			System.out.println("0.Exit");
    			System.out.println("1.View All");
    			System.out.println("2.View Details of an item");
    			System.out.println("3.Add an item");
    			System.out.println("4.Add Feature");
    			System.out.println("5.Add Features");
    			System.out.println("6.Remove Feature");
    			System.out.println("7.Remove Features");
    			System.out.println("8.Reserve an Item");
    			System.out.println("9.Reservation Over");
    			System.out.println("10.Cancel Reservation");
    			
    			System.out.println("Enter Option: ");
    			int option=scan.nextInt();
    			
    			switch(option) {
    			case 0:
    				//Exit
    				break Menu;
    			case 1:
    				//View All
    				reservation.viewAll();
    				break;
    			case 2:
    				//View details of an item
    				System.out.println("Enter ID: ");
    			    id=scan.next();
    				reservation.viewDetails(id);
    				break;
    			case 3:
    				//Add an item
    				System.out.println("Enter item ID: ");
    				id=scan.next();
    				System.out.println("Enter Description: ");
    				String des=scan.next();
    				System.out.println("Enter category: ");
    				String category=scan.next();
    				System.out.println("Enter number of features: ");
    				int num=scan.nextInt();
    				ArrayList<String>features=new ArrayList<>();
    				for(int i=0;i<num;i++) {
    					System.out.println("Enter Features"+" "+(i+1)+":");
    					String f=scan.next();
    					features.add(f);
    				}
    				
    				System.out.println("Enter rate: ");
    				double rate=scan.nextDouble();
    				System.out.println("Enter owner: ");
    				String owner=scan.next();
    				
    				reservation.addItem(id, des, category, rate, features, owner);
    				System.out.println("Item added successfully.");
    				break;
    			case 4:
    				//Add feature
    				System.out.println("Enter ID: ");
    				id=scan.next();
    				System.out.println("Enter feature: ");
    				String fe=scan.next();
    				reservation.addFeature(id,fe);
    				break;
    			case 5:
    				//Add Features
    				System.out.println("Enter item ID for adding new features: ");
    				id=scan.next();
    				System.out.println("Enter number of features: ");
    				int n=scan.nextInt();
    				 ArrayList<String> FeaturesToAdd = new ArrayList<>();
                     for (int i = 0; i < n; i++) 
                     {
                         System.out.println("Enter feature " +" "+ (i+1) + ":");
                         String feature= scan.next();
                         FeaturesToAdd.add(feature);
                     }
    				
    					reservation.addFeatures(id,FeaturesToAdd);
    				
    				
    				break;
    			case 6:
    				//Remove Feature
    				System.out.printf("Enter ID: ");
    				id=scan.next();
    				System.out.println("Enter feature: ");
    				String f=scan.next();
    				reservation.removeFeature(id,f);
    				break;
    			case 7:
    				//Remove Features
    				System.out.printf("Enter item ID for removing features: ");
    				id=scan.next();
    				System.out.println("Enter number of features: ");
    				int nu=scan.nextInt();
    				 ArrayList<String> FeaturesToRemove = new ArrayList<>();
                     for (int i=0;i<nu;i++) 
                     {
                         System.out.println("Enter feature " + " "+ (i+1) + ":");
                         String feature= scan.next();
                         FeaturesToRemove.add(feature);
                     }
    				reservation.removeFeatures(id,FeaturesToRemove);
    				
    				break;
    			case 8:
    				//Reserve an item
    				System.out.printf("Enter ID: ");
    				id=scan.next();
    				System.out.printf("Customer name:");
    				String C_Name=scan.next();
    				reservation.reserveItem(id, C_Name);
    				
    				break;
    			case 9:
    				//Reservation Over
    				System.out.printf("Enter ID: ");
    				id=scan.next();
    				reservation.reservationComplete(id);
    				break;
    			case 10:
    				//Cancel Reservation
    				System.out.printf("Enter ID: ");
    				id=scan.next();
    				reservation.cancelReservation(id);
    				break;
    			default:
    				System.out.println("Invalid input");
    				break;
    			}
    		  
    			
    		}
    }
    }

