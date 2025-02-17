import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "testfile.txt"; // Path to the test file

        System.out.println("File Size | FileReader Time (ms) | InputStreamReader Time (ms)");
        System.out.println("--------------------------------------------------------------");

        for (int size : new int[]{1, 100, 500}) { // File sizes in MB
            createTestFile(filePath, size); // Generate test file

            long fileReaderTime = measureFileReader(filePath);
            long inputStreamReaderTime = measureInputStreamReader(filePath);

            System.out.println(size + "MB | " + fileReaderTime + " ms | " + inputStreamReaderTime + " ms");
        }
    }

    // Measure FileReader execution time (Character Stream)
    public static long measureFileReader(String filePath) {
        long startTime = System.nanoTime();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
                // Reads character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds
    }

    // Measure InputStreamReader execution time (Byte Stream)
    public static long measureInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
                // Reads bytes and converts to characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds
    }

    // Generate a test file of given size in MB
    public static void createTestFile(String filePath, int sizeMB) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < sizeMB * 1024 * 1024; i++) {
                writer.write('A'); // Writing repetitive characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
