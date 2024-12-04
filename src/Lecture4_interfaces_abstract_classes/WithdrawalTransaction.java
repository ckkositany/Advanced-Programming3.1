package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }

    // Method to reverse the transaction
    public boolean reverse() {
        return true;
    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction: " + this);
    }

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance > getAmount()) {
            double new_balance = curr_balance - getAmount();
            ba.setBalance(new_balance);
        }
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */


    // Method to reverse the withdrawal transaction
    
    public boolean reverse() {
        if (isReversed) {
            System.out.println("Transaction has already been reversed.");
            return false;
        }

        if (associatedAccount == null) {
            System.out.println("Transaction was not applied to any account.");
            return false;
        }

        // Add the amount back to the associated account
        double new_balance = associatedAccount.getBalance() + getAmount();
        associatedAccount.setBalance(new_balance);
        isReversed = true; // Mark the transaction as reversed
        System.out.println("Withdrawal of $" + getAmount() + " has been reversed. New balance: $" + associatedAccount.getBalance());
        return true;
    }
}
