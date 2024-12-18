import Lecture4_interfaces_abstract_classes.BankAccount;
import Lecture4_interfaces_abstract_classes.BaseTransaction;
import Lecture4_interfaces_abstract_classes.DepositTransaction;
import Lecture4_interfaces_abstract_classes.WithdrawalTransaction;

import java.util.Calendar;

/**
 * Main class to demonstrate the functionality of BankAccount, DepositTransaction,
 * WithdrawalTransaction, and their interactions.
 * This class includes:
 * - Creating and testing DepositTransaction and WithdrawalTransaction objects.
 * - Demonstrating exception handling for invalid transactions.
 * - Reversing a withdrawal transaction and verifying the balance.
 *
 * @author kositanyck
 * @see BankAccount
 * @see BaseTransaction
 * @see DepositTransaction
 * @see WithdrawalTransaction
 * @since 1.0.0
 */
public class Main {
    /**
     * Entry point of the program.
     * Demonstrates the creation of transactions, their application to a bank account,
     * error handling for invalid scenarios, and transaction reversal.
     *
     * @param args command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {

        BankAccount account = new BankAccount(100); // Initial balance: $100
        System.out.println("Initial Account Balance: $" + account.getBalance());


        Calendar date1 = Calendar.getInstance();
        DepositTransaction deposit = new DepositTransaction(50, date1); // Deposit $50


        Calendar date2 = Calendar.getInstance();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(30, date2); // Withdraw $30


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


        withdrawal.reverse(); // Reverse the $30 withdrawal
        System.out.println("After Reversing Withdrawal: $" + account.getBalance());
    }
}
