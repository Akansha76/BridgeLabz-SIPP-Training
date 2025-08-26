import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class GenerateLargeFile {
    public static void main(String[] args) {
        String filePath = "D:/Collection/JavaStream/source.txt"; // You can name it .txt, .dat, anything
        int sizeInMB = 100; // 100 MB
        long sizeInBytes = sizeInMB * 1024L * 1024L;

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[4096]; // 4 KB buffer
            Random random = new Random();
            long written = 0;

            while (written < sizeInBytes) {
                random.nextBytes(buffer);
                fos.write(buffer);
                written += buffer.length;
            }

            System.out.println("Large file created at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error generating file: " + e.getMessage());
        }
    }
}
