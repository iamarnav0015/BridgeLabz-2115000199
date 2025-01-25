import java.util.Scanner;
public class BMI{
    public static String calculateWeightStatus(double bmi){
        if(bmi<=18.4)
            return"Underweight";
        else if(bmi>=18.5 && bmi<=24.9)
            return"Normal";
        else if(bmi>=25.0 && bmi<=39.9)
            return"Overweight";
        else
            return"Obese";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of persons:");
        int numPersons=sc.nextInt();
        double[] weights=new double[numPersons];
        double[] heights=new double[numPersons];
        double[] bmis=new double[numPersons];
        String[] weightStatuses=new String[numPersons];
        for(int i=0;i<numPersons;i++){
            System.out.println("Enter details for person "+(i+1)+":");
            while(true){
                System.out.print("Weight (in kg): ");
                weights[i]=sc.nextDouble();
                if(weights[i]<=0){
                    System.out.println("Please enter a positive value for weight.");
                }
                else
                    break;
            }
            while(true){
                System.out.print("Height (in meters): ");
                heights[i]=sc.nextDouble();
                if(heights[i]<=0){System.out.println("Please enter a positive value for height.");}
                else
                    break;
            }
            bmis[i]=weights[i]/(heights[i]*heights[i]);
            weightStatuses[i]=calculateWeightStatus(bmis[i]);
        }
        System.out.println("BMI Results:");
        System.out.println("Person | Weight | Height | BMI    | Status");
        for(int i=0;i<numPersons;i++){
            System.out.println((i+1)+" | "+weights[i]+" | "+heights[i]+" | "+bmis[i]+" | "+weightStatuses[i]);
        }
    }
}
