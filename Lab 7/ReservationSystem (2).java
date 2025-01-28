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
	public void addItem(String id, String description, String category,double rate,ArrayList<String> features,String owner) {
		item=new Item(id,description,category,features,rate,owner);
		items.add(item);
	}
	public int findItem(String id){
		int i;
		for(i=0;i<items.size();i++) {
			if(items.get(i)==null)
			{
				break;
			}
			else {
				if(items.get(i).getId().equals(id)) {
					return i;
				}
			}
		}
		return -1;
	}
	public void addFeature(String id,String feature) {
	 int idx= findItem(id);
	  if(idx>=0) {
		  Item i=items.get(idx);
		 i.addFeature(feature);
	  }
	  else {
		  System.out.println("ID not found");
	  }
	  
  }
	public void removeFeature(String id, String feature) {
		int idx= findItem(id);
		  if(idx>=0) {
			  Item i=items.get(idx);
			 i.removeFeature(feature);
		  }
		  else {
			  System.out.println("ID not found");
		  }
		  
	}
	public void addFeatures(String id,ArrayList<String> features) {
		int idx= findItem(id);
		  if(idx>=0) {
			  Item i=items.get(idx);
			 i.addFeatures(features);
		  }
		  else {
			  System.out.println("ID not found");
		  }
	}
	public void removeFeatures(String id,ArrayList<String> features) {
		int idx= findItem(id);
		  if(idx>=0) {
			  Item i=items.get(idx);
			 i.removeFeatures(features);
		  }
		  else {
			  System.out.println("ID not found");
		  }
	}
	public void reserveItem(String id, String personReserved) {
		int idx= findItem(id);
		  if(idx>=0) {
			  Item i=items.get(idx);
			 i.reserveItem(personReserved);
		  }
		  else {
			  System.out.println("ID not found");
		  }
	}
	public void reservationComplete(String id) {
		int idx= findItem(id);
		  if(idx>=0) {
			  Item i=items.get(idx);
			 i.reservationOver();
		  }
		  else {
			  System.out.println("ID not found");
		  }
	}
	public void cancelReservation(String id) {
		int idx= findItem(id);
		  if(idx>=0) {
			  Item i=items.get(idx);
			 i.cancelReservation();
		  }
		  else {
			  System.out.println("ID not found");
		  }
	}
	public ArrayList<Item> getItems(){
		return items;
	}
	public void viewAll() {
		
		for(Item item:items) {
			System.out.println(item);
		}
	}
	public void viewDetails(String id) {
		int idx= findItem(id);
		  if(idx>=0) {
			  Item i=items.get(idx);
			 System.out.println(i);
		  }
		  else {
			  System.out.println("ID not found");
		  }
	}
	
	
}
