import java.util.Scanner;
public class Result{
    public static char calculateGrade(double percentage){
        if(percentage>=80)return 'A';
        else if(percentage>=70)return 'B';
        else if(percentage>=60)return 'C';
        else if(percentage>=50)return 'D';
        else if(percentage>=40)return 'E';
        else return 'R';
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int numStudents=sc.nextInt();
        int[] physicsMarks=new int[numStudents];
        int[] chemistryMarks=new int[numStudents];
        int[] mathsMarks=new int[numStudents];
        double[] percentages=new double[numStudents];
        char[] grades=new char[numStudents];
        for(int i=0;i<numStudents;i++){
            System.out.println("\nEnter marks for student "+(i+1)+":");
            while(true){
                System.out.print("Physics (0-100): ");
                physicsMarks[i]=sc.nextInt();
                if(physicsMarks[i]<0||physicsMarks[i]>100)System.out.println("Please enter marks between 0 and 100 for Physics.");
                else break;
            }
            while(true){
                System.out.print("Chemistry (0-100): ");
                chemistryMarks[i]=sc.nextInt();
                if(chemistryMarks[i]<0||chemistryMarks[i]>100)System.out.println("Please enter marks between 0 and 100 for Chemistry.");
                else break;
            }
            while(true){
                System.out.print("Maths (0-100): ");
                mathsMarks[i]=sc.nextInt();
                if(mathsMarks[i]<0||mathsMarks[i]>100)System.out.println("Please enter marks between 0 and 100 for Maths.");
                else break;
            }
            int totalMarks=physicsMarks[i]+chemistryMarks[i]+mathsMarks[i];
            percentages[i]=(double)totalMarks/300*100;
            grades[i]=calculateGrade(percentages[i]);
        }
        System.out.println("Student Results:");
        System.out.println();
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println();
        for(int i=0;i<numStudents;i++){
            System.out.print((i+1)+" ");
            System.out.print("\t\t"+physicsMarks[i]+" ");
            System.out.print("\t\t"+chemistryMarks[i]+" ");
            System.out.print("\t\t\t"+mathsMarks[i]+" ");
            System.out.print("\t\t"+String.format("%.2f",percentages[i])+" ");
            System.out.println("\t\t"+grades[i]);
        }
    }
}
