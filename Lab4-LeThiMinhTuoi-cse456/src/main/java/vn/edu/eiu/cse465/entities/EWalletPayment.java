package vn.edu.eiu.cse465.entities;

public class EWalletPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using E-Wallet.");
    }
}
