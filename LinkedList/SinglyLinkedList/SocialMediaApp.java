import java.util.*;


 //  Node class: represents one user profile
 
class User {
    int    userId;
    String name;
    int    age;

    List<Integer> friends = new ArrayList<>();  // friend IDs
    User next;                                  // singly‑linked list pointer

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name   = name;
        this.age    = age;
        this.next   = null;
    }

    void printProfile() {
        System.out.printf("ID: %d | Name: %-15s | Age: %d | Friends: %d%n",
                           userId, name, age, friends.size());
    }
}

  // Singly‑linked list wrapper
   
class SocialNetwork {
    private User head = null;

    /* Add a new user at END of list */
    public void addUser(int id, String name, int age) {
        if (searchById(id) != null) {
            System.out.println(" User ID already exists.");
            return;
        }
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added.");
    }

    /* Search helpers */
    public User searchById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void searchByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                temp.printProfile();
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No user named \"" + name + "\" found.");
    }

    /* Add friend connection (bidirectional) */
    public void addFriend(int id1, int id2) {
        if (id1 == id2) { System.out.println("Cannot friend yourself."); return; }

        User u1 = searchById(id1);
        User u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println(" One or both user IDs not found.");
            return;
        }

        if (!u1.friends.contains(id2)) u1.friends.add(id2);
        if (!u2.friends.contains(id1)) u2.friends.add(id1);

        System.out.println("👍 Users " + id1 + " and " + id2 + " are now friends.");
    }

    /* Remove friend connection (bidirectional) */
    public void removeFriend(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println(" One or both user IDs not found.");
            return;
        }

        u1.friends.remove(Integer.valueOf(id2));
        u2.friends.remove(Integer.valueOf(id1));
        System.out.println(" Friendship between " + id1 + " and " + id2 + " removed.");
    }

    /* Display all friends of a user */
    public void displayFriends(int id) {
        User u = searchById(id);
        if (u == null) { System.out.println("User not found."); return; }

        System.out.println("\nFriends of " + u.name + " (ID " + id + "):");
        if (u.friends.isEmpty()) {
            System.out.println("(no friends)");
            return;
        }
        for (int fid : u.friends) {
            User f = searchById(fid);
            if (f != null) System.out.println(" - " + f.name + " (ID " + fid + ")");
            else System.out.println(" - Unknown user (ID " + fid + ")");
        }
    }

    /* Mutual friends between two users */
    public void mutualFriends(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println(" One or both user IDs not found.");
            return;
        }

        Set<Integer> set1 = new HashSet<>(u1.friends);
        set1.retainAll(u2.friends);            // intersection

        System.out.println("\nMutual friends of " + id1 + " & " + id2 + ":");
        if (set1.isEmpty()) {
            System.out.println("(none)");
        } else {
            for (int fid : set1) {
                User f = searchById(fid);
                System.out.println(" - " + (f != null ? f.name : "Unknown") +
                                   " (ID " + fid + ")");
            }
        }
    }

    /* Count friends for each user */
    public void countAllFriends() {
        if (head == null) { System.out.println("Network is empty."); return; }

        System.out.println("\nFriend counts:");
        User temp = head;
        while (temp != null) {
            System.out.printf("%-15s (ID %d) : %d%n",
                              temp.name, temp.userId, temp.friends.size());
            temp = temp.next;
        }
    }

    /* Display all users */
    public void displayAllUsers() {
        if (head == null) { System.out.println("No users."); return; }

        System.out.println("\n=== User List ===");
        User temp = head;
        while (temp != null) {
            temp.printProfile();
            temp = temp.next;
        }
    }
}


   //MAIN: text‑menu driver
  
public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork net = new SocialNetwork();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n---- Social Media Menu ----");
            System.out.println("1.  Add User");
            System.out.println("2.  Add Friend Connection");
            System.out.println("3.  Remove Friend Connection");
            System.out.println("4.  Display Friends of User");
            System.out.println("5.  Find Mutual Friends");
            System.out.println("6.  Search User by ID");
            System.out.println("7.  Search User by Name");
            System.out.println("8.  Count Friends of Each User");
            System.out.println("9.  Display All Users");
            System.out.println("10. Exit");
            System.out.print("Choice (1‑10): ");
            int choice = sc.nextInt();
            sc.nextLine();   // clear newline

            int id1, id2, age;
            String name;

            switch (choice) {
                case 1:  // add user
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    net.addUser(id1, name, age);
                    break;

                case 2:  // add friend
                    System.out.print("Enter Your User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Friend's User ID: ");
                    id2 = sc.nextInt();
                    net.addFriend(id1, id2);
                    break;

                case 3:  // remove friend
                    System.out.print("Enter Your User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Friend's User ID: ");
                    id2 = sc.nextInt();
                    net.removeFriend(id1, id2);
                    break;

                case 4:  // display friends
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    net.displayFriends(id1);
                    break;

                case 5:  // mutual friends
                    System.out.print("Enter first User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter second User ID: ");
                    id2 = sc.nextInt();
                    net.mutualFriends(id1, id2);
                    break;

                case 6:  // search by ID
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    User u = net.searchById(id1);
                    if (u == null) System.out.println("User not found.");
                    else u.printProfile();
                    break;

                case 7:  // search by name
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    net.searchByName(name);
                    break;

                case 8:  // count friends
                    net.countAllFriends();
                    break;

                case 9:  // display all users
                    net.displayAllUsers();
                    break;

                case 10:
                    exit = true;
                    System.out.println("Good‑bye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
