# Java Banking Application

A console-based banking application built in Java demonstrating core Object-Oriented Programming (OOP) principles like inheritance and polymorphism.

## Features

*   **Account Management:** Create and manage different account types (Savings and Checking).
*   **Transactions:** Perform deposits and withdrawals for individual accounts.
*   **Account Inquiry:** View detailed information for specific accounts (account number, holder, balance, and type-specific details like interest rate or overdraft limit).
*   **Bank Overview:** Display a comprehensive list of all accounts currently managed by the bank.
*   **User Experience:** Includes basic input validation and informative user feedback.

## Key OOP Concepts Demonstrated

*   **Encapsulation:** Achieved by utilizing `private` fields for account data (`balance`, `accountNumber`, `accountHolderName`) and controlling access through `public` methods (`deposit()`, `withdraw()`, getters). This protects the internal state of objects from external, unauthorized modification.
*   **Inheritance:** Designed an `abstract Account` class that serves as a common blueprint. `SavingsAccount` and `CheckingAccount` classes `extend` `Account`, inheriting shared attributes and behaviors while implementing their unique functionalities. This promotes code reusability and a logical hierarchy.
*   **Polymorphism:** Demonstrated through the `Bank` class's interactions with `Account` objects. Methods like `performDeposit()` and `performWithdrawal()` in the `Bank` class, or `displayAccountInfo()` when iterating through accounts, call the appropriate `deposit()`, `withdraw()`, or `displayAccountInfo()` method based on the *actual runtime type* (Savings or Checking) of the `Account` object.
*   **Abstraction:** The `abstract Account` class defines a common interface (e.g., `deposit()`, `withdraw()`, `displayAccountInfo()`) that all concrete account types must implement, hiding the specific implementation details of how each account type handles these operations from the higher-level `Bank` logic.
*   **Data Structures:** Utilized `java.util.ArrayList` within the `Bank` class to dynamically store and manage a collection of diverse `Account` objects, allowing the bank to scale with varying numbers of customers.

## How to Run the Application

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/BSindjui1/Java-Banking-App
    ```
2.  **Navigate to Project Directory:**
    ```bash
    cd Java-Banking-App
    ```
3.  **Compile the Java Files:**
    ```bash
    javac *.java
    ```
4.  **Run the Application:**
    ```bash
    java BankingApp
    ```

## Future Enhancements (Ideas for further development)

*   **Persistence:** Implement file I/O (e.g., using `ObjectOutputStream`/`ObjectInputStream` or simple text files) to save and load account data, so it persists between application runs.
*   **Transaction History:** Add functionality to record and display a history of deposits and withdrawals for each account.
*   **Fund Transfers:** Introduce an option to transfer funds between two accounts.
*   **Advanced Error Handling:** Utilize Java's exception handling (`try-catch` blocks) for more robust error management.
*   **Graphical User Interface (GUI):** Develop a GUI using JavaFX or Swing to replace the console interface, providing a more user-friendly experience.

## Author

*   **[Brandon Sindjui]** - [Link to your LinkedIn Profile](https://www.linkedin.com/in/brandon-sindjui-349916253/)