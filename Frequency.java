import java.util.Scanner;
public class Frequency{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int number=sc.nextInt();
        int count=0;
        int temp=number;
        while(temp!=0){
            temp/=10;
            count++;
        }
        int[] digits=new int[count];
        temp=number;
        for(int i=0;i<count;i++){
            digits[i]=temp%10;
            temp/=10;
        }
        int[] frequency=new int[10];
        for(int i=0;i<count;i++){
            frequency[digits[i]]++;
        }
        System.out.println("Frequency of each digit:");
        for(int i=0;i<10;i++){
            if(frequency[i]>0){
                System.out.println(i+": "+frequency[i]);
            }
        }
    }
}
