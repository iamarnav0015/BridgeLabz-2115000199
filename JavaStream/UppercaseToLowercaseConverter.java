import java.io.*;

public class UppercaseToLowercaseConverter {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "converted.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase(ch));
            }
            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
        }
    }
}
