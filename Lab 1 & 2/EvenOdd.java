import java.util.Scanner;
    public class EvenOdd{
           public static void main(String[] args){
               Scanner scan=new Scanner(System.in);
        int num;
         System.out.printf("Enter a number: ");
        num=scan.nextInt();
        scan.close();
        if(num%2==0)
            {System.out.println("Even");}
         else{System.out.printf("Odd");}
         
}
}

