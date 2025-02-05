import java.util.ArrayList;
import java.util.List;

// Bank Class
class Bank {
    private String bankName;
    private List<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    // Method to open an account for a customer
    public void openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(customer, initialDeposit);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        System.out.println("Account opened for " + customer.getName() + " with balance: " + initialDeposit);
    }

    public String getBankName() {
        return bankName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

// Customer Class
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Add an account to the customer
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // View balance of all accounts
    public void viewBalance() {
        System.out.println("Balances for " + name + ":");
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getAccountId() + " Balance: " + account.getBalance());
        }
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

// Account Class (representing a bank account)
class Account {
    private static int idCounter = 1;
    private int accountId;
    private Customer owner;
    private double balance;

    public Account(Customer owner, double initialDeposit) {
        this.accountId = idCounter++;
        this.owner = owner;
        this.balance = initialDeposit;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

// Main Class
public class BankManagement {
    public static void main(String[] args) {
        // Create bank
        Bank bank = new Bank("XYZ Bank");

        // Create customers
        Customer customer1 = new Customer("prakhar");
        Customer customer2 = new Customer("lakshya");

        // Open accounts for customers
        bank.openAccount(customer1, 500.0);
        bank.openAccount(customer2, 1000.0);

        // Customer view balance
        customer1.viewBalance();
        customer2.viewBalance();

        // Deposit money into account
        customer1.getAccounts().get(0).deposit(200.0);
        customer2.getAccounts().get(0).withdraw(300.0);

        // View balances again after transactions
        customer1.viewBalance();
        customer2.viewBalance();
    }
}
