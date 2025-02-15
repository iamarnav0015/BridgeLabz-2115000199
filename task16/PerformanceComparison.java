
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaderAndInputStreamReader("largefile.txt");
    }

    public static void compareStringBuilderAndBuffer() {
        int iterations = 1_000_000;
        String sampleText = "hello";

        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(sampleText);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(sampleText);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void compareFileReaderAndInputStreamReader(String fileName) {
        System.out.println("Reading file using FileReader...");
        long startTime = System.nanoTime();
        int wordCount = countWordsUsingFileReader(fileName);
        long endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount + ", Time: " + (endTime - startTime) / 1_000_000 + " ms");

        System.out.println("Reading file using InputStreamReader...");
        startTime = System.nanoTime();
        wordCount = countWordsUsingInputStreamReader(fileName);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount + ", Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static int countWordsUsingFileReader(String fileName) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String fileName) {
        int wordCount = 0;
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return wordCount;
    }
}

