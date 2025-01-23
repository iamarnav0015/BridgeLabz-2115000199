import java.util.Scanner;
public class OddEven{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int number=sc.nextInt();
        if(number<=0){
            System.out.println("Please enter a valid natural number.");
            return;
        }
        for(int i=1;i<=number;i++){
            if(i%2==0){
                System.out.println(i+" is even");
            }else{
                System.out.println(i+" is odd");
            }
        }
    }
}