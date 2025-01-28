package uap;

public class Vehicle extends Item {
	private String model;
	private int capacity;
	private float enginePower;
	
	public Vehicle(String model, int capacity, float enginePower, double rate) {
		super(rate);
		this.model = model;
		this.capacity = capacity;
		this.enginePower = enginePower;
		prependWithId("v-");
	}

	public String getModel() {
		return model;
	}

	public int getCapacity() {
		return capacity;
	}

	public float getEnginePower() {
		return enginePower;
	}

	@Override
	public String toString() {
		String status = isAvailable()? "Available":"Reserved";
		return "Vehicle ("+status+") [id="+getId()+"model=" + model + ", capacity=" + capacity + ", enginePower=" + enginePower + "]";
	}

	@Override
	public String info() {
		return String.format("Vehicle: Model-%s, No Of Passenger-%d, Engine-%.1f", model, capacity, enginePower);
	}

	
}
