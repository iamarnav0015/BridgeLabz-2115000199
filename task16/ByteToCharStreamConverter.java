import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteToCharStreamConverter {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
