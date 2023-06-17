package com.example.Express.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private Date createdOn;

    @Column(name = "TotalPrice")
    private Double price;

    @ManyToMany
    @JoinTable(name="Product_Order", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product;

    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "CustomerCnic")
    private Long customerCnic;
}
