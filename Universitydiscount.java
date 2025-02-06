import java.util.Scanner;
public class Universitydiscount {
    public static void main(String[] args) {
        double fee, discountPercent;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the student fee in INR: ");
        fee=input.nextDouble();
        System.out.print("Enter the university discount percentage: ");
        discountPercent=input.nextDouble();
        double discount=(fee*discountPercent)/100;
        double discountedFee=fee-discount;
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+discountedFee);
    }
}