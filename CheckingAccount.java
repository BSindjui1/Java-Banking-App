public class CheckingAccount extends Account{
    private double overDraftLimit;


    public CheckingAccount(String accountNumber, String accountHolderName, double balance, double overDraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overDraftLimit = overDraftLimit;
    }

    public double getOverdraftLimit() {
        return this.overDraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) { // Always check for non-positive amounts first
            System.out.println("Withdrawal amount must be positive.");
            return; // Exit the method
        }

        // Check if the withdrawal is within the (balance + overdraft limit)
        if (getBalance() - amount >= -this.overDraftLimit) { // More direct way to check if new balance is within overdraft
            // Or, your original check is also fine: if (amount <= (getBalance() + this.overDraftLimit))
            setBalance(getBalance() - amount); // Update balance
            System.out.println("Withdrawal of $" + String.format("%.2f", amount) + " successful. New balance: $" + String.format("%.2f", getBalance()));
        if (getBalance() < 0) {
            System.out.println("NOTICE: Your account is now overdrawn. Current overdraft: $" + String.format("%.2f", -getBalance()));
            }
        } 
        else {
            // This means amount > 0 AND withdrawal would exceed overdraftLimit
            System.out.println("Withdrawal denied. Amount $" + String.format("%.2f", amount) + " exceeds available funds and overdraft limit.");
            System.out.println("Current balance: $" + String.format("%.2f", getBalance()));
            System.out.println("Overdraft limit: $" + String.format("%.2f", this.overDraftLimit));
            System.out.println("Maximum possible withdrawal: $" + String.format("%.2f", getBalance() + this.overDraftLimit));
        }
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo(); // Calls the displayAccountInfo method from Account class
        System.out.println("Account Type: Checkings Account");
        System.out.println("Overdraft Limit: $" + String.format("%.2f",this.overDraftLimit));
        System.out.println("------------------------\n");
    }
}

