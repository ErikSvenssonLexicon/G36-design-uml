package org.example.service;

import org.example.data.ProductRepository;
import org.example.model.Product;

import java.util.List;
import java.util.UUID;

public class ProductManager {

    private final ProductRepository productRepository;

    public ProductManager() {
        this.productRepository = ProductRepository.getInstance();
    }

    public Product create(String productName, Double price){
        Product product = new Product(
                UUID.randomUUID().toString(),
                productName,
                price
        );
        return productRepository.persist(product);
    }

    public Product update(String id, String productName, Double price){
        Product product = productRepository.findById(id);

        if(productName != null && !productName.isEmpty()){
            product.setProductName(productName);
        }
        if(price != null && price > 0){
            product.setPrice(price);
        }

        return product;
    }

    public boolean remove(String id){
        Product product = productRepository.findById(id);
        if(product != null){
            return productRepository.remove(product);
        }
        return false;
    }

    public Product findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByPriceBetween(double low, double high) {
        return productRepository.findByPriceBetween(low, high);
    }

    public List<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }
}
