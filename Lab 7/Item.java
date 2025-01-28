package uap;
import java.util.ArrayList;

public class Item {
	private String id;
	private String description;
	private String category;
	private ArrayList<String> features = new ArrayList<>();
	private double rate;
	private boolean isAvailable;
	private String owner;
	private String personReserved;
	
	public Item(String id,String description,String category,ArrayList<String> features,double rate,String owner) {
		this.id=id;
		this.description=description;
		this.category=category;
		this.features=features;
		this.rate=rate;
		this.owner=owner;
		this.isAvailable=true;
	}
	public void addFeature(String feature) {
		
		this.features.add(feature);
	}
	public void removeFeature(String feature) {
		this.features.remove(feature);
	}
	public void addFeatures(ArrayList<String>features) {
		this.features.addAll( features);
	}
	public void removeFeatures(ArrayList<String>features) {
		this.features.removeAll( features);
	}
	//Getter methods
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getCategory() {
		return category;
	}
	public ArrayList<String> getFeatures() {
		return features;
	}
	public double getRate() {
		return rate;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public String getOwner() {
		return owner;
	}
	public String getPersonReserved() {
		return personReserved;
	}
	//Setter methods
	public void setRate(double rate) {
		this.rate=rate;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable= isAvailable;
	}
	public void setPersonReserved(String personReserved) {
		this.personReserved=personReserved;
	}
	public void reserveItem(String personReserved) {
		setIsAvailable(false);
		setPersonReserved(personReserved);
	}
	public void reservationOver() {
		setIsAvailable(true);
	   setPersonReserved(null);
	}
	public void cancelReservation() {
		setIsAvailable(true);
		setPersonReserved(null);
	}
	@Override
	public String toString() {
		String data = String.format("ID:%s, Description:%s, Category:%s, Features:%s, Rate:%f, Available:%b, Owner:%s, Customer:%s",id,description,category,features,rate,isAvailable,owner,personReserved);
	    return data;
	}
}
