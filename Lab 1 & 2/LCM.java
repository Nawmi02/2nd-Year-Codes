import java.util.Scanner;
    public class LCM{
           public static void main(String[] args){
               Scanner scan=new Scanner(System.in);
        int num1,num2,x,y,temp,LCM;
         System.out.printf("Enter Two numbers: ");
             num1=scan.nextInt();
	     num2=scan.nextInt();
	     x=num1;
	     y=num2;
	    while(y!=0)
	    {
	       temp=y;
               y=x%y;
               x=temp;
             }
	    LCM=(num1*num2)/x;
            System.out.print(LCM);
}
}