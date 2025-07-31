package vn.edu.eiu.cse456.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_invoice")
public class Invoice {
    @Id
    @Column(name = "InvoiceID", nullable = false, columnDefinition = "NVARCHAR(100)")
    private long id;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    public Invoice(long id,LocalDate date) {
        this.id = id;
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "invoice")
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
        p.setInvoice(this);
    }
}
