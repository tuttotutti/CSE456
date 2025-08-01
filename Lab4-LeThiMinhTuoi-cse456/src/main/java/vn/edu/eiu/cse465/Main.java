package vn.edu.eiu.cse465;

import vn.edu.eiu.cse465.entities.EWalletPayment;
import vn.edu.eiu.cse465.entities.PaymentMethod;
import vn.edu.eiu.cse465.services.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentMethod method = new EWalletPayment();

        PaymentService service = new PaymentService(method);

        service.processPayment(100.01);
    }
}