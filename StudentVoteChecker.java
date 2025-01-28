
import java.util.Scanner;

public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];
        StudentVoteChecker svc = new StudentVoteChecker();

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
            boolean canVote = svc.canStudentVote(ages[i]);
            System.out.println("Student " + (i + 1) + (canVote ? " can vote." : " cannot vote."));
        }

    }
}

