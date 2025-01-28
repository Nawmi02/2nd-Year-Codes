import java.util.Scanner;
    public class Prime{
         public static void main(String[] args){
             Scanner scan=new Scanner(System.in);
             int i,num,count=0;
             System.out.printf("Enter a number: ");
             num=scan.nextInt();
             scan.close();
             for(i=2;i<=num/2;i++){
             if(num%i==0){count++;}
 	}
        if(count==0){System.out.printf("Prime");}
         else{System.out.printf("Not Prime");} 
}
}  