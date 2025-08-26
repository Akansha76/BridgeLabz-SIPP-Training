import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String filePath = "D:/Collection/JavaStream/students.dat"; // binary file

        // Writing student data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            // Writing multiple students
            dos.writeInt(101);          // roll number
            dos.writeUTF("Alice");      // name
            dos.writeDouble(8.7);       // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(7.9);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(9.2);

            System.out.println(" Student details written successfully to " + filePath);
        } catch (IOException e) {
            System.out.println(" Error writing data: " + e.getMessage());
        }

        // Reading student data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("\n Retrieved Student Details:");
            while (dis.available() > 0) { // check if data is available
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println(" Error reading data: " + e.getMessage());
        }
    }
}
