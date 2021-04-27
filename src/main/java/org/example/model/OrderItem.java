package org.example.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class OrderItem {

    private final String id;
    private Integer amount;
    private Product product;
    private ProductOrder productOrder;

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

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) && Objects.equals(amount, orderItem.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}
