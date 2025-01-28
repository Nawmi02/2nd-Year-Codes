public class MaxMin{
     public static void main(String[] args){
            int a=6,b=9,c=4;
          int max,min;
         if(a>b){max=a;min=b;}
         else{max=b;min=a;}
        if(c>max){max=c;}
        if(c<min){min=c;}
     System.out.printf("%s%d\n","Max:",max);
     System.out.printf("%s%d\n","Min:",min);

}


}