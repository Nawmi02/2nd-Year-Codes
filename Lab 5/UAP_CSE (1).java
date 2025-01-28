import java.util.Scanner;

public class UAP_CSE {
	static Student[] sts = new Student[10];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useDelimiter("\r\n");
		String ID;
		int idx;
		Menu:
			while(true) {
				System.out.printf("\nMenu\n1.Create Account\n2Update CGPA\n3.View CGPA\n4.View details of a Student\n5.View all\n0.Exit\n");
	    		System.out.println("Enter Option: ");
	    		int option=scan.nextInt();
	    		switch(option) {
	    		case 1:
	    			for(int i=0; i<sts.length; i++) {
	    				if(sts[i]==null) {
	    					System.out.println("Enter name:");
	    					String name=scan.next();
	    					System.out.println("Enter Completed Credits:");
	    					float creditCom=scan.nextFloat();
	    					System.out.println("Enter CGPA:");
	    					float cgpa=scan.nextFloat();
	    					sts[i]=new Student(name,creditCom,cgpa);
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
	    				System.out.println("Enter Course Credit: ");
	    				float courseCredit=scan.nextFloat();
	    				System.out.println("Enter Course GPA: ");
	    				float gpa=scan.nextFloat();
	    				sts[idx].updateCgpa(courseCredit, gpa);
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
	    				float CGPA=sts[idx].getCgpa();
	    				System.out.printf("CGPA: %.2f",CGPA);
	    			}
	    			
	    			break;
	    		case 4:
	    			System.out.println("Enter ID: ");
	    			ID=scan.next();
	    		   idx=findAccount(ID);
	    			if(idx==-1) {
	    			System.out.println("Student not found");
	    			break;}
	    			else {
	    				System.out.println(sts[idx]);
	    			}
	    			
	    			break;
	    		case 5:
	    			for(Student S:sts) {
	    				if(S==null) {
	    					break;
	    				}
	    			System.out.println(S);
	    				
	    			}
	    			break;
	    		case 0:
	    			break Menu;
	    		}
				
			}
		
}
	public static int findAccount(String ID) {
		for(int i=0;i<sts.length;i++) {
			if (sts[i] ==null)
				break;
			if(sts[i].id.equals(ID)) {
				return i;
			}
		}
		
		return -1;
	}
}


