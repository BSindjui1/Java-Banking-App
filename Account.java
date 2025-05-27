public abstract class Account {
     private String accountNumber;
     private String accountHolderName;
     private double balance;
     
     public Account(String accountNumber, String accountHolderName, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance; 

     }

     public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }

        
     }

     public abstract void withdraw(double amount) ;

     public double getBalance() {
        return this.balance;

     }

     public String getAccountNumber() {
        return this.accountNumber;
     }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

     // Method to display account information

    


    public void displayAccountInfo() {
            System.out.println("\n--- Account Details ---");
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Balance: $" + this.balance);
            System.out.println("------------------------\n");
        }
}