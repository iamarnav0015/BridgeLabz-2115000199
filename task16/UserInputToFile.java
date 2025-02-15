import java.io.*;
import java.nio.charset.StandardCharsets;

public class UserInputToFile {
    public static void main(String[] args) {
        String fileName = "output.txt";

        try (InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter(fileName)) {

            System.out.println("Enter text (type 'exit' to finish):");
            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + System.lineSeparator());
            }
            System.out.println("Input saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while processing input/output: " + e.getMessage());
        }
    }
}
