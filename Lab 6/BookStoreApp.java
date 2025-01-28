package bookapp;

import java.util.Scanner;

import bookstore.BookStore;

public class BookStoreApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useDelimiter("\r\n");
		BookStore bookstore = new BookStore("MyBookStore");
		Menu:
		while(true)
		{
			
		    System.out.println("1. Display All Books");
			System.out.println("2. Display Specific Book");
			System.out.println("3. Order Book/Books");
			System.out.println("4. Sell Book/Books");
			System.out.println("5. View Discounted Price");
			System.out.println("6. Display the TotalSale");
			System.out.println("0. Exit....");
			
			System.out.println("Enter Option: ");
			int op = scan.nextInt();
			
			switch(op)
			{
			case 0: // break
				break Menu;
			case 1: // Display all Books
				bookstore.display();
				break;
			case 2: // Display Specific Book
				break;
			case 3: // Order Book/Books
				System.out.print("Enter book name: ");
                String name = scan.next();
                System.out.print("Enter Author: ");
                String author = scan.next();
                System.out.print("Enter price: ");
                double price = scan.nextDouble();
                System.out.print("Enter no of copies: ");
                int noOfcopies = scan.nextInt();
               
               bookstore.order(name,author,price, noOfcopies);
                break;
			case 4: //Sell
				System.out.print("Enter book name: ");
                String Name = scan.next();
                System.out.print("Enter Author: ");
                String Author = scan.next();
                System.out.print("Enter price: ");
                double p = scan.nextDouble();
                System.out.print("Enter no of copies: ");
                int copies = scan.nextInt();
                bookstore.sell(Name, Author,copies, p);
               
				break;
			case 5:// View Discounted Price
			     System.out.print("Enter book name: ");
                 String n = scan.next();
                 System.out.print("Enter Author: ");
                 String A = scan.next();
	             System.out.println("Enter sale percentage: ");
		        double discount=scan.nextDouble();
		        bookstore.getDiscountedPrice(n,A,discount);
		        
				break;
			case 6://total sale
				double t=bookstore.getTotalSale();
				System.out.println("Sale"+t);
				break;
			}
			
		}
		

	}

}
