package org.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    public static class Builder{
        private String id;
        private String productName;
        private Double price;

        public Builder(String id){
            this.id = id;
        }

        public Builder withProductName(String productName){
            this.productName = productName;
            return this;
        }

        public Builder withPrice(Double price){
            this.price = price;
            return this;
        }

        public Product build(){
            return new Product(id, productName, price);
        }
    }



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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
