package uap;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable{
	private String name, id;
	private  int age;
	private boolean isAdmin;
	
	
	public User(String name, int age, boolean isAdmin) {
		super();
		this.name = name;
		String tId = String. format("%04d", new Random().nextInt(10000));
		if(isAdmin)
			this.id = "11-"+tId;
		else
			this.id = "22-" + tId;
		this.age = age;
		this.isAdmin = isAdmin;
	}
	
	
	
	public String getName() {
		return name;
	}



	public String getId() {
		return id;
	}



	public int getAge() {
		return age;
	}



	public boolean isAdmin() {
		return isAdmin;
	}



	@Override
	public String toString() {
		if (isAdmin)
			return String.format("Admin- id:%s, name:%s, age:%d", id, name, age);
		else
			return String.format("Customer- id:%s, name:%s, age:%d", id, name, age);
	}

}
