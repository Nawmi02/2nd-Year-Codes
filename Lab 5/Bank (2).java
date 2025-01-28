package Bank.app;
import Bank.BankAccount;
import java.util.Scanner;

public class Bank {
	static BankAccount[] accs = new BankAccount[10];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useDelimiter("\r\n");
		String ID;
		int idx;
		Menu:
		while(true) {
			System.out.printf("Menu\n1.Create Account\n2Deposit\n3.Withdraw\n4.Get Balance\n5.View an Account\n6.View all\n0.Exit\n");
    		System.out.println("Enter Option: ");
    		int option=scan.nextInt();
    		switch(option) {
    		case 1:
    			for(int i=0; i<accs.length; i++) {
    				if(accs[i]==null) {
    					System.out.println("Enter name:");
    					String name=scan.next();
    					System.out.println("Enter balance:");
    					double balance=scan.nextDouble();
    					accs[i]=new BankAccount(name,balance);
    					break;
    				}
    			}
    			break;
    		case 2:
    			System.out.println("Enter ID: ");
    			ID=scan.next();
    			idx=findAccount(ID);
    			if(idx==-1) {
    				System.out.println("Account not found");
    				break;}
    			else {
    			System.out.println("Enter the amount You want to deposit: ");
    			double depAmount=scan.nextDouble();
    			accs[idx].deposit(depAmount);
    			}
    			break;
    		case 3:
    			System.out.println("Enter ID: ");
    			ID=scan.next();
    		   idx=findAccount(ID);
    			if(idx==-1) {
    			System.out.println("Account not found");
    			break;}
    			else {
    			System.out.println("Enter the amount You want to withdraw: ");
    			double withAmount=scan.nextDouble();
    			accs[idx].withdraw(withAmount);
    			}
    			break;
    		case 4:
    			System.out.println("Enter ID: ");
    			ID=scan.next();
    			idx=findAccount(ID);
    			if(idx==-1) {
    			System.out.println("Account not found");
    			break;}
    			else {
    				double Balance=accs[idx].getBalance();
    				System.out.println("Balance: "+Balance);
    			}
    			break;
    		case 5:
    			System.out.println("Enter ID: ");
    			ID=scan.next();
    		   idx=findAccount(ID);
    			if(idx==-1) {
    			System.out.println("Account not found");
    			break;}
    			else {
    				System.out.println(accs[idx]);
    			}
    			
    			break;
    		case 6:
    			for(BankAccount B:accs) {
    				if(B==null) {
    					break;
    				}
    			System.out.println(B);
    				
    			}
    			break;
    		case 0:
    			break Menu;
    		
    		}
    		
		}
	}
	public static int findAccount(String ID) {
		for(int i=0;i<accs.length;i++) {
			if (accs[i] ==null)
				break;
			if(accs[i].id.equals(ID)) {
				return i;
			}
		}
		
		return -1;
	}
}




