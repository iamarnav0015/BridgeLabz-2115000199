import java.util.Scanner;
public class EmployeeBonus{
    public static void main(String[] args){
        double[] salaries=new double[10];
        double[] yearsOfService=new double[10];
        double[] bonuses=new double[10];
        double[] newSalaries=new double[10];
        double totalBonus=0,totalOldSalary=0,totalNewSalary=0;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("Enter salary for employee "+(i+1)+":");
            salaries[i]=sc.nextDouble();
            System.out.println("Enter years of service for employee "+(i+1)+":");
            yearsOfService[i]=sc.nextDouble();
            if(salaries[i]<=0||yearsOfService[i]<0){
                System.out.println("Invalid input, please try again.");
                i--;
            }
        }
        for(int i=0;i<10;i++){
            if(yearsOfService[i]>5) bonuses[i]=salaries[i]*0.05;
            else bonuses[i]=salaries[i]*0.02;
            newSalaries[i]=salaries[i]+bonuses[i];
            totalBonus+=bonuses[i];
            totalOldSalary+=salaries[i];
            totalNewSalary+=newSalaries[i];
        }
        for(int i=0;i<10;i++){
            System.out.println("Employee "+(i+1)+":");
            System.out.println("Old Salary: "+salaries[i]);
            System.out.println("Years of Service: "+yearsOfService[i]);
            System.out.println("Bonus: "+bonuses[i]);
            System.out.println("New Salary: "+newSalaries[i]);
        }
        System.out.println("Total Bonus Payout: "+totalBonus);
        System.out.println("Total Old Salary of all employees: "+totalOldSalary);
        System.out.println("Total New Salary of all employees: "+totalNewSalary);
    }
}
