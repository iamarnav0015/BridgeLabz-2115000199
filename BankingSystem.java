import java.util.*;

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void createAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        }
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                double newBalance = accounts.get(accountNumber) - amount;
                accounts.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber);
                System.out.println("Withdrawal of " + amount + " processed for account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account: " + accountNumber);
            }
        }
    }

    public void displayAccounts() {
        System.out.println("Accounts: " + accounts);
        System.out.println("Accounts Sorted by Balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        system.createAccount("ACC001", 50000);
        system.createAccount("ACC002", 30000);
        system.createAccount("ACC003", 20000);

        system.deposit("ACC001", 10000);
        system.requestWithdrawal("ACC002");
        system.processWithdrawals(5000);

        system.displayAccounts();
    }
}