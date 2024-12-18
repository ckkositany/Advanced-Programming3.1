package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * WithdrawalTransaction class.
 * Represents a withdrawal transaction applied to a bank account.
 * Handles scenarios where the balance is insufficient and allows reversing the transaction.
 *
 * @author kositanyck
 * @see BaseTransaction
 * @since 1.0.0
 */
public class WithdrawalTransaction extends BaseTransaction {
    private final double shortFallAmount = 0;
    private boolean isReversed = false;
    private double shortfallAmount = 0;
    private BankAccount associatedAccount;

    /**
     * Constructor for creating a WithdrawalTransaction instance.
     *
     * @param amount The amount to be withdrawn. Must be non-negative.
     * @param date   The date of the transaction. Must not be null.
     */
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     * Validates if the deposit amount is non-negative.
     *
     * @param amt The amount to validate.
     * @return true if the amount is valid (non-negative), false otherwise.
     */
    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }

    /**
     * Prints the details of the withdrawal transaction.
     * Includes metadata such as amount and date.
     */
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this);
    }

    /**
     * Applies the withdrawal transaction to a bank account.
     * If the account has insufficient balance, withdraws all available balance and records the shortfall amount.
     *
     * @param ba The bank account to which the withdrawal will be applied. Must not be null.
     * @throws InsufficientFundsException Thrown if the account balance is zero or negative.
     * @see BankAccount#setBalance(double)
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() <= 0) {
            throw new InsufficientFundsException("Cannot withdraw from an account with zero or negative balance.");
        }

        double currentBalance = ba.getBalance();
        if (currentBalance >= getAmount()) {
            ba.setBalance(currentBalance - getAmount());
            associatedAccount = ba;
            System.out.println("Withdrawal of $" + getAmount() + " applied. New balance: $" + ba.getBalance());
        } else {
            shortfallAmount = getAmount() - currentBalance;
            ba.setBalance(0);
            associatedAccount = ba;
            System.out.println("Insufficient funds. Withdrawn $" + currentBalance + " from the account. Shortfall: $" + shortfallAmount);
        }
    }

    /**
     * Applies the withdrawal transaction to a bank account with exception handling.
     * Wraps the apply() method in a try-catch-finally block.
     *
     * @param ba The bank account to which the withdrawal will be applied. Must not be null.
     */
    public void applyWithHandling(BankAccount ba) {
        try {
            apply(ba);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }

    /**
     * Reverses the withdrawal transaction.
     * Restores the account balance by adding back the withdrawn amount or partial amount in case of a shortfall.
     *
     * @return true if the reversal was successful, false otherwise.
     */
    public boolean reverse() {
        if (isReversed) {
            System.out.println("Transaction has already been reversed.");
            return false;
        }

        if (associatedAccount == null) {
            System.out.println("Transaction was not applied to any account.");
            return false;
        }

        double reversalAmount = getAmount() - shortfallAmount; // Amount to add back
        associatedAccount.setBalance(associatedAccount.getBalance() + reversalAmount);
        isReversed = true; // Mark transaction as reversed
        System.out.println("Withdrawal of $" + reversalAmount + " has been reversed. New balance: $" + associatedAccount.getBalance());
        return true;
    }

    /**
     * Retrieves the shortfall amount from the withdrawal transaction.
     * The shortfall is the difference between the requested amount and the account's available balance.
     *
     * @return The shortfall amount as a double.
     */
    public double getShortfallAmount() {
        return shortfallAmount;
    }
}
