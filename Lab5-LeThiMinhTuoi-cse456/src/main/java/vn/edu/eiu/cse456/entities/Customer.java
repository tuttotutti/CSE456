package vn.edu.eiu.cse456.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_Customer")
public class Customer {
    @Id
    @Column(name = "CustomerID", nullable = false)
    private long id;

    @Column(name = "CustomerName", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String name;

    public Customer(long id,String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private List<Invoice> invoiceList = new ArrayList<>();

    public void addInvoice(Invoice invoice) {
        invoiceList.add(invoice);
        invoice.setCustomer(this);
    }
}
