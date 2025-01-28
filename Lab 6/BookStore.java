package bookstore;

import java.util.ArrayList;

public class BookStore {
	String name;
	double totalSale;
	ArrayList<Book> books = new ArrayList<>();
	
	public BookStore(String name) {
		this.name = name;
	}

	public void sell(String bookTitle, String bookAuthor, int noOfCopies, double price)
	{
		int idx = findBook(bookTitle,bookAuthor);
		if(idx>=0)
		{
			books.get(idx).numOfCopies--;
			totalSale++;
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	
	public void order(String bookTitle, String bookAuthor, double price, int noOfCopies)
	{
		int idx = findBook(bookTitle,bookAuthor);
		if(idx>=0)
		{
			books.get(idx).numOfCopies++;
		}
		else
		{
			Book book = new Book(bookTitle,bookAuthor,price,noOfCopies);
			books.add(book);
		}
	}
	
	public double getTotalSale()
	{
		return totalSale;
	}
	public void getDiscountedPrice(String bookTitle, String bookAuthor, double salePercentage)
	{
		int idx = findBook(bookTitle,bookAuthor);
		if(idx>=0)
		{
			books.get(idx).getDiscountedPrice(salePercentage);
		}
		else
		{
			System.out.println("Not FOund");
		}
	}
	public void display()
	{
		for(int i=0;i<books.size();i++)
		{
			Book b = books.get(i);
			System.out.println("Book Title : "+b.bookTitle);
			System.out.println("Book Author : "+b.bookAuthor);
			System.out.println("Book Price : "+b.price);
			System.out.println("Book No of Copies : "+b.numOfCopies);
			System.out.println();
			
		}
	}
	
	
	
	public int findBook(String title,String author)
	{
		int i;
		for( i=0;i<books.size();i++)
		{
			if(books.get(i)==null)
			{
				break;
			}
			else {
			if(books.get(i).bookTitle.equals(title) && books.get(i).bookAuthor.equals(author))
			{
				return i;
			}
			}
		}
		return -1;
		
	}
}
