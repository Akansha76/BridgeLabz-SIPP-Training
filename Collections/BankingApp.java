// Implement a Banking System
// Description:
// HashMap stores customer accounts (AccountNumber -> Balance).
// TreeMap sorts customers by balance.
// Queue processes withdrawal requests.

import java.util.*;

// ------------------ Account Class ------------------
class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false; // insufficient funds
    }

    @Override
    public String toString() {
        return "Account{" +
                "No='" + accountNumber + '\'' +
                ", Balance=" + balance +
                '}';
    }
}

// ------------------ Withdrawal Request ------------------
class WithdrawalRequest {
    private String accountNumber;
    private double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getAmount() { return amount; }
}

// ------------------ Banking System ------------------
class BankingSystem {
    private Map<String, Account> accounts = new HashMap<>();              // accountNo -> account
    private TreeMap<Double, List<Account>> sortedByBalance = new TreeMap<>(); // balance -> accounts
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add new account
    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        sortedByBalance
                .computeIfAbsent(account.getBalance(), k -> new ArrayList<>())
                .add(account);
    }

    // Deposit money
    public void deposit(String accountNo, double amount) {
        Account acc = accounts.get(accountNo);
        if (acc != null) {
            updateBalance(acc, acc.getBalance() + amount);
        }
    }

    // Queue a withdrawal request
    public void requestWithdrawal(String accountNo, double amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accountNo, amount));
    }

    // Process withdrawal queue
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            Account acc = accounts.get(req.getAccountNumber());
            if (acc != null) {
                if (acc.withdraw(req.getAmount())) {
                    System.out.println("Withdrawal of " + req.getAmount() +
                            " from Account " + acc.getAccountNumber() + " successful.");
                    updateBalance(acc, acc.getBalance());
                } else {
                    System.out.println(" Insufficient funds for Account " + acc.getAccountNumber());
                }
            } else {
                System.out.println(" Account " + req.getAccountNumber() + " not found.");
            }
        }
    }

   private void updateBalance(Account acc, double newBalance) {
    double oldBalance = acc.getBalance();  // store old balance first

    // remove from old balance bucket
    List<Account> oldList = sortedByBalance.get(oldBalance);
    if (oldList != null) {
        oldList.remove(acc);
        if (oldList.isEmpty()) {
            sortedByBalance.remove(oldBalance);
        }
    }

    // update the account’s balance directly
    acc.deposit(newBalance - oldBalance);

    // add into new balance bucket
    sortedByBalance.computeIfAbsent(acc.getBalance(), k -> new ArrayList<>()).add(acc);
}


    // Display all accounts (HashMap)
    public void displayAccounts() {
        System.out.println("\n--- All Accounts (HashMap) ---");
        accounts.values().forEach(System.out::println);
    }

    // Display accounts sorted by balance
    public void displaySortedByBalance() {
        System.out.println("\n--- Accounts Sorted by Balance (TreeMap) ---");
        sortedByBalance.forEach((balance, accList) -> accList.forEach(System.out::println));
    }
}

// ------------------ Main ------------------
public class BankingApp {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Add accounts
        bank.addAccount(new Account("A001", 5000));
        bank.addAccount(new Account("A002", 2000));
        bank.addAccount(new Account("A003", 8000));

        // Display
        bank.displayAccounts();
        bank.displaySortedByBalance();

        // Deposit
        bank.deposit("A002", 3000);

        // Request withdrawals
        bank.requestWithdrawal("A001", 1000);
        bank.requestWithdrawal("A002", 7000);
        bank.requestWithdrawal("A004", 500); // invalid account

        // Process withdrawals
        bank.processWithdrawals();

        // Display again
        bank.displayAccounts();
        bank.displaySortedByBalance();
    }
}
