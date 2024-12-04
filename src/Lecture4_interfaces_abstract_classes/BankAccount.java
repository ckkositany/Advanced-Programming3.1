package Lecture4_interfaces_abstract_classes;

public class BankAccount {
    private double balance;

    /**
     *
     * @param balance the balance in the bank acc
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return double balance amouunt
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance update current balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
