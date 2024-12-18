package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

/**
 * Interface for defining the structure of financial transactions.
 * Any class implementing this interface is expected to provide concrete implementations
 * for retrieving transaction-specific details such as amount, date, and unique identifier.
 *
 * @author kositanyck
 * @since 1.0.0
 */
public interface TransactionInterface {

    /**
     * Retrieves the amount associated with the transaction.
     *
     * @return double - The amount involved in the transaction.
     */
    double getAmount();

    /**
     * Retrieves the date of the transaction.
     *
     * @return Calendar - The date when the transaction occurred.
     */
    Calendar getDate();

    /**
     * Retrieves a unique identifier for the transaction.
     *
     * @return String - A unique ID for the transaction.
     */
    String getTransactionID();

}
