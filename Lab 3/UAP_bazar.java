import java.util.Scanner;
public class UAP_bazar{ 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String name = scan.next();
		System.out.print("Enter Id: ");
		int id = scan.nextInt();
		System.out.println("Enter Category: ");
		String category = scan.next();
		System.out.println("Enter Price: ");
		double price = scan.nextDouble();
		
		Product p = new Product(name,id,category,price);
		System.out.printf("Price: %f ",p.price);
		
		System.out.print("Enter new price: ");
		double new_Price = scan.nextDouble();
		p.updatePrice(new_Price);
		 
	    p.display();
		
		System.out.print("Enter Discount Percent: ");
		double discountPercentage = scan.nextDouble();
		double disprc = p.getDiscountedPrice(discountPercentage);
		System.out.println("Discount Price : "+disprc);
	
		
	}
}
