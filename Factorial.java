import java.util.Scanner;
public class Factorial{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int n=sc.nextInt();
        if(n<0){
            System.out.println("Please enter a positive integer.");
            return;
        }
        int factorial=1;
        while(n>0){
            factorial*=n;
            n--;
        }
        System.out.println("Factorial: "+factorial);
    }
}