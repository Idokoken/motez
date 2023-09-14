package com.ndgrouops.motez.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    private String description;
    private String category;
    private String brand;
    private Double price;
    private Double rating;
    private Integer countInStock;
    private Integer numReviews;
    private String imgUrl;

    public Product(String name, String description, String category, String brand, Double price, Double rating,
                   Integer countInStock, Integer numReviews, String imgUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
        this.countInStock = countInStock;
        this.numReviews = numReviews;
        this.imgUrl = imgUrl;
    }
}
