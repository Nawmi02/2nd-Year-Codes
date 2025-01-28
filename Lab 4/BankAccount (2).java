
public class BankAccount {
	
	    String name;
	    String id;
	    double balance;
	    
	    public BankAccount(String name, String id, double balance) {
	    	this.name=name;
	    	this.id=id;
	    	this.balance=balance;
	    }
	    public void deposit(double depAmount)
	    {
	    	balance=balance+depAmount;
	    }
	    public void withdraw(double withAmount)
	    {
	    	if(balance>=withAmount) 
	    	{
	    		balance=balance-withAmount;
	    	}
	    }
	    public double getBalance()
	    {
	    	return balance;
	    }
	    public void display()
	    {
	    	System.out.printf("Name:%s\nAccount Number:%s\nBalance:%.2f\n",name,id,balance);
	    }
	    
}

