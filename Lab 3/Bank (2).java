
public class Bank {

	public static void main(String[] args) {
		BankAccount a = new BankAccount("Nawmi","22201202",10000.00);
		a.withdraw(2000);
		a.display();
		a.deposit(5000);
	  double newBalance =  a.getBalance();
	  System.out.printf("NewBalance=%.2f",newBalance);
	    
	   }

}
