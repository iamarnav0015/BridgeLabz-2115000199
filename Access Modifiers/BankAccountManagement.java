// Base class: BankAccount
class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber); // Accessing public member from superclass
        System.out.println("Account Holder: " + accountHolder); // Accessing protected member from superclass
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest); // Reusing deposit method to add interest
        System.out.println("Interest of $" + interest + " applied.");
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account1 = new BankAccount("123456", "Alice", 5000.0);
        account1.displayAccountDetails();
        account1.deposit(1000.0);
        account1.withdraw(2000.0);
        System.out.println();

        // Create a SavingsAccount object
        SavingsAccount savingsAccount = new SavingsAccount("789012", "Bob", 10000.0, 3.5);
        savingsAccount.displaySavingsAccountDetails();
        savingsAccount.applyInterest();
        savingsAccount.displayAccountDetails();
    }
}
