import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCount = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults = new TreeMap<>();

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedResults.put(candidate, sortedResults.getOrDefault(candidate, 0) + 1);
    }

    public int getVotes(String candidate) {
        return voteCount.getOrDefault(candidate, 0);
    }

    public void displayResults() {
        System.out.println("Vote Count (Sorted Order): " + sortedResults);
        System.out.println("Vote Count (Insertion Order): " + voteOrder);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Amit");
        system.castVote("Priya");
        system.castVote("Amit");
        system.castVote("Ravi");
        system.castVote("Priya");
        system.castVote("Amit");

        System.out.println("Votes for Amit: " + system.getVotes("Amit"));
        system.displayResults();
    }
}
