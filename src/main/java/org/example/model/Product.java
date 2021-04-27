package org.example.model;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String productName;
    private Double price;

    public Product(String id, String productName, Double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(price);
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
