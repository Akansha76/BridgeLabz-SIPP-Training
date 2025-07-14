package StringBuilderBuffer;

import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        String filePath = "utf8file.txt";  // Make sure this file exists and is UTF-8 encoded

        try {
            // Step 1: Byte stream
            FileInputStream fis = new FileInputStream(filePath);

            // Step 2: Convert byte stream to character stream with charset UTF-8
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            // Step 3: Wrap in BufferedReader for line-by-line reading
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            isr.close();
            fis.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
