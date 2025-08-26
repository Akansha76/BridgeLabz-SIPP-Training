import java.io.*;

public class UserInfoToFile {
    public static void main(String[] args) {
        String filePath = "D:/Collection/JavaStream/userinfo.txt"; // Destination file

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter(filePath, true) // append mode
        ) {
            // Take user input
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Write to file
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");
            fw.write("-------------------------\n");

            System.out.println(" Information saved successfully in " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
