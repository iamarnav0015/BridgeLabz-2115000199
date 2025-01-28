import java.util.Scanner;

public class NaturalNumberSum {
    public static int sumRec(int n) {
        return n == 1 ? 1 : n + sumRec(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = s.nextInt();
        if (n > 0) {
            int recSum = sumRec(n), formulaSum = sumFormula(n);
            System.out.println("Sum using recursion: " + recSum);
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println(recSum == formulaSum ? "Both results match." : "Results do not match.");
        } else System.out.println("Enter a valid natural number.");
        s.close();
    }
}
