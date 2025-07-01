import java.util.ArrayList;

public class BankAssociationDemo {

    // --------- Account Class ---------
    static class Account {
        private static int nextAccNum = 1001;
        private int accountNumber;
        private double balance;
        private Bank bank;

        public Account(Bank bank, double initialDeposit) {
            this.bank = bank;
            this.balance = initialDeposit;
            this.accountNumber = nextAccNum++;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public double getBalance() {
            return balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public Bank getBank() {
            return bank;
        }
    }

    // --------- Customer Class ---------
    static class Customer {
        private String name;
        private ArrayList<Account> accounts;

        public Customer(String name) {
            this.name = name;
            this.accounts = new ArrayList<>();
        }

        public void addAccount(Account acc) {
            accounts.add(acc);
        }

        public void viewBalance() {
            System.out.println("\n Customer: " + name);
            if (accounts.isEmpty()) {
                System.out.println("No accounts.");
            } else {
                for (Account acc : accounts) {
                    System.out.println("Bank: " + acc.getBank().getBankName() +
                        ", Account#: " + acc.getAccountNumber() +
                        ", Balance: ₹" + acc.getBalance());
                }
            }
        }

        public String getName() {
            return name;
        }
    }

    // --------- Bank Class ---------
    static class Bank {
        private String bankName;

        public Bank(String bankName) {
            this.bankName = bankName;
        }

        public Account openAccount(Customer customer, double initialDeposit) {
            Account newAcc = new Account(this, initialDeposit);
            customer.addAccount(newAcc);
            System.out.println(" Account opened at " + bankName + " for " + customer.getName());
            return newAcc;
        }

        public String getBankName() {
            return bankName;
        }
    }

    // --------- Main Method ---------
    public static void main(String[] args) {
        // Create banks
        Bank sbi = new Bank("SBI");
        Bank hdfc = new Bank("HDFC");

        // Create customers
        Customer akanksha = new Customer("Akanksha");
        Customer rahul = new Customer("Rahul");

        // Open accounts
        sbi.openAccount(akanksha, 5000);
        hdfc.openAccount(akanksha, 8000);
        hdfc.openAccount(rahul, 10000);

        // View balances
        akanksha.viewBalance();
        rahul.viewBalance();
    }
}

