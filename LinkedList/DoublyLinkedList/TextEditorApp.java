package LinkedList.DoublyLinkedList;
import java.util.*;
public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nText Editor Menu");
            System.out.println("1. Type Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Show All History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String newText = sc.nextLine();
                    editor.type(newText);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrent();
                    break;
                case 5:
                    editor.showHistory();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting editor.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

