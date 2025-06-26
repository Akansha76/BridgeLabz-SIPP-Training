

public class Book {

    // STATIC MEMBERS 
    private static String libraryName = "City Central Library";

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    // 3. FINAL FIELD
    private final String isbn; // Cannot be changed once assigned

    private String title;
    private String author;

    // 2. CONSTRUCTOR (uses this) 
    public Book(String title, String author, String isbn) {
        this.title  = title;
        this.author = author;
        this.isbn   = isbn;
    }

    //. INSTANCEOF CHECk
    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("\n—— Book Details ——");
            System.out.println("Title : " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN  : " + isbn);
        }
    }

    
    public static void main(String[] args) {

        // Display static library name
        Book.displayLibraryName();

        // Create book objects
        Book b1 = new Book("The Alchemist", "Paulo Coelho", "9780061122415");
        Book b2 = new Book("1984", "George Orwell", "9780451524935");

       
        b1.displayDetails();
        b2.displayDetails();

        
    }
}
