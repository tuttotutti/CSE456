package vn.edu.eiu.cse465.services;

import vn.edu.eiu.cse465.entities.PaymentMethod;

public class PaymentService {
    private PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.makePayment(amount);
    }
}
