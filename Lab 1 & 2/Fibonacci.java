import java.util.Scanner;
    public class Fibonacci{
         public static void main(String[] args){
            Scanner scan=new Scanner(System.in);
            int i,n,F=0,S=1,next;
	    System.out.printf("Enter the value of n: ");
            n=scan.nextInt();
	    for(i=1;i<=n;i++)
            {
		if(i<=1){next=i;}
              else{  
                    next=F+S;
                    F=S;
                    S=next;
	     }
             System.out.printf("%d ",next);

            }


}
}