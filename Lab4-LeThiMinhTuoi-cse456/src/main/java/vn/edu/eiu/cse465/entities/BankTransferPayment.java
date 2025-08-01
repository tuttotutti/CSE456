package vn.edu.eiu.cse465.entities;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Bank Transfer.");
    }
}
