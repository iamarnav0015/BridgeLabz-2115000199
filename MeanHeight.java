import java.util.Scanner;
public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        System.out.println("Enter the heights of 11 players:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        double mean = sum / heights.length;
        System.out.printf("The mean height of the football team is: %.2f\n", mean);
    }
}
