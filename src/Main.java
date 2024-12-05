import Lecture4_interfaces_abstract_classes.BankAccount;
import Lecture4_interfaces_abstract_classes.BaseTransaction;
import Lecture4_interfaces_abstract_classes.DepositTransaction;
import Lecture4_interfaces_abstract_classes.WithdrawalTransaction;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Bank account object
        BankAccount account = new BankAccount(100);
        System.out.println("Initial bank account balance: $" + account.getBalance());

        // Deposit Transaction Instance
        Calendar C1 = Calendar.getInstance();
        DepositTransaction deposit = new DepositTransaction(50, C1);

        //Withdrawal txn instance
        Calendar C2 = Calendar.getInstance();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(30, C2);

        // Testing the apply() method with ref to BaseTransaction
        BaseTransaction baseDeposit = deposit;
        BaseTransaction baseWithdrawal = withdrawal;

        //Apply deposit and withdrawal and test functionality
        try {
            baseDeposit.apply(account);
            System.out.println("After deposit: $" + account.getBalance());

            baseWithdrawal.apply(account);
            System.out.println("After withdrawal: $" + account.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Testing Invalid Deposit And Withdrawal cases
        try {
            BaseTransaction invalidDeposit = new DepositTransaction(-50, C1);
            invalidDeposit.apply(account);
        } catch (Exception e) {
            System.out.println("Invalid Deposit Error: " + e.getMessage());
        }

        try {
            BaseTransaction invalidWithdrawal = new WithdrawalTransaction(300, C2);
            invalidWithdrawal.apply(account);
        } catch (Exception e) {
            System.out.println("Insufficient Funds Error: " + e.getMessage());
        }

        //Testing reversal of withdrawal txn
        withdrawal.reverse();
        System.out.println("After Reversing Withdrawal: $" + account.getBalance());


    }
}