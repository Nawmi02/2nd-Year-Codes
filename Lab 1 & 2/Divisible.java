import java.util.Scanner;
    public class Divisible{
           public static void main(String[] args){
               Scanner input=new Scanner(System.in);
	       int i;
	       int[] a=new int[10];
              System.out.printf("Enter numbers: ");
              for(i=0;i<10;i++)
	      {
	         a[i]=input.nextInt();
	      }
	      for(i=0;i<10;i++)
	      {
	         if(a[i]%3==0 || a[i]%5==0){
                     if(a[i]%3==0 && a[i]%5==0){continue;}
		     else{System.out.printf("%d ",a[i]);}
	      }
	     }
}
}
