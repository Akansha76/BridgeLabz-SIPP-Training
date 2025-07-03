package EncaplsulationPolymorphismAbstraction;

import java.util.*;

// 1. ABSTRACT SUPERCLASS 
abstract class BankAccount {
    /* Encapsulated (private) state */
    private final String accountNumber;
    private final String holderName;
    private double balance;

    protected BankAccount(String accountNumber, String holderName, double openingBalance) {
        this.accountNumber = accountNumber;
        this.holderName    = holderName;
        this.balance       = openingBalance;
    }

    /* Getters (no public setter for accountNumber or holderName) */
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName()    { return holderName;    }
    public double getBalance()       { return balance;       }

    /* Concrete behaviour shared by all accounts */
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive.");
        if (amount > balance) throw new IllegalStateException("Insufficient funds.");
        balance -= amount;
    }

    /* Protected helper for subclasses that need to update balance (interest) */
    protected void creditInterest(double amount) {
        balance += amount;
    }

    /* Abstract – each account type chooses its own formula */
    public abstract double calculateInterest();
}

// 2. BEHAVIOUR‑ADDING INTERFACE 
interface Loanable {
    void   applyForLoan(double amount);
    double calculateLoanEligibility();   // returns max loan allowed
}

// a. SAVINGS ACCOUNT 
class SavingsAccount extends BankAccount {
    private static final double ANNUAL_RATE = 0.04; // 4 % p.a.

    public SavingsAccount(String accNo, String holder, double opening) {
        super(accNo, holder, opening);
    }

    @Override
    public double calculateInterest() {
        double interest = getBalance() * ANNUAL_RATE / 12;  // monthly interest
        creditInterest(interest);
        return interest;
    }
}

// ─────────────────────────── 3b. CURRENT ACCOUNT ──────────────────────────────
class CurrentAccount extends BankAccount implements Loanable {
    private static final double MONTHLY_RATE = 0.01;   // 1 % monthly
    private static final double ELIGIBILITY_FACTOR = 3; // loan up to 3× avg balance

    private double cumulativeBalance; // to compute simple average
    private int    transactions;

    public CurrentAccount(String accNo, String holder, double opening) {
        super(accNo, holder, opening);
        cumulativeBalance = opening;
        transactions      = 1;
    }

    /* Override deposit/withdraw to track avg balance */
    @Override public void deposit(double amt) { super.deposit(amt); track(); }
    @Override public void withdraw(double amt){ super.withdraw(amt); track(); }

    private void track() {
        cumulativeBalance += getBalance();
        transactions++;
    }

    @Override
    public double calculateInterest() {
        double interest = getBalance() * MONTHLY_RATE;
        creditInterest(interest);
        return interest;
    }

    // ── Loanable implementation ──
    @Override
    public void applyForLoan(double amount) {
        double eligible = calculateLoanEligibility();
        if (amount <= eligible) {
            System.out.printf("Loan of %.2f approved for %s%n", amount, getHolderName());
        } else {
            System.out.printf("Loan request of %.2f denied (eligible up to %.2f)%n",
                              amount, eligible);
        }
    }

    @Override
    public double calculateLoanEligibility() {
        double avgBalance = cumulativeBalance / transactions;
        return avgBalance * ELIGIBILITY_FACTOR;
    }
}


class BankUtil {

    /** Process each account polymorphically and display interest earned */
    public static void processMonthly(List<BankAccount> accounts) {
        System.out.println("───── Monthly Interest Processing ─────");
        for (BankAccount acc : accounts) {
            double interest = acc.calculateInterest();     // dynamic dispatch
            System.out.printf("%s | %s | Interest Credited: %.2f | New Balance: %.2f%n",
                              acc.getAccountNumber(), acc.getHolderName(),
                              interest, acc.getBalance());
        }
       
    }
}


public class BankingSystemDemo {
    public static void main(String[] args) {
        SavingsAccount sav1 = new SavingsAccount("SA-1001", "Aditi", 50000);
        CurrentAccount cur1 = new CurrentAccount("CA-2001", "Rahul", 250000);

        // Regular transactions
        sav1.deposit(5000);
        cur1.withdraw(50000);
        cur1.deposit(10000);

        // Polymorphic interest processing
        List<BankAccount> portfolio = List.of(sav1, cur1);
        BankUtil.processMonthly(portfolio);

        // Loan application (interface usage)
        cur1.applyForLoan(400000);   // try within eligibility
        cur1.applyForLoan(1000000);  // try exceeding eligibility
    }
}
