package LinkedList.DoublyLinkedList;

import java.util.Scanner;


//    Node: represents one Book in the library
  
class Book {
    int    bookId;
    String title;
    String author;
    String genre;
    boolean available;

    Book prev, next;

    Book(int bookId, String title, String author, String genre, boolean available) {
        this.bookId    = bookId;
        this.title     = title;
        this.author    = author;
        this.genre     = genre;
        this.available = available;
        this.prev = this.next = null;
    }

    void print() {
        System.out.printf(
            "ID: %d | Title: %-25s | Author: %-15s | Genre: %-10s | Status: %s%n",
            bookId, title, author, genre, available ? "Available" : "Checked‑out"
        );
    }
}


//   Doubly Linked List wrapper
  
class Library {
    private Book head = null;     // first node
    private Book tail = null;     // last  node
    private int  count = 0;

    /* 1. Add at beginning */
    public void addAtBeginning(int id, String title, String author,
                               String genre, boolean avail) {

        Book newBook = new Book(id, title, author, genre, avail);

        if (head == null) {               // empty list
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev    = newBook;
            head         = newBook;
        }
        count++;
        System.out.println("Book added at beginning.");
    }

    /* 2. Add at end */
    public void addAtEnd(int id, String title, String author,
                         String genre, boolean avail) {

        Book newBook = new Book(id, title, author, genre, avail);

        if (tail == null) {               // empty list
            head = tail = newBook;
        } else {
            tail.next   = newBook;
            newBook.prev = tail;
            tail        = newBook;
        }
        count++;
        System.out.println("Book added at end.");
    }

    /* 3. Add at specific 1‑based position */
    public void addAtPosition(int pos, int id, String title, String author,
                              String genre, boolean avail) {

        if (pos <= 0 || pos > count + 1) {
            System.out.println("❌ Invalid position.");
            return;
        }
        if (pos == 1) { addAtBeginning(id, title, author, genre, avail); return; }
        if (pos == count + 1) { addAtEnd(id, title, author, genre, avail); return; }

        Book newBook = new Book(id, title, author, genre, avail);

        // traverse to (pos‑1)‑th node
        Book temp = head;
        for (int i = 1; i < pos - 1; i++) temp = temp.next;

        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;

        count++;
        System.out.println("Book added at position " + pos + ".");
    }

    /* 4. Remove by Book ID */
    public void removeById(int id) {
        if (head == null) { System.out.println("Library is empty."); return; }

        Book curr = head;
        while (curr != null && curr.bookId != id) curr = curr.next;

        if (curr == null) { System.out.println("Book ID not found."); return; }

        // detach curr
        if (curr == head) head = curr.next;
        if (curr == tail) tail = curr.prev;

        if (curr.prev != null) curr.prev.next = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;

        count--;
        System.out.println("Book with ID " + id + " removed.");
    }

    /* 5A. Search by Book Title */
    public void searchByTitle(String title) { search("title", title); }

    /* 5B. Search by Author */
    public void searchByAuthor(String author) { search("author", author); }

    private void search(String key, String value) {
        if (head == null) { System.out.println("Library is empty."); return; }

        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (key.equals("title")  && temp.title.equalsIgnoreCase(value)  ||
                key.equals("author") && temp.author.equalsIgnoreCase(value)) {

                temp.print();
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No match found for " + key + " \"" + value + "\".");
    }

    /* 6. Update Availability Status */
    public void updateAvailability(int id, boolean avail) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = avail;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    /* 7A. Display forward */
    public void displayForward() {
        if (head == null) { System.out.println("Library is empty."); return; }

        System.out.println("\nBooks (forward):");
        Book temp = head;
        while (temp != null) {
            temp.print();
            temp = temp.next;
        }
    }

    /* 7B. Display reverse */
    public void displayReverse() {
        if (tail == null) { System.out.println("Library is empty."); return; }

        System.out.println("\nBooks (reverse):");
        Book temp = tail;
        while (temp != null) {
            temp.print();
            temp = temp.prev;
        }
    }

    /* 8. Count */
    public int getCount() { return count; }
}


 //  Main driver with text menu
  
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1.  Add Book at Beginning");
            System.out.println("2.  Add Book at End");
            System.out.println("3.  Add Book at Position");
            System.out.println("4.  Remove Book by ID");
            System.out.println("5.  Search Book by Title");
            System.out.println("6.  Search Book by Author");
            System.out.println("7.  Update Availability");
            System.out.println("8.  Display All (Forward)");
            System.out.println("9.  Display All (Reverse)");
            System.out.println("10. Count Books");
            System.out.println("11. Exit");
            System.out.print("Choice (1‑11): ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            int id, pos;
            String title, author, genre;
            boolean avail;

            switch (choice) {
                case 1: // beginning
                    id = promptId(sc);
                    title = prompt(sc, "Title");
                    author = prompt(sc, "Author");
                    genre = prompt(sc, "Genre");
                    avail = promptAvailability(sc);
                    lib.addAtBeginning(id, title, author, genre, avail);
                    break;

                case 2: // end
                    id = promptId(sc);
                    title = prompt(sc, "Title");
                    author = prompt(sc, "Author");
                    genre = prompt(sc, "Genre");
                    avail = promptAvailability(sc);
                    lib.addAtEnd(id, title, author, genre, avail);
                    break;

                case 3: // position
                    System.out.print("Enter position (1‑based): ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    id = promptId(sc);
                    title = prompt(sc, "Title");
                    author = prompt(sc, "Author");
                    genre = prompt(sc, "Genre");
                    avail = promptAvailability(sc);
                    lib.addAtPosition(pos, id, title, author, genre, avail);
                    break;

                case 4: // remove
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextInt();
                    lib.removeById(id);
                    break;

                case 5: // search title
                    title = prompt(sc, "Book Title to search");
                    lib.searchByTitle(title);
                    break;

                case 6: // search author
                    author = prompt(sc, "Author to search");
                    lib.searchByAuthor(author);
                    break;

                case 7: // update availability
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    avail = promptAvailability(sc);
                    lib.updateAvailability(id, avail);
                    break;

                case 8:
                    lib.displayForward();
                    break;

                case 9:
                    lib.displayReverse();
                    break;

                case 10:
                    System.out.println("Total books: " + lib.getCount());
                    break;

                case 11:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    /* ── helper prompt routines ───────────────────── */
    private static int promptId(Scanner sc) {
        System.out.print("Enter Book ID: ");
        return sc.nextInt();
    }

    private static String prompt(Scanner sc, String field) {
        System.out.print("Enter " + field + ": ");
        return sc.nextLine();
    }

    private static boolean promptAvailability(Scanner sc) {
        System.out.print("Is the book available? (y/n): ");
        char c = sc.next().toLowerCase().charAt(0);
        sc.nextLine();          // clear newline
        return c == 'y';
    }
}

