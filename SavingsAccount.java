public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;

    }

    public double getInterestRate() {
    return this.interestRate;   
    }

    public void applyInterest() {
        if (this.interestRate > 0 && getBalance() > 0) {
            double interestEarned = getBalance() * this.interestRate / 100;
            deposit(interestEarned); //Uses deposit method from Account class to add interest
            System.out.println("Interest of $" + String.format("%.2f",interestEarned) + "applied. New balance: $" + String.format("%.2f", getBalance()));
        }
    }

    @Override
    public void withdraw(double amount) {
    if (amount <= 0) {
        System.out.println("Withdrawal amount must be positive.");
        return; // Exits if amount is not positive
    }

    if (amount > getBalance()) {
        System.out.println("Insufficient funds. Withdrawal of $" + amount + " failed.");
        return; // Exits if insufficient funds
    }

    // If we reach here, the withdrawal is valid
    setBalance(getBalance() - amount);
    System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + getBalance());
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo(); // Calls the displayAccountInfo method from Account class
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + this.interestRate + "%");
        System.out.println("------------------------\n");
    }

}

     
