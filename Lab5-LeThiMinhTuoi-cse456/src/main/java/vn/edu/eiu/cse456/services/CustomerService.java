package vn.edu.eiu.cse456.services;

import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.entities.Customer;
import vn.edu.eiu.cse456.entities.Invoice;
import vn.edu.eiu.cse456.repo.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;
    private PDFPrinter pdfPrinter;

    public CustomerService(CustomerRepo customerRepo, PDFPrinter pdfPrinter) {
        this.customerRepo = customerRepo;
        this.pdfPrinter = pdfPrinter;
    }

    public void save(Customer c){
        CustomerRepo.save(c);
    }

    public void update(Customer c){
        CustomerRepo.update(c);
    }

    public void delete(Customer c){
        CustomerRepo.delete(c);
    }

    public List<Customer> findAll(){
        return CustomerRepo.findAll();
    }

    public Customer findById(long id){
        return CustomerRepo.findCustomerById(id);
    }

    public List<Customer> findByName(String name){
        return CustomerRepo.findCustomerByName(name);
    }

    public void exportInvoiceToPdf(Invoice invoice) {
        pdfPrinter.printInvoice(invoice);
    }
}
