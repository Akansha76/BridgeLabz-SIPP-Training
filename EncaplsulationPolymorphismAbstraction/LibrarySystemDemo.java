package EncaplsulationPolymorphismAbstraction;

import java.util.*;

//1. Abstract Class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Encapsulated borrower info (secured)
    private String borrowerName = null;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getItemId()   { return itemId; }
    public String getTitle()    { return title; }
    public String getAuthor()   { return author; }

    public String getItemDetails() {
        return "ID: " + itemId + " | Title: " + title + " | Author: " + author;
    }

    public void setBorrower(String name) {
        this.borrowerName = name;
    }

    public void clearBorrower() {
        this.borrowerName = null;
    }

    public boolean isBorrowed() {
        return borrowerName != null;
    }

    public String getBorrower() {
        return borrowerName;
    }

    // Abstract Method
    public abstract int getLoanDuration(); // in days
}

// 2. Interface 
interface Reservable {
    void reserveItem(String name);
    boolean checkAvailability();
}

// 3a. Book 
class Book extends LibraryItem implements Reservable {
    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem(String name) {
        if (!isBorrowed()) {
            setBorrower(name);
            System.out.println("Book reserved by " + name);
        } else {
            System.out.println("Book is already borrowed by " + getBorrower());
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isBorrowed();
    }
}

// 3b. Magazine
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String name) {
        if (!isBorrowed()) {
            setBorrower(name);
            System.out.println("Magazine reserved by " + name);
        } else {
            System.out.println("Magazine is already borrowed by " + getBorrower());
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isBorrowed();
    }
}

//  3c. DVD 
class DVD extends LibraryItem implements Reservable {
    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem(String name) {
        if (!isBorrowed()) {
            setBorrower(name);
            System.out.println("DVD reserved by " + name);
        } else {
            System.out.println("DVD is already borrowed by " + getBorrower());
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isBorrowed();
    }
}

//  Library Utility (Polymorphism) 
class LibraryManager {
    public static void printLoanInfo(List<LibraryItem> items) {
        System.out.println("--------- Loan Info ---------");
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            System.out.println("Available: " + (!item.isBorrowed() ? "Yes" : "No (Borrowed by " + item.getBorrower() + ")"));
            System.out.println("-----------------------------");
        }
    }
}


public class LibrarySystemDemo {
    public static void main(String[] args) {
        List<LibraryItem> catalog = new ArrayList<>();

        Book b1 = new Book("B101", "Java Basics", "James Gosling");
        Magazine m1 = new Magazine("M201", "Science Weekly", "Editorial Board");
        DVD d1 = new DVD("D301", "Inception", "Christopher Nolan");

        catalog.add(b1);
        catalog.add(m1);
        catalog.add(d1);

        // Reservations (interface usage)
        b1.reserveItem("Alice");
        m1.reserveItem("Bob");

        // Try reserving already borrowed
        b1.reserveItem("Charlie");

        // Polymorphism in action
        LibraryManager.printLoanInfo(catalog);
    }
}
