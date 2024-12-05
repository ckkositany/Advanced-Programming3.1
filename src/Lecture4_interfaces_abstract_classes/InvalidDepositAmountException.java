package Lecture4_interfaces_abstract_classes;

public class InvalidDepositAmountException extends Exception {
    public InvalidDepositAmountException(String message) {
        super(message);
    }
}
