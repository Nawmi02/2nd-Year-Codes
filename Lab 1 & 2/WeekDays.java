import java.util.Scanner;
    public class WeekDays{
         public static void main(String[] args){
             Scanner scan=new Scanner(System.in);
             int num;
             System.out.printf("Enter a number: ");
             num=scan.nextInt();
             scan.close();
             switch(num%7) {
   case 0:
    System.out.println("Saturday");
    break;
  case 1:
    System.out.println("Sunday");
    break;
  case 2:
    System.out.println("Monday");
    break;
  case 3:
    System.out.println("Tuesday");
    break;
  case 4:
    System.out.println("Wednesday");
    break;
  case 5:
    System.out.println("Thursday");
    break;
  case 6:
    System.out.println("Friday");
    break;
}
             
}
}  