import java.util.Scanner;
public class TestException {
	
		public static void main(String[] args ) {
			Scanner scan=new Scanner(System.in);
			int i;
			float p;
			boolean a;
			for(i=0;i<10;i++) {
				System.out.println("Enter Percentage: ");
				p=scan.nextFloat();
				System.out.println("Enter if attended final exam: ");
				a=scan.nextBoolean();
			try{
				checkDataForStudent(p,a);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		}
		
	    public static void checkDataForStudent(float percentage , boolean attendance ) throws Exception{
	    	if(percentage<70) {
	    		throw new Exception("“Attendance should be 70 or more to be eligible for the final exam.");
	    	}
	    	else if(!attendance) {
	    		System.out.println("Failed");
	    	}
	    	else {
	    		System.out.println("Eligible for Final Exam");
	    	}
	    }
	}




