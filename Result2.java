import java.util.Scanner;
public class Result2{
    public static char calculateGrade(double percentage){
        if(percentage>=80)
            return 'A';
        else if(percentage>=70)
            return 'B';
        else if(percentage>=60)
            return 'C';
        else if(percentage>=50)
            return 'D';
        else if(percentage>=40)
            return 'E';
        else
            return 'R';
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int numStudents=sc.nextInt();
        int[][] marks=new int[numStudents][3];
        double[] percentages=new double[numStudents];
        char[] grades=new char[numStudents];
        for(int i=0;i<numStudents;i++){
            System.out.println("\nEnter marks for student "+(i+1)+":");
            while(true){
                System.out.print("Physics (0-100): ");
                marks[i][0]=sc.nextInt();
                if(marks[i][0]<0||marks[i][0]>100){System.out.println("Please enter marks between 0 and 100 for Physics.");}
                else break;
            }
            while(true){
                System.out.print("Chemistry (0-100): ");
                marks[i][1]=sc.nextInt();
                if(marks[i][1]<0||marks[i][1]>100){System.out.println("Please enter marks between 0 and 100 for Chemistry.");}
                else break;
            }
            while(true){
                System.out.print("Maths (0-100): ");
                marks[i][2]=sc.nextInt();
                if(marks[i][2]<0||marks[i][2]>100){System.out.println("Please enter marks between 0 and 100 for Maths.");}
                else break;
            }
            int totalMarks=marks[i][0]+marks[i][1]+marks[i][2];
            percentages[i]=(double)totalMarks/300*100;
            grades[i]=calculateGrade(percentages[i]);
        }
        System.out.println("Student Results:");
        System.out.println();
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for(int i=0;i<numStudents;i++){
            System.out.print((i+1)+" ");
            System.out.print("\t\t"+marks[i][0]+" ");
            System.out.print("\t\t"+marks[i][1]+" ");
            System.out.print("\t\t\t"+marks[i][2]+" ");
            System.out.printf("\t\t%.2f",percentages[i]);
            System.out.println("\t\t"+grades[i]);
        }
    }
}
