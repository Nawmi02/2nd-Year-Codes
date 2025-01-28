import java.util.Scanner;
    public class Factorial{
	  static int fact(int n)
           { if(n==0){return 1;}
             else{return n*fact(n-1);}
            }
           
           public static void main(String[] args){
               Scanner scan=new Scanner(System.in);
           int n,ans;
	   System.out.printf("Enter a number: ");
           n=scan.nextInt();   
	  ans=fact(n);
            System.out.println(ans);
	}

}