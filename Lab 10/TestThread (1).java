import java.util.Scanner;
public class TestThread {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println(" Enter minimum value of range for Even Thread: "); 
        int evenMin = scan.nextInt();
        System.out.println(" Enter maximum value of range for Even Thread: "); 
        int evenMax =scan.nextInt() ;
        System.out.println(" Enter minimum value of range for Odd Thread: "); 
        int oddMin = scan.nextInt();
        System.out.println(" Enter maximum value of range for Odd Thread: "); 
        int oddMax = scan.nextInt();

        Thread evenThread = new Thread(new Job(true, evenMin, evenMax));
        Thread oddThread = new Thread(new Job(false, oddMin, oddMax));

        evenThread.start();
        oddThread.start();
    }
	
}
