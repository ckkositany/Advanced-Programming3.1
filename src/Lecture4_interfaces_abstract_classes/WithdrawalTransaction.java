package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private final double shortFallAmount = 0;
    private boolean isReversed = false;
    private BankAccount associatedAccount;

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }

    // Method to reverse the transaction


    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this);
    }


    // Overloaded apply() method with exception handling
    @Override
    // Overloaded apply() method with exception handling
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

    // Apply method using try-catch-finally
    public void applyWithHandling(BankAccount ba) {
        try {
            apply(ba);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }

    // Reverse the transaction
    public boolean reverse() {
        if (isReversed) {
            System.out.println("Transaction has already been reversed.");
            return false;
        }

        if (associatedAccount == null) {
            System.out.println("Transaction was not applied to any account.");
            return false;
        }

        // Reverse full or partial withdrawal
        double reversalAmount = getAmount() - shortfallAmount; // Amount to add back
        associatedAccount.setBalance(associatedAccount.getBalance() + reversalAmount);
        isReversed = true; // Mark transaction as reversed
        System.out.println("Withdrawal of $" + reversalAmount + " has been reversed. New balance: $" + associatedAccount.getBalance());
        return true;
    }

    public double getShortfallAmount() {
        return shortfallAmount;
    }
}




