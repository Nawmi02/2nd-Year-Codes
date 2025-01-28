import javax.swing.JOptionPane;
import java.util.Scanner;

public class UAP_Bazar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name=JOptionPane.showInputDialog("Enter name: ");
		String id=JOptionPane.showInputDialog("Enter ID : ");
		String category=JOptionPane.showInputDialog("Enter category of the product : ");
		System.out.println("Enter Price: ");
		double price=scan.nextDouble();
		Product p=new Product(name,id,category,price);
		
		Menu:
			while(true) {
				System.out.printf("Menu\n1.Update Price\n2.Show discounted price\n3.Display\n");
        		System.out.println("Enter Option: ");
        		int option=scan.nextInt();
        		switch(option) {
        		case 1:
        			System.out.println("Enter new price: ");
        			double new_Price=scan.nextDouble();
        			p.updatePrice(new_Price);
        			break;
        		case 2:
        			System.out.println("Enter discount percentage: ");
        			double discountPercentage=scan.nextDouble();
        			double dis_price= p.getDiscountedPrice(discountPercentage);
        			System.out.println("The price after discount: "+dis_price);
        			break;
        		case 3:
        			p.display();
        			break;
        		case 0:
        			break Menu;
        		default:
        			System.out.println("Invalid input");
        		}
			}

	}

}
