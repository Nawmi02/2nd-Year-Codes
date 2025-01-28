package uap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataHandler {
	private static String fileName="data.txt";

	public static void saveData(ReservationSystem reservationSystem) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(reservationSystem);
	}
	
	public static ReservationSystem loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		return (ReservationSystem)ois.readObject();
	}

}
