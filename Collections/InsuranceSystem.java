import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

// ------------------ Policy Class ------------------
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    // Uniqueness based on policy number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Sorting in TreeSet by expiry date
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "No='" + policyNumber + '\'' +
                ", Name='" + policyHolderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

// ------------------ PolicyManager ------------------
class PolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    // Add policy into all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("\n--- HashSet Policies (No Order) ---");
        hashSetPolicies.forEach(System.out::println);

        System.out.println("\n--- LinkedHashSet Policies (Insertion Order) ---");
        linkedHashSetPolicies.forEach(System.out::println);

        System.out.println("\n--- TreeSet Policies (Sorted by Expiry Date) ---");
        treeSetPolicies.forEach(System.out::println);
    }

    // Policies expiring within 30 days
    public void displayExpiringSoon() {
        System.out.println("\n--- Policies Expiring in 30 days ---");
        LocalDate now = LocalDate.now();
        treeSetPolicies.stream()
                .filter(p -> ChronoUnit.DAYS.between(now, p.getExpiryDate()) <= 30)
                .forEach(System.out::println);
    }

    // Policies with a specific coverage type
    public void displayByCoverageType(String type) {
        System.out.println("\n--- Policies with Coverage Type: " + type + " ---");
        hashSetPolicies.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    // Find duplicate policies based on policyNumber
    public void findDuplicatePolicies(List<Policy> policies) {
        System.out.println("\n--- Duplicate Policies ---");
        Set<String> seen = new HashSet<>();
        policies.stream()
                .filter(p -> !seen.add(p.getPolicyNumber()))
                .forEach(System.out::println);
    }

    // Performance Comparison
    public void comparePerformance() {
        System.out.println("\n--- Performance Comparison ---");
        int n = 100000;
        List<Policy> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(new Policy("P" + i, "Holder" + i,
                    LocalDate.now().plusDays(i % 365), "Auto", 5000));
        }

        measureSetPerformance(new HashSet<>(), testData, "HashSet");
        measureSetPerformance(new LinkedHashSet<>(), testData, "LinkedHashSet");
        measureSetPerformance(new TreeSet<>(), testData, "TreeSet");
    }

    private void measureSetPerformance(Set<Policy> set, List<Policy> data, String type) {
        long start, end;

        // Add
        start = System.nanoTime();
        set.addAll(data);
        end = System.nanoTime();
        System.out.println(type + " Add: " + (end - start) / 1e6 + " ms");

        // Search
        start = System.nanoTime();
        set.contains(data.get(data.size() / 2));
        end = System.nanoTime();
        System.out.println(type + " Search: " + (end - start) / 1e6 + " ms");

        // Remove
        start = System.nanoTime();
        set.remove(data.get(0));
        end = System.nanoTime();
        System.out.println(type + " Remove: " + (end - start) / 1e6 + " ms");
    }
}

// ------------------ Main Class ------------------
public class InsuranceSystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Sample Policies
        Policy p1 = new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 2000);
        Policy p2 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.now().plusDays(20), "Home", 4000);
        Policy p4 = new Policy("P002", "Bob-Duplicate", LocalDate.now().plusDays(50), "Auto", 3000); // duplicate policyNumber

        // Add to manager
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        // Display
        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Auto");

        // Duplicate Check
        List<Policy> allPolicies = Arrays.asList(p1, p2, p3, p4);
        manager.findDuplicatePolicies(allPolicies);

        // Performance
        manager.comparePerformance();
    }
}

