package Bank;
import java.util.Random;
public class BankAccount {
 Random rand = new Random();
 String name;
 public String id;
 double balance;
 public BankAccount(String name,double balance) {
 	this.name=name;
 	this.id="" + rand.nextInt(10) + rand.nextInt(10)+ rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
 	this.balance=balance;
 }
 public void deposit(double depAmount)
 {
 	balance=balance+depAmount;
 }
 public void withdraw(double withAmount) {
	 if(balance>=withAmount) 
 	{
 		balance=balance-withAmount;
 	}
 }
 public double getBalance()
 {
 	return balance;
 }
 public String toString() {
	 return String.format("Name:%s, Account Number:%s, Balance:%.2f",name,id,balance);
 }
}
