// Base class: Book
package ConstructorInstanceModifiers.level1;
class Book {
    public String ISBN;        // Public: accessible everywhere
    protected String title;    // Protected: accessible within package and subclass
    private String author;     // Private: accessible only within this class

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get author
    public String getAuthor() {
        return author;
    }

    // Method to display book info
    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass: EBook
class EBook extends Book {
    private String fileFormat;

    // Constructor
    public EBook(String ISBN, String title, String author, String fileFormat) {
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    // Display EBook information
    public void displayEBookInfo() {
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ISBN);           // public - directly accessible
        System.out.println("Title: " + title);         // protected - directly accessible
        // System.out.println("Author: " + author);    //  Not allowed: 'author' is private
        System.out.println("Author: " + getAuthor());  // Access private member using public method
        System.out.println("File Format: " + fileFormat);
    }
}

// Main class
public class BookLibrarySystem {
    public static void main(String[] args) {
        // Create an EBook object
        EBook ebook = new EBook("978-1234567890", "Java Programming", "John Doe", "PDF");

        // Display EBook information
        ebook.displayEBookInfo();

        // Change author name
        ebook.setAuthor("Jane Smith");

        System.out.println("\nAfter changing author:");
        ebook.displayEBookInfo();
    }
}
