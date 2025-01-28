package uap;

public class Vehicle extends Item {
	private String model;
	private int capacity;
	private double enginePower;
	
	public Vehicle(String model,int capacity,double enginePower,String id,double rate) {
		super(id,rate);
		this.model=model;
		this.capacity=capacity;
		this.enginePower=enginePower;
	}
	
	public String getModel() {
		return this.model;
	}
	public int getCapacity() {
		return this.capacity;
	}
	public double getEnginePower() {
		return this.enginePower;
	}
	
	@Override
	public double getPayment(int quantity) {
		return getRate()*quantity;
	}
	@Override
	public String toString() {
		return String.format("ID: %s, Rate: %.2f, Model: %s, Capacity: %d, Engine power: %.2f, Availibility: %b, Customer: %s",getId(),getRate(),model,capacity,enginePower,getIsAvailable(),getReservedBy());
	}
	

}