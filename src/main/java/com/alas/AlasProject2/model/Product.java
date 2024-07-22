package com.alas.AlasProject2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product" , fetch = FetchType.LAZY)
    private ProductDetails productDetails;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    @JsonIgnore // This ensures cartsList is not included in the JSON response
    private List<ShoppingCarts> cartsList;
}
