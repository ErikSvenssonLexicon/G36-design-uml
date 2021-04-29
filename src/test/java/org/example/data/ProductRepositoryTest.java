package org.example.data;

import org.example.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository testObject;

    public List<Product> getProducts(){
        return Arrays.asList(
                new Product("id1", "Laser Rifle", 999.90), //index 0
                new Product("id2", "Plasma Rifle", 1995.50), //index 1
                new Product("id3", "Plate armor", 600.99) //index 2
        );
    }

    @BeforeEach
    void setUp() {
        testObject = ProductRepository.getInstance();
        testObject.clear();

        for(Product product : getProducts()){
            testObject.persist(product);
        }
    }

    @Test
    void persist() {
        Product newItem = new Product(UUID.randomUUID().toString(), "Leather armor", 200d);
        int expectedSize = 4;

        Product result = testObject.persist(newItem);

        assertEquals(expectedSize, testObject.findAll().size());
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByPriceBetween() {
    }

    @Test
    void findByProductName() {
    }

    @Test
    void remove() {
    }
}