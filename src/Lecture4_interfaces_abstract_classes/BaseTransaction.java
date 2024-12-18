package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * Abstract class representing the foundation for financial transactions.
 * Implements the {@link TransactionInterface} and provides a template for specific transaction types like deposits and withdrawals.
 * Defines common attributes such as amount, date, and transaction ID.
 *
 * @author YourName
 * @since 1.0
 */
public abstract class BaseTransaction implements TransactionInterface {

    private final int amount; // The transaction amount
    private final Calendar date; // The date of the transaction
    private final String transactionID; // Unique identifier for the transaction

    /**
     * Constructs a BaseTransaction object with the specified amount and date.
     *
     * @param amount int - The amount of the transaction. Must be non-negative.
     * @param date   Calendar - The date of the transaction. Cannot be null.
     * @throws IllegalArgumentException if the date is null or amount is invalid.
     */
    public BaseTransaction(int amount, @NotNull Calendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copying of the date object
        int uniq = (int) (Math.random() * 10000); // Generate a random unique identifier
        transactionID = date.toString() + uniq;
    }

    /**
     * Retrieves the transaction amount.
     *
     * @return double - The transaction amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retrieves the transaction date.
     *
     * @return Calendar - A copy of the transaction date to ensure immutability.
     */
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copying
    }

    /**
     * Retrieves the unique transaction ID.
     *
     * @return String - The unique identifier for this transaction.
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Abstract method to print the transaction details.
     * Subclasses must implement this method to provide specific details for their transactions.
     */
    public abstract void printTransactionDetails();

    /**
     * Abstract method to apply the transaction to a bank account.
     * Subclasses must implement this method to define their specific application logic.
     *
     * @param ba BankAccount - The bank account to which the transaction will be applied.
     * @throws Exception if an error occurs while applying the transaction (e.g., insufficient funds).
     */
    public abstract void apply(BankAccount ba) throws Exception;
}
