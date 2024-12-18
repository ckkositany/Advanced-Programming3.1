package Lecture4_interfaces_abstract_classes;

/**
 * Custom exception class to handle insufficient funds scenarios in a bank account.
 * This exception is thrown when a withdrawal attempt exceeds the available balance
 * or when the account has zero or negative balance.
 *
 * @author kositanyck
 * @since 1.0.0
 */
public class InsufficientFundsException extends Exception {

    /**
     * Constructs a new InsufficientFundsException with a specified error message.
     *
     * @param message The error message describing the cause of the exception.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
