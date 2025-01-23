import java.util.Scanner;
public class NaturalSum2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int n=sc.nextInt();
        if(n<=0){
            System.out.println("Please enter a valid natural number (positive integer).");
            return;
        }
        int formulaSum=n*(n+1)/2;
        int loopSum=0;
        int counter=1;
        while(counter<=n){
            loopSum+=counter;
            counter++;
        }
        System.out.println("Sum using the formula: "+formulaSum);
        System.out.println("Sum using the while loop: "+loopSum);
        if(formulaSum==loopSum){
            System.out.println("Both results are correct!");
        }else{
            System.out.println("There seems to be an issue with the calculations.");
        }
    }
}