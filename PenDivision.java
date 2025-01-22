public class PenDivision {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;

        // Calculate pens each student gets and the remainder
        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;

        // Output
        System.out.println("The Pen Per Student is" +pensPerStudent+ "the remaining pen not distributed is"+ remainingPens);
    }
}
