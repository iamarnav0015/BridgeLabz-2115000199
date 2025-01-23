import java.util.Scanner;
public class Countdown{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number to begin count");
        int counter=sc.nextInt();
        while(counter>=1){
            System.out.println("Countdown:"+counter);
            counter--;
        }
        System.out.println("Rocket Launch!");
    }
}