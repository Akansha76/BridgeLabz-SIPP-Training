// Abstraction: Interface to define navigation behavior
interface Navigator {
    void visit(String url);
    void back();
    void forward();
    void showHistory();
}
// Encapsulation: Node class is kept private inside BrowserHistory
class Node {
    String url;
    Node prev, next;

    Node(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}
// Encapsulation + Abstraction: BrowserHistory encapsulates logic and hides internals
class BrowserHistory implements Navigator {
    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    @Override
    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        System.out.println("Visited: " + url);
    }

    @Override
    public void back() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Went back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    @Override
    public void forward() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Went forward to: " + current.url);
        } else {
            System.out.println("No next page.");
        }
    }

    @Override
    public void showHistory() {
        Node temp = current;
        while (temp.prev != null) temp = temp.prev;

        System.out.print("Browsing History: ");
        while (temp != null) {
            System.out.print(temp.url);
            if (temp == current) System.out.print(" <- [Current]");
            System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
// Reuse logic for another app like Music Player
class MusicHistory extends BrowserHistory {
    public MusicHistory(String firstTrack) {
        super(firstTrack);
    }

    public void playCurrentTrack() {
        System.out.println("Playing current track.");
    }
}

public class BrowHistNav {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("home.com");

        history.visit("page1.com");
        history.visit("page2.com");
        history.back();
        history.forward();
        history.visit("page3.com");
        history.back();
        history.showHistory();

        // Inheritance & Polymorphism in action
        Navigator music = new MusicHistory("Track1");
        music.visit("Track2");
        music.back();
        music.showHistory();
    }
}
