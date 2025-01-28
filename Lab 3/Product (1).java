
public class Product {
      String name;
		int id;
		String category;
		double price;
		
		public Product(String name, int id, String category,double price)
		{
			this.name = name;
			this.id = id;
			this.category = category;
			this.price = price;
		}
		
		public void updatePrice(double newPrice)
		{
			this.price = newPrice;
		}
		public double getPrice()
		{
			return this.price;
		}
		public double getDiscountedPrice(double discountPercentage)
		{
			double real_price = this.price;
			real_price = real_price - (real_price*(discountPercentage/100));
			return real_price;
		}
		public void display()
		{
			System.out.println("Name: "+name);
			System.out.println("Id: "+id);
			System.out.println("Category: "+category);
			System.out.println("Price: "+price);
			System.out.println("");
		}
	


}
