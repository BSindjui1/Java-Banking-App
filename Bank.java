import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;
    private int lastAssignedAccountNumber; // Renamed for clarity

    public Bank() {
        this.accounts = new ArrayList<>();
        this.lastAssignedAccountNumber = 1000; // Or 1000, or any starting point
      // This will be the *last* number used.
 
    }

    private String generateNewAccountNumber(){
        return String.valueOf(this.lastAssignedAccountNumber++); // Convert to String
    }

    public SavingsAccount createSavingsAccount(String accountHolderName, double initialDeposit,double interestRate ){
        String newAccountNumber = generateNewAccountNumber();
        SavingsAccount newAccount = new SavingsAccount(newAccountNumber, accountHolderName, initialDeposit, interestRate);
        this.accounts.add(newAccount);
        System.out.println("Savings Account succesfully created for " + accountHolderName + ". Account Number: " + newAccountNumber);
        return newAccount;
    }

    public CheckingAccount createCheckingAccount(String accountHolderName, double initialDeposit, double overDraftLimit){
        String newAccountNumber = generateNewAccountNumber();
        CheckingAccount newAccount = new CheckingAccount(newAccountNumber, accountHolderName, initialDeposit, overDraftLimit);
        this.accounts.add(newAccount);
        System.out.println("Checking Account successfully created for " + accountHolderName + ". Account Number: " + newAccountNumber);
        return newAccount;
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : this.accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc; // Return the found account
            }
        }
        System.out.println("Account with number " + accountNumber + " not found.");
         // Print a message if the account is not found
         // This can be useful for debugging or user feedback
        return null; // Return null if no account is found
    }

    public void performDeposit(String accountNumber, double amount) {
    Account account = findAccount(accountNumber); // Step 1: Find the account
    if (account != null) { // Step 2: Check if account was found
        account.deposit(amount); // Step 3: Call the account's deposit method
        // The account.deposit() method itself should print success/failure messages
    } else {
        // findAccount already prints "Account ... not found."
        // You could add another message here if desired, or rely on findAccount's message.
        // System.out.println("Deposit failed: Account " + accountNumber + " not found."); // Optional additional feedback
    }

    
    }

    public void performWithdrawal(String accountNumber, double amount) {
    Account account = findAccount(accountNumber); // Step 1: Find the account
    if (account != null) { // Step 2: Check if account was found
        account.withdraw(amount); // Step 3: Call the account's withdraw method (polymorphic call!)
        // The account.withdraw() method itself will handle its specific rules and print messages
    } else {
        // findAccount already prints "Account ... not found."
        // System.out.println("Withdrawal failed: Account " + accountNumber + " not found."); // Optional
    }
}

    public void displayAllAccounts() {
        if (this.accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return; // Exit if no accounts are present
        } 
         
            System.out.println("\n--- All Accounts ---");
            for (Account acc : this.accounts) {
                acc.displayAccountInfo(); // Calls the displayAccountInfo method from Account class
        }
    }


    
}
