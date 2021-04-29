package org.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String id;
    private String productName;
    private Double price;

    public Product(String id, String productName, Double price) {
        if(id == null) throw new RuntimeException("String id was null");
        this.id = id;
        setProductName(productName);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName == null) throw new RuntimeException("String productName was null");
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(price);
    }

    public void setPrice(Double price) {
        if(price == null) throw new RuntimeException("Double price was null");
        if(price < 0) throw new RuntimeException("Double price is a negative value");
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productName, product.productName) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, price);
    }
}
