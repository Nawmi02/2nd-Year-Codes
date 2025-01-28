import java.util.Scanner;
    public class MaxMin{
           public static void main(String[] args){
               Scanner input=new Scanner(System.in);
		int n,i,max,min;
                System.out.printf("Enter Array Size: ");
		n=input.nextInt();
                int[] arr=new int[n];
		 System.out.printf("Enter Array Elements: ");
                 for(i=0;i<n;i++)
	      {
	         arr[i]=input.nextInt();
	      }
	      max=arr[0];
	      min=arr[0];
               for(i=0;i<n;i++)
	      {
	         if(max<arr[i]){max=arr[i];}
	         if(min>arr[i]){min=arr[i];}
	      }
	      System.out.printf("Max:%d\n",max);
               System.out.printf("Min:%d",min);
}
}
                 