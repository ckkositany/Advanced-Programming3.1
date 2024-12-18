package Lecture4_interfaces_abstract_classes;

/**
 * Custom exception to handle invalid deposit amounts in financial transactions.
 * This exception is thrown when a deposit amount is less than the required minimum (e.g., negative values).
 *
 * @author kositanyck
 * @since 1.0.0
 */
public class InvalidDepositAmountException extends Exception {

    /**
     * Constructs an InvalidDepositAmountException with a specific error message.
     *
     * @param message String - The error message providing details about the invalid deposit amount.
     */
    public InvalidDepositAmountException(String message) {
        super(message);
    }
}
