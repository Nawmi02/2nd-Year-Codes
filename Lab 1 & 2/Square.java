import java.util.Scanner;
public class Square{
      public static void main(String[] args){
               Scanner scan=new Scanner(System.in);
               
           int a,Square;
       System.out.printf("Enter a number: ");
       a=scan.nextInt();
       Square=a*a;
       scan.close();
      System.out.print(Square);
}
}