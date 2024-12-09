import Lecture4_interfaces_abstract_classes.BankAccount;
import Lecture4_interfaces_abstract_classes.BaseTransaction;
import Lecture4_interfaces_abstract_classes.DepositTransaction;
import Lecture4_interfaces_abstract_classes.WithdrawalTransaction;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a BankAccount object
        BankAccount account = new BankAccount(100); // Initial balance: $100
        System.out.println("Initial Account Balance: $" + account.getBalance());

        // Step 2: Create a DepositTransaction object
        Calendar date1 = Calendar.getInstance();
        DepositTransaction deposit = new DepositTransaction(50, date1); // Deposit $50

        // Step 3: Create a WithdrawalTransaction object
        Calendar date2 = Calendar.getInstance();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(30, date2); // Withdraw $30

        // Step 4: Test apply() method using BaseTransaction reference (Type Casting)
        BaseTransaction baseDeposit = deposit; // Casting DepositTransaction to BaseTransaction
        BaseTransaction baseWithdrawal = withdrawal; // Casting WithdrawalTransaction to BaseTransaction

        try {
            // Apply deposit and test functionality
            baseDeposit.apply(account); // Should succeed
            System.out.println("After Deposit: $" + account.getBalance());

            // Apply withdrawal and test functionality
            baseWithdrawal.apply(account); // Should succeed
            System.out.println("After Withdrawal: $" + account.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Step 5: Test invalid deposit and withdrawal scenarios
        try {
            BaseTransaction invalidDeposit = new DepositTransaction(-20, date1); // Invalid deposit
            invalidDeposit.apply(account); // Should throw InvalidDepositAmountException
        } catch (Exception e) {
            System.out.println("Invalid Deposit Error: " + e.getMessage());
        }

        try {
            BaseTransaction invalidWithdrawal = new WithdrawalTransaction(200, date2); // Overdraft attempt
            invalidWithdrawal.apply(account); // Should throw InsufficientFundsException
        } catch (Exception e) {
            System.out.println("Insufficient Funds Error: " + e.getMessage());
        }

        // Step 6: Test reversal of a withdrawal transaction
        withdrawal.reverse(); // Reverse the $30 withdrawal
        System.out.println("After Reversing Withdrawal: $" + account.getBalance());
    }
}
