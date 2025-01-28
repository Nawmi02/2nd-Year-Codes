
public class Student {
	String name;
	int id;
	float creditCom;
	float cgpa;
	public Student(String name , int id, float creditCom , float cgpa) {
	    this.name=name;
	    this.id=id;
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

	public void display()
	{
	System.out.printf("Name:%s\nID:%s\nCompleted Course:%.2f\n,CGPA:%.2f\n",name,id,creditCom,cgpa);
	}

}
