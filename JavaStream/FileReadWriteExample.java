import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileReadWriteExample {
    public static void main(String[] args) {
        // Source and Destination files
        String sourceFile = "D:/Collection/JavaStream/source.txt";
        String destFile = "D:/Collection/JavaStream/destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File src = new File(sourceFile);

            // Check if source file exists
            if (!src.exists()) {
                System.out.println("Source file does not exist!");
                return;
            }

            // Create destination file if it does not exist
            File dest = new File(destFile);
            if (!dest.exists()) {
                dest.createNewFile();
            }

            // Open streams
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
