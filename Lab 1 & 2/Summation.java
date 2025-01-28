import java.util.Scanner;
    public class Summation{
         public static void main(String[] args){
             Scanner scan=new Scanner(System.in);
             int num,digit,sum=0;
             System.out.printf("Enter a number: ");
             num=scan.nextInt();
	     while(num>0)
	    {
		digit=num%10;
		if(digit%2==0){sum+=digit;}
		num=num/10;
	     }
          System.out.print(sum);
}
}