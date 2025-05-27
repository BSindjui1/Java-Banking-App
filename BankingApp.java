import java.util.Scanner;

public class BankingApp{

    private static Bank bank = new Bank(); // Creates single Static instance of Bank to be used across the application
    private static Scanner scanner = new Scanner(System.in); // creates single Scanner for user input

    public static void main(String []args){
        boolean endLoop = false; // Flag to control the main loop

        while(!endLoop){ // Changed to !endLoop for cleaner syntax
            printMenu();
            System.out.print("Please select an option: ");
            if (scanner.hasNextInt()) {
                 int choice = scanner.nextInt();
                 scanner.nextLine(); //Consume the leftover newline (CRITICAL)
                switch(choice) {
                    case 1:
                       handleCreateAccount();
                        break;
                    case 2:
                        handleDeposit();
                        break;
                    case 3:
                        handleWithdraw();
                        break;
                    case 4:
                        handleCheckBalance();
                        break;
                    case 5:
                        bank.displayAllAccounts();
                        break;
                    case 0:
                        System.out.println("Exiting application. Thank You!");
                        endLoop = true;
                        scanner.close(); // Close the scanner when exiting
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input token
                scanner.nextLine(); // Clear the leftover newline (ADDED THIS LINE)
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Banking Application Menu ---"); // Added newline for better spacing
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Account Balance/Details"); // Capitalized for consistency
        System.out.println("5. Display All Accounts"); // Capitalized for consistency
        System.out.println("0. Exit");
        System.out.println("------------------------------");
    }

    private static void handleCreateAccount() {
        System.out.println("\n--- Create New Account ---");
        System.out.print("Enter Account Holder Name: "); // Changed to print for inline input
        String name = scanner.nextLine();

        System.out.print("Enter Account Type (savings/checking): "); // Changed to print
        String type = scanner.nextLine().toLowerCase();

        System.out.print("Enter Initial Deposit Amount: $"); // Changed to print
        double initialDeposit = -1;
        if (scanner.hasNextDouble()) {
            initialDeposit = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Please enter a valid deposit amount.");
            scanner.next(); // Clear invalid input
            scanner.nextLine(); // Clear the newline character
            return; // Exit the method if input is invalid
        }
        scanner.nextLine(); // Consume newline after initialDeposit

        if (initialDeposit < 0) {
            System.out.println("Initial deposit must be a positive amount.");
            return;
        }

        if ("savings".equals(type)) {
            System.out.print("Enter Interest Rate (Ex., 3.2 for 3.2%): "); // Changed to print
            double interestRate = -1;
            if (scanner.hasNextDouble()) {
                interestRate = scanner.nextDouble();
            } else {
                System.out.println("Invalid rate. Please enter a number.");
                scanner.next();
                scanner.nextLine();
                return;
            }
            scanner.nextLine(); // Clear the newline character
            bank.createSavingsAccount(name, initialDeposit, interestRate);
        } else if ("checking".equals(type)) { // Added else if for proper logic flow
            System.out.print("Enter Overdraft Limit: $"); // Changed to print
            double overDraftLimit = -1;
            if (scanner.hasNextDouble()){
                overDraftLimit = scanner.nextDouble();
                scanner.nextLine(); // Consume the leftover newline

                if (overDraftLimit < 0) {
                    System.out.println("Overdraft limit cannot be negative.");
                    return;
                }
                bank.createCheckingAccount(name, initialDeposit, overDraftLimit); // This creates the account
            } else {
                System.out.println("Invalid limit. Please enter a number.");
                scanner.next(); // clear invalid input
                scanner.nextLine(); // clear newline
                return;
            }
        } else { // Added else for invalid account type
            System.out.println("Invalid account type. Account creation failed.");
        }
    }

    private static void handleDeposit() {
        System.out.println("\n--- Deposit Money ---");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();

        System.out.print("Enter Deposit Amount: $");
        double amount = -1;

        if (scanner.hasNextDouble()) {
            amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline after the number
        } else {
            System.out.println("Invalid input. Please enter a valid deposit amount.");
            scanner.next(); // Clear invalid input
            scanner.nextLine(); // Clear the newline character
            return;
        }

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        bank.performDeposit(accountNumber, amount);
        // Removed: System.out.println("Deposit successful."); // Let Account class handle success/failure messages
    }

    private static void handleWithdraw() {
        System.out.println("\n--- Withdraw Money ---");

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();

        System.out.print("Enter Withdraw Amount: $");
        double amount = -1;

        if (scanner.hasNextDouble()) {
            amount = scanner.nextDouble();
            scanner.nextLine(); // Clear the newline
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next(); // Clear invalid input
            scanner.nextLine(); // Clear newline
            return;
        }

        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }

        bank.performWithdrawal(accountNumber, amount);
        // Removed: System.out.println("Withdrawal successful."); // Let Account class handle success/failure messages
    }

    private static void handleCheckBalance() {
        System.out.println("\n--- Check Account Balance/Details ---");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        Account account = bank.findAccount(accNum);
        if (account != null) {
            account.displayAccountInfo(); // This will polymorphically display the correct details
        }
        // The "Account not found" message is handled by bank.findAccount()
    }
}