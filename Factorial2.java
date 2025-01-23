import java.util.Scanner;
public class Factorial2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int n=sc.nextInt();
        if(n<0){
            System.out.println("Please enter a positive integer.");
            return;
        }
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial*=i;
        }
        System.out.println("Factorial: "+factorial);
    }
}