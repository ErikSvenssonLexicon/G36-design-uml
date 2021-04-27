package org.example.model;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {
    private String id;
    private Integer amount;
    private Product product;

    public OrderItem(String id, Integer amount, Product product) {
        if(id == null) throw new IllegalArgumentException("Id was null");
        this.id = id;
        setAmount(amount);
        setProduct(product);
    }

    public OrderItem(Integer amount, Product product) {
        this(UUID.randomUUID().toString(), amount, product);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        if(amount == null) amount = 0;
        if(amount < 0) throw new IllegalArgumentException("amount is not allowed to be negative");
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getItemPriceTotal(){
        return product.getPrice().multiply(BigDecimal.valueOf(amount));
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
