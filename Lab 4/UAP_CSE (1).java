import java.util.Scanner;
import javax.swing.JOptionPane;

public class UAP_CSE {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name=JOptionPane.showInputDialog("Enter name: ");
		String id=JOptionPane.showInputDialog("Enter ID : ");
		System.out.println("Enter completed credit & cgpa: ");
		float creditCom=scan.nextFloat();
		float cgpa=scan.nextFloat();
		Student S=new Student(name,id,creditCom,cgpa);
		Menu:
			while(true) {
				System.out.printf("Menu\n1.Update CGPA\n2.Show CGPA\n3.Display\n");
        		System.out.println("Enter Option: ");
        		int option=scan.nextInt();
                switch(option)
                {
                case 1:
                	System.out.println("Enter course credit & cgpa: ");
                	float credit=scan.nextFloat();
            		float cg=scan.nextFloat();
                    S.updateCgpa(credit,cg);
                    break;
                case 2:
                	float CGPA=S.getCgpa();
                	System.out.printf("CGPA:%.2f ",CGPA);
                	break;
                case 3:
                	S.display();
                case 0:
                	break Menu;
        		default:
        			System.out.println("Invalid input");
             
}
}
}
}