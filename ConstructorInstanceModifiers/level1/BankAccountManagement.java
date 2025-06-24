package ConstructorInstanceModifiers.level1;

// Base class: BankAccount
class BankAccount {
    public String accountNumber;      // Public: accessible from anywhere
    protected String accountHolder;   // Protected: accessible within package and subclasses
    private double balance;           // Private: accessible only within this class

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to display account details
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsInfo() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);      // public
        System.out.println("Account Holder: " + accountHolder);      // protected
        System.out.println("Balance: ₹" + getBalance());             // private via public method
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class
public class BankAccountManagement {
    public static void main(String[] args) {
        // Create a SavingsAccount object
        SavingsAccount sa = new SavingsAccount("SB12345678", "Ravi Kumar", 15000.0, 3.5);

        // Display initial details
        sa.displaySavingsInfo();

        // Perform transactions
        System.out.println("\n--- Transactions ---");
        sa.deposit(5000);
        sa.withdraw(3000);

        // Display updated info
        System.out.println("\nAfter transactions:");
        sa.displaySavingsInfo();
    }
}

