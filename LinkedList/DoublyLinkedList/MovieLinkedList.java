package LinkedList.DoublyLinkedList;

import java.util.Scanner;

public class MovieLinkedList {
    private Movie head = null;
    private Movie tail = null;

    /* 1. Add at Beginning */
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = m;
        } else {
            m.next = head;
            head.prev = m;
            head = m;
        }
        System.out.println("Movie added at beginning.");
    }

    /* 2. Add at End */
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = m;
        } else {
            tail.next = m;
            m.prev = tail;
            tail = m;
        }
        System.out.println("Movie added at end.");
    }

    /* 3. Add at Position (1‑based index) */
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 0) { System.out.println("Invalid position."); return; }
        if (pos == 1 || head == null) { addAtBeginning(title,director,year,rating); return; }

        Movie cur = head;
        for (int i = 1; i < pos - 1 && cur != null; i++) cur = cur.next;

        if (cur == null || cur.next == null) { addAtEnd(title,director,year,rating); return; }

        Movie m = new Movie(title, director, year, rating);
        m.next = cur.next;
        m.prev = cur;
        cur.next.prev = m;
        cur.next = m;
        System.out.println("Movie added at position " + pos + ".");
    }

    /* 4. Delete by Title */
    public void deleteByTitle(String title) {
        if (head == null) { System.out.println("List empty."); return; }
        Movie cur = head;
        while (cur != null && !cur.title.equalsIgnoreCase(title)) cur = cur.next;

        if (cur == null) { System.out.println("Movie not found."); return; }

        if (cur == head)  head = head.next;
        if (cur == tail)  tail = tail.prev;
        if (cur.prev != null) cur.prev.next = cur.next;
        if (cur.next != null) cur.next.prev = cur.prev;
        System.out.println("Deleted \"" + title + "\".");
    }

    /* 5. Search by Director */
    public void searchByDirector(String director) {
        Movie cur = head; boolean found = false;
        while (cur != null) {
            if (cur.director.equalsIgnoreCase(director)) { print(cur); found = true; }
            cur = cur.next;
        }
        if (!found) System.out.println("No movie by director \"" + director + "\".");
    }

    /* 6. Search by Rating (exact match) */
    public void searchByRating(double rating) {
        Movie cur = head; boolean found = false;
        while (cur != null) {
            if (Double.compare(cur.rating, rating) == 0) { print(cur); found = true; }
            cur = cur.next;
        }
        if (!found) System.out.println("No movie with rating " + rating + ".");
    }

    /* 7. Update Rating by Title */
    public void updateRating(String title, double newRating) {
        Movie cur = head;
        while (cur != null && !cur.title.equalsIgnoreCase(title)) cur = cur.next;
        if (cur == null) { System.out.println("Movie not found."); return; }
        cur.rating = newRating;
        System.out.println("Rating updated for \"" + title + "\".");
    }

    /* 8. Display Forward */
    public void displayForward() {
        if (head == null) { System.out.println("List empty."); return; }
        System.out.println("\nMovies (Forward):");
        for (Movie cur = head; cur != null; cur = cur.next) print(cur);
    }

    /* 9. Display Reverse */
    public void displayReverse() {
        if (tail == null) { System.out.println("List empty."); return; }
        System.out.println("\nMovies (Reverse):");
        for (Movie cur = tail; cur != null; cur = cur.prev) print(cur);
    }

    private void print(Movie m) {
        System.out.println("---------------------------");
        System.out.println("Title   : " + m.title);
        System.out.println("Director: " + m.director);
        System.out.println("Year    : " + m.year);
        System.out.println("Rating  : " + m.rating);
    }

    /* ======== MAIN (menu) ======== */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieLinkedList list = new MovieLinkedList();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMovie Management Menu:");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Delete Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Rating by Title");
            System.out.println("8. Display All (Forward)");
            System.out.println("9. Display All (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Choose (1‑10): ");

            int choice = sc.nextInt(); sc.nextLine();  // consume \n
            String title, director; int year, pos; double rating;

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");    title = sc.nextLine();
                    System.out.print("Director: "); director = sc.nextLine();
                    System.out.print("Year: ");     year = sc.nextInt();
                    System.out.print("Rating: ");   rating = sc.nextDouble(); sc.nextLine();
                    list.addAtBeginning(title, director, year, rating);
                }
                case 2 -> {
                    System.out.print("Title: ");    title = sc.nextLine();
                    System.out.print("Director: "); director = sc.nextLine();
                    System.out.print("Year: ");     year = sc.nextInt();
                    System.out.print("Rating: ");   rating = sc.nextDouble(); sc.nextLine();
                    list.addAtEnd(title, director, year, rating);
                }
                case 3 -> {
                    System.out.print("Position: "); pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Title: ");    title = sc.nextLine();
                    System.out.print("Director: "); director = sc.nextLine();
                    System.out.print("Year: ");     year = sc.nextInt();
                    System.out.print("Rating: ");   rating = sc.nextDouble(); sc.nextLine();
                    list.addAtPosition(pos, title, director, year, rating);
                }
                case 4 -> {
                    System.out.print("Title to delete: "); title = sc.nextLine();
                    list.deleteByTitle(title);
                }
                case 5 -> {
                    System.out.print("Director to search: "); director = sc.nextLine();
                    list.searchByDirector(director);
                }
                case 6 -> {
                    System.out.print("Rating to search: "); rating = sc.nextDouble(); sc.nextLine();
                    list.searchByRating(rating);
                }
                case 7 -> {
                    System.out.print("Title to update: "); title = sc.nextLine();
                    System.out.print("New Rating: ");      rating = sc.nextDouble(); sc.nextLine();
                    list.updateRating(title, rating);
                }
                case 8 -> list.displayForward();
                case 9 -> list.displayReverse();
                case 10 -> { exit = true; System.out.println("Exiting..."); }
                default -> System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
