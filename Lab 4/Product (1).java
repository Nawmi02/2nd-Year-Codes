
public class Product {
     String name;
     String id;
     String category;
     double price;
     
 	public Product(String name, String id, String category,double price)
	{
		this.name = name;
		this.id = id;
		this.category = category;
		this.price = price;
	}
 	
 	public void updatePrice(double new_Price) {
 		this.price=new_Price;
 	}
 	
 	public double getPrice() {
 		return this.price;
 	}
 	
 	public double getDiscountedPrice(double discountPercentage) {
 		double n_price=this.price;
 		n_price=n_price-(n_price*(discountPercentage/100));
 		return n_price;
 	}
 	
 	public void display() {
 		System.out.printf("\nName: %s\nID: %s\nCategory: %s\nPrice: %.2f\n",name,id,category,price);
 	}
}
