import java.util.Scanner;
public class Countdown2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number to begin count");
        int counter=sc.nextInt();
        for(;counter>=1;counter--){
            System.out.println("Countdown:"+counter);
        }
        System.out.println("Rocket Launch!");
    }
}