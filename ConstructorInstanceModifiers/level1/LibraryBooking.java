package ConstructorInstanceModifiers.level1;

class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // default availability
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is currently unavailable.");
        }
    }

    void display() {
        System.out.println("Title: " + title + ", Available: " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Java Basics", "James Gosling", 350);
        book.display();
        book.borrowBook();
        book.borrowBook(); // try again to show availability change
        book.display();
    }
}
