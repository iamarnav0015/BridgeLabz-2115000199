import java.util.Scanner;
public class Triangle {
    public static void main(String[] args) {
        double base, height;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the base of the triangle in centimeters: ");
        base=input.nextDouble();
        System.out.print("Enter the height of the triangle in centimeters: ");
        height=input.nextDouble();
        double areaCm2=0.5*base*height;
        double areaIn2=areaCm2/6.4516;
        System.out.println("The area of the triangle is "+areaCm2+" square centimeters and "+areaIn2+" square inches.");
    }
}
