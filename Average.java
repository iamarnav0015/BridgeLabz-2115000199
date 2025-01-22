public class Average {
    public static void main(String[] args) {
        // Marks in each subject
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate the total marks and average
        int totalMarks = maths + physics + chemistry;
        double average = totalMarks / 3.0; // Average percentage

        // Output the result
        System.out.println("Sam’s average mark in PCM is " + average);
    }
}
