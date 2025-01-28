
import java.util.Scanner;

public class CheckDataForStudent {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		for(int i=0;i<10;i++)
		{
			System.out.println("Please Enter your Attendance : ");
			double attendance = scan.nextDouble();
			System.out.println("Attended Final Xm or Not : ");
			boolean hasAttendedFinalExam = scan.nextBoolean();
			try {
				checkDataForStudent(attendance,hasAttendedFinalExam);
			}catch(LowAttendanceException e) {
				
				System.out.println(e.getMessage());
				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		
		scan.close();
	}
	
	public static void checkDataForStudent(double attendance, boolean hasAttendedFinalExam) throws LowAttendanceException, Exception
	{
		if(attendance < 70)
		{
			throw new LowAttendanceException(70);
		}
		else if(hasAttendedFinalExam == false)
		{
			throw new Exception("Failed due to absence in Final Exam");
		}
		else
		{
			System.out.println("Eligible for Final Exam\n");
		}
	}
}
