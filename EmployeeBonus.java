import java.util.Scanner;
public class EmployeeBonus{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the salary of the employee:");
        double salary=sc.nextDouble();
        System.out.println("Enter the years of service:");
        int yearsOfService=sc.nextInt();

        if(yearsOfService>5){
            double bonus=salary*0.05;
            System.out.println("The bonus amount is: "+bonus);
        }else{
            System.out.println("No bonus for employees with less then 5 years of service.");
        }
    }
}