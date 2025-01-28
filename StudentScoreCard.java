import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();

        int[][] scores = generateScores(students);
        double[][] results = calculateTotalAveragePercentage(scores);
        displayScorecard(scores, results);
    }

    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = rand.nextInt(41) + 60;
            scores[i][1] = rand.nextInt(41) + 60;
            scores[i][2] = rand.nextInt(41) + 60;
        }
        return scores;
    }

    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        int students = scores.length;
        double[][] results = new double[students][3];
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("ID  Physics  Chemistry  Math  Total  Average  Percentage  Grade");
        System.out.println("----------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            double percentage = results[i][2];
            String grade = getGrade(percentage);

            System.out.println((i + 1) + "   " + scores[i][0] + "        " + scores[i][1] + "         " + scores[i][2] + "    " + results[i][0] + "     " + results[i][1] + "     " + results[i][2] + "      " + grade);
        }

        System.out.println("----------------------------------------------------------------------------");
    }
}