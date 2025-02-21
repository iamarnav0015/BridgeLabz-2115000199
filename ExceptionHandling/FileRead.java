import java.io.*;

class FileRead {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String firstLine = reader.readLine();
            System.out.println(firstLine != null ? firstLine : "File is empty");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
