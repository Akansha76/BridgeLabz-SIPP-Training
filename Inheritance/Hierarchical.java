package Inheritance;

class BankAccount {
    protected int accountNumber;
    protected double balance;           // use double

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("SavingsAccount");
    }
}

class CheckingAccount extends BankAccount {
    private int withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("CheckingAccount");
    }
}

class FixedDepositAccount extends BankAccount {

    FixedDepositAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    void displayAccountType() {
        System.out.println("FixedDepositAccount");
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        SavingsAccount    sa = new SavingsAccount(12345555, 500.0, 5);
        CheckingAccount   ca = new CheckingAccount(9876543, 600.0, 20_000);
        FixedDepositAccount fa = new FixedDepositAccount(567890, 700.0);

        sa.displayAccountType();
        ca.displayAccountType();
        fa.displayAccountType();
    }
}
