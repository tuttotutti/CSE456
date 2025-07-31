package vn.edu.eiu.cse456.services;

import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.entities.Invoice;
import vn.edu.eiu.cse456.repo.InvoiceRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {
    public void save(Invoice invoice){
        InvoiceRepo.save(invoice);
    }

    public void update(Invoice invoice){
        InvoiceRepo.update(invoice);
    }

    public void delete(Invoice invoice){
        InvoiceRepo.delete(invoice);
    }

    public List<Invoice> findAll(){
        return InvoiceRepo.findAll();
    }

    public List<Invoice> findByDate(LocalDate date){
        return InvoiceRepo.findByDate(date);
    }
}
