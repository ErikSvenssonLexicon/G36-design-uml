package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    public static final String ID = "testId";
    public static final String PRODUCT_NAME = "testProduct";
    public static final double PRICE = 35.90;
    private Product testObject;

    @BeforeEach
    void setUp() {
        testObject = new Product(
                ID, PRODUCT_NAME, PRICE
        );
    }

    @Test
    @DisplayName("testObject has correct data")
    void testObjectSuccessfullyInstantiated(){
        BigDecimal expectedPrice = BigDecimal.valueOf(PRICE);
        assertNotNull(testObject);
        assertEquals(ID, testObject.getId());
        assertEquals(PRODUCT_NAME, testObject.getProductName());
        assertEquals(expectedPrice, testObject.getPrice());
    }

    @Test
    @DisplayName("copy of testObject equals true and hashcode same")
    void copy_equals_testObject() {
        Product copy = new Product(ID, PRODUCT_NAME, PRICE);

        assertEquals(copy, testObject);
        assertEquals(copy.hashCode(), testObject.hashCode());
    }
}