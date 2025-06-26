//package Statict;
 
public class BankAccount {

    // 1.  STATIC MEMBERS (shared data)    
    
    private static String bankName     = "ACE Bank";
    private static int    totalAccounts = 0;          

    
    //  FINAL FIELD (immutable once set)
    private final long accountNumber;                

    //    REGULAR INSTANCE FIELDS        
    private String accountHolderName;
    private double balance;

     //2.  CONSTRUCTOR (uses this)        
    public BankAccount(String accountHolderName,
                       long   accountNumber,
                       double openingBalance) {

        
        this.accountHolderName = accountHolderName;
        this.accountNumber     = accountNumber;
        this.balance           = openingBalance;

        totalAccounts++;   // update global count
    }

    /* Behaviour  */
    public void deposit (double amt) { if (amt > 0)             balance += amt; }
    public void withdraw(double amt) { if (amt > 0 && amt <= balance) balance -= amt; }

    /** 4. INSTANCEOF check before printing details */
    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("\n—— " + bankName + " Account Details ——");
            System.out.println("Holder : " + accountHolderName);
            System.out.println("Number : " + accountNumber);
            System.out.printf ("Balance: Rs.%.2f%n", balance);
        }
    }

    // Static API  
    public static int  getTotalAccounts() { return totalAccounts; }
    public static void setBankName(String newName)   { bankName = newName; }

    //  Quick test-driver (main method)   
    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("Akanksha Shakya", 1002003001L, 5_000);
        BankAccount acc2 = new BankAccount("John Doe",        1002003002L, 10_000);

        acc1.deposit(1_500);
        acc2.withdraw(2_000);

        acc1.displayDetails();
        acc2.displayDetails();

        System.out.println("\nTotal accounts created: " + BankAccount.getTotalAccounts());

        
    }
}
