package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * DepositTransaction class.
 * Represents a deposit transaction applied to a bank account.
 * Provides functionality for validating deposit amounts and applying the deposit to an account balance.
 *
 * @author kositanyck
 * @see BaseTransaction
 * @since 1.0.0
 */
public class DepositTransaction extends BaseTransaction {

    /**
     * Constructor for creating a DepositTransaction instance.
     *
     * @param amount The deposit amount. Must be non-negative.
     * @param date   The date of the transaction. Must not be null.
     */
    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     * Validates if the deposit amount is non-negative.
     *
     * @param amt The amount to validate. Must be a double value.
     * @return true if the amount is valid (non-negative), false otherwise.
     */
    private boolean checkDepositAmount(double amt) {
        return amt >= 0;
    }

    /**
     * Prints the details of the deposit transaction.
     * This includes transaction metadata such as the amount and date.
     */
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction: " + this);
    }

    /**
     * Applies the deposit transaction to a bank account.
     * Updates the account's balance by adding the deposit amount.
     * Throws an exception if the deposit amount is invalid.
     *
     * @param ba The bank account to which the deposit will be applied. Must not be null.
     * @throws InvalidDepositAmountException Thrown if the deposit amount is negative.
     * @see BankAccount#setBalance(double)
     */
    @Override
    public void apply(@NotNull BankAccount ba) throws InvalidDepositAmountException {
        if (!checkDepositAmount(getAmount())) {
            throw new InvalidDepositAmountException("Invalid deposit amount: " + getAmount() + ". Amount must be non-negative.");
        }

        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);
        System.out.println("Deposit of $" + getAmount() + " applied. New balance: $" + ba.getBalance());
    }
}
