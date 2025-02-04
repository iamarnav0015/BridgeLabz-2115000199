
class BankAccount {
    private static String bankName = "Global Trust Bank";
    private static int totalAccounts = 0;

    private String accountHolderName;
    private final int accountNumber;
    private double balance;

    private static int accountCounter = 0;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountNumber = ++accountCounter;
        totalAccounts++;
        System.out.println("Account created: " + accountHolderName + " (Account Number: " + accountNumber + ", Initial Balance: $" + balance + ")");
    }

    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
            System.out.println("Bank Name: " + bankName);
        } else {
            System.out.println("Invalid account object.");
        }
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        BankAccount.getTotalAccounts();

        BankAccount account1 = new BankAccount("Alice", 5000.0);
        BankAccount account2 = new BankAccount("Bob", 3000.0);

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        BankAccount.getTotalAccounts();
    }
}

