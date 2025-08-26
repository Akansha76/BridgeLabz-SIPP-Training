// Design a Voting System
// Description: Design a system where:
// Votes are stored in a HashMap (Candidate -> Votes).
// TreeMap is used to display the results in sorted order.
// LinkedHashMap is used to maintain the order of votes.

import java.util.*;

// ------------------ VotingSystem ------------------
class VotingSystem {
    private Map<String, Integer> voteCount = new HashMap<>();          // Candidate -> Votes
    private List<String> voteLog = new LinkedList<>();                 // Order of votes (LinkedHashMap alternative)
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>(); // Candidate -> Votes (in order received)

    // Cast a vote
    public void castVote(String candidate) {
        // update HashMap
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);

        // maintain vote log (order of voting)
        voteLog.add(candidate);

        // maintain LinkedHashMap (candidate order of first appearance)
        orderedVotes.put(candidate, voteCount.get(candidate));

        System.out.println(" Vote cast for " + candidate);
    }

    // Display all votes (HashMap - no order)
    public void displayVoteCount() {
        System.out.println("\n--- Vote Count (HashMap, Unordered) ---");
        voteCount.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes));
    }

    // Display voting order (LinkedHashMap / log)
    public void displayVotingOrder() {
        System.out.println("\n--- Voting Order (LinkedHashMap / Log) ---");
        for (String candidate : voteLog) {
            System.out.println(candidate);
        }
    }

    // Display results sorted by candidate name (TreeMap)
    public void displayResultsSorted() {
        System.out.println("\n--- Results Sorted by Candidate (TreeMap) ---");
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        sortedResults.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes));
    }

    // Display winner
    public void displayWinner() {
        System.out.println("\n--- Winner ---");
        String winner = Collections.max(voteCount.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        System.out.println(winner + " with " + voteCount.get(winner) + " votes.");
    }
}

// ------------------ Main ------------------
public class VotingApp {
    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();

        // Cast votes
        vs.castVote("Alice");
        vs.castVote("Bob");
        vs.castVote("Alice");
        vs.castVote("Charlie");
        vs.castVote("Bob");
        vs.castVote("Alice");

        // Display
        vs.displayVoteCount();       // HashMap
        vs.displayVotingOrder();     // LinkedHashMap/Log
        vs.displayResultsSorted();   // TreeMap
        vs.displayWinner();          // Winner
    }
}
