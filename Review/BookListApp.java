import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;

    public Book(String title) {
        if (title == null || title.trim().isEmpty() || !title.matches("^[A-Z][a-zA-Z0-9\\s_-]{2,49}$")) {
            throw new IllegalArgumentException("Invalid book title. It must start with a capital letter and be at least 3 characters long.");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

public class BookListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        try {
            System.out.print("Enter the number of books to add: ");
            int n = sc.nextInt();
            sc.nextLine(); 

            for (int i = 0; i < n; i++) {
                System.out.print("Enter title for book " + (i + 1) + ": ");
                String title = sc.nextLine();
                books.add(new Book(title));
            }

            System.out.println("\nList of Books:");
            for (Book b : books) {
                System.out.println(b.getTitle());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Tried to access an invalid index in the book list.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("\nProgram finished running.");
            sc.close();
        }
    }
}
