import java.util.Scanner;
public class Friends{
    public static void main(String[] args){
        String[] names={"Amar","Akbar","Anthony"};
        int[] ages=new int[3];
        double[] heights=new double[3];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;i++){
            System.out.println("Enter age for "+names[i]+":");
            ages[i]=sc.nextInt();
            System.out.println("Enter height for "+names[i]+":");
            heights[i]=sc.nextDouble();
        }
        int youngestIndex=0;
        double tallestIndex=0;
        for(int i=1;i<3;i++){
            if(ages[i]<ages[youngestIndex]) youngestIndex=i;
            if(heights[i]>heights[(int)tallestIndex]) tallestIndex=i;
        }
        System.out.println("The youngest friend is "+names[youngestIndex]+" with age "+ages[youngestIndex]);
        System.out.println("The tallest friend is "+names[(int)tallestIndex]+" with height "+heights[(int)tallestIndex]);
    }
}
