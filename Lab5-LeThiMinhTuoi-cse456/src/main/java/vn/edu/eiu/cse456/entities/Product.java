package vn.edu.eiu.cse456.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @Column(name = "ProductID")
    private long id;

    @Column(name = "ProductName", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "stock", nullable = false)
    private int stock;

    public Product(long id,String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "InvoiceID")
    private Invoice invoice;
}
