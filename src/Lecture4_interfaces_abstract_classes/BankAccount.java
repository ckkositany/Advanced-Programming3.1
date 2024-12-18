package Lecture4_interfaces_abstract_classes;

/**
 * BankAccount class.
 * Represents a bank account with a balance. Provides methods to access and update the balance.
 *
 * @author kositanyck
 * @since 1.0.0
 */
public class BankAccount {
    private double balance;

    /**
     * Constructor for creating a BankAccount instance with an initial balance.
     *
     * @param balance The initial balance of the bank account. Must be non-negative.
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the current balance of the bank account.
     *
     * @return The current balance as a double value.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Updates the balance of the bank account.
     *
     * @param balance The new balance to be set. Must be non-negative.
     *                Ensures that the bank account reflects the updated balance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
