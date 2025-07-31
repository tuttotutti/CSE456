package vn.edu.eiu.cse456;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.edu.eiu.cse456.entities.Customer;
import vn.edu.eiu.cse456.entities.Invoice;
import vn.edu.eiu.cse456.entities.Product;
import vn.edu.eiu.cse456.services.CustomerService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(vn.edu.eiu.lab5.AppConfig.class);

        Customer customer = new Customer(12435,"Emily Watson");

        Product laptop = new Product(294057,"Dell XPS 15", 1800.0, 1);
        Product mouse = new Product(9207457,"Logitech MX Master 3", 99.0, 2);
        Product monitor = new Product(30943874,"LG UltraFine 5K", 1299.99, 1);

        Invoice invoice = new Invoice(9357096,LocalDate.of(2025, 7, 20));
        invoice.addProduct(laptop);
        invoice.addProduct(mouse);
        invoice.addProduct(monitor);

        customer.addInvoice(invoice);

        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.save(customer);
        customerService.exportInvoiceToPdf(invoice);
    }
}
