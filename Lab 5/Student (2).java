import java.util.Random;
public class Student {
	 Random rand = new Random();
		String name;
		public String id;
		float creditCom;
		float cgpa;
		public Student(String name, float creditCom , float cgpa) {
		    this.name=name;
		    this.id="" + rand.nextInt(10) + rand.nextInt(10)+ rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
		    this.creditCom=creditCom;
		    this.cgpa=cgpa;
		   }
		public void updateCgpa(float courseCredit, float courseGpa)
		{
	       cgpa=((cgpa*creditCom)+(courseCredit*courseGpa))/(creditCom+courseCredit);
		   creditCom+=courseCredit;
		}
		public float  getCgpa()
		{
		return cgpa;
		}

		public String toString()
		{
			 return String.format("Name:%s, ID:%s, Completed Credits: %.2f, CGPA:%.2f",name,id,creditCom,cgpa);
		}

	}


