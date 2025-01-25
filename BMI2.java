import java.util.Scanner;
public class BMI2{
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
        double[][] personData=new double[numPersons][3];
        String[] weightStatus=new String[numPersons];
        for(int i=0;i<numPersons;i++){
            System.out.println("Enter details for person "+(i+1)+":");
            while(true){
                System.out.println("Weight (in kg): ");
                personData[i][0]=sc.nextDouble();
                if(personData[i][0]<=0)System.out.println("Please enter a positive value for weight.");
                else break;
            }
            while(true){
                System.out.println("Height (in meters): ");
                personData[i][1]=sc.nextDouble();
                if(personData[i][1]<=0)System.out.println("Please enter a positive value for height.");
                else break;
            }
            personData[i][2]=personData[i][0]/(personData[i][1]*personData[i][1]);
            weightStatus[i]=calculateWeightStatus(personData[i][2]);
        }
        System.out.println("BMI Results:");
        System.out.println("Person | Weight | Height | BMI    | Status");
        for(int i=0;i<numPersons;i++){
            System.out.println((i+1)+" | "+personData[i][0]+" | "+personData[i][1]+" | "+personData[i][2]+" | "+weightStatus[i]);
        }
    }
}
