class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordList {
    private StudentNode head;

    // Add a new student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add a new student at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add a new student at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds!");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete a student by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
        }
    }

    // Search for a student by Roll Number
    public void searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll Number: " + current.rollNumber +
                        ", Name: " + current.name + ", Age: " + current.age +
                        ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber +
                    ", Name: " + current.name +
                    ", Age: " + current.age +
                    ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade by Roll Number
    public void updateGradeByRollNumber(int rollNumber, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public static void main(String[] args) {
        StudentRecordList studentList = new StudentRecordList();

        // Adding student records
        studentList.addAtBeginning(101, "Alice", 20, "A");
        studentList.addAtEnd(102, "Bob", 21, "B");
        studentList.addAtPosition(2, 103, "Charlie", 22, "C");

        // Displaying all records
        System.out.println("All Student Records:\n");
        studentList.displayAllRecords();

        // Searching for a student
        studentList.searchByRollNumber(102);

        // Updating a student's grade
        studentList.updateGradeByRollNumber(101, "A+");
        studentList.searchByRollNumber(101);

        // Deleting a student
        studentList.deleteByRollNumber(103);

        // Displaying all records after deletion
        System.out.println("Updated Student Records:");
        studentList.displayAllRecords();
    }
}
