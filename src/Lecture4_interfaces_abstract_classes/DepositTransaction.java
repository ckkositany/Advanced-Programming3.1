package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction: " + this);
    }

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