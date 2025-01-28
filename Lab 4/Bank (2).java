import javax.swing.JOptionPane;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name=JOptionPane.showInputDialog("Enter name: ");
		String id=JOptionPane.showInputDialog("Enter ID : ");
        String blnc=JOptionPane.showInputDialog("Enter Balance: ");
        double balance=Double.parseDouble(blnc);
        BankAccount B= new BankAccount(name,id,balance);
        Menu:
        	while(true) {
        		System.out.printf("Menu\n1.Deposit\n2.Withdraw\n3.Get Balance\n4.Display\n");
        		System.out.println("Enter Option: ");
        		int option=scan.nextInt();
        		switch(option) {
        		case 1:
        			System.out.println("Enter amount you want to deposit: ");
        			double depAmount=scan.nextDouble();
        			B.deposit(depAmount);
        		    break;
        		case 2:
        			System.out.println("Enter amount you want to withdraw: ");
        			double withAmount=scan.nextDouble();
        			B.withdraw(withAmount);
        		    break;
        		case 3:
        			double newBalance=B.getBalance();
        			System.out.printf("Balance:%f\n",newBalance);
        		    break;
        		case 4:
        			B.display();
        		case 0:
        			break Menu;
        	}
            
	}

}
}
