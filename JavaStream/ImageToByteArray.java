import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImage = "D:/Collection/JavaStream/input.png";   // original image
        String outputImage = "D:/Collection/JavaStream/output.jpg"; // copied image

        try {
            // Step 1: Read original image into byte array
            File file = new File(inputImage);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024]; // 1KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = baos.toByteArray(); // complete byte array
            System.out.println(" Image converted to byte array. Size: " + imageBytes.length + " bytes");

            // Step 2: Write back from byte array to new image
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            bais.close();
            baos.close();

            System.out.println(" New image created successfully at: " + outputImage);

            // Step 3: Verify by comparing file sizes
            if (file.length() == new File(outputImage).length()) {
                System.out.println(" Verification successful! Files are identical in size.");
            } else {
                System.out.println(" Files differ in size.");
            }

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
