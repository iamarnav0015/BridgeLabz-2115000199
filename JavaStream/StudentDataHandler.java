import java.io.*;

public class StudentDataHandler {
    public static void main(String[] args) {
        String fileName = "student_data.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Shivangi");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Prashant");
            dos.writeDouble(3.6);

            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing student data.");
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading student data.");
        }
    }
}
