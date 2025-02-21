import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        long startTime, endTime;

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            startTime = System.nanoTime();
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            endTime = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (endTime - startTime) + " ns");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            endTime = System.nanoTime();
            System.out.println("Buffered copy time: " + (endTime - startTime) + " ns");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
        }
    }
}
