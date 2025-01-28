package bookstore;

public class Book {
	public String bookTitle;
	public String bookAuthor;
	public double price;
	public int numOfCopies;
	
	public Book(String bookTitle, String bookAuthor, double price, int numOfCopies)
	{
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.price = price;
		this.numOfCopies = numOfCopies;
	}
	public double getDiscountedPrice(double salePercentage)
	{
		double real = this.price;
		real = real - (real*salePercentage/100);
		return real;
	}
	public void increaseQuantity(int amt)
	{
		this.numOfCopies += amt;
	}
	public void decreaseQuantity(int amt)
	{
		this.numOfCopies -= amt;
	}
	@Override
	public String toString()
	{
		String data = String.format("Name:%s, Author:%s, Price:%.2f,No of Copies: %d",bookTitle,bookAuthor,price,numOfCopies);
		return data;
	}
}
