package StringBuilderBuffer;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "user_input.txt";

        try {
            // Step 1: Reader for console input
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Step 2: Writer for output file
            FileWriter fw = new FileWriter(filePath);

            String line;
            System.out.println("Enter lines to write to file (type 'exit' to stop):");

            // Step 3: Read until user types "exit"
            while (true) {
                line = br.readLine();
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                fw.write(line + "\n");
            }

            fw.close();
            br.close();
            isr.close();

            System.out.println("User input successfully written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
