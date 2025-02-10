import java.util.*;

// Abstract BankAccount Class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

// Loanable Interface
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// SavingsAccount Class
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4% interest rate

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for: $" + amount + " for Savings Account.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // Eligible for 5 times the balance
    }
}

// CurrentAccount Class
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.01; // 1% interest rate

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for: $" + amount + " for Current Account.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3; // Eligible for 3 times the balance
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Create a list of bank accounts
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("S123", "Alice", 5000));
        accounts.add(new CurrentAccount("C456", "Bob", 10000));

        // Process and display account details and interest
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            double interest = account.calculateInterest();
            System.out.println("Calculated Interest: $" + interest);

            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(2000);
                double eligibility = ((Loanable) account).calculateLoanEligibility();
                System.out.println("Loan Eligibility: $" + eligibility);
            }
            System.out.println("---------------------------");
        }
    }
}
