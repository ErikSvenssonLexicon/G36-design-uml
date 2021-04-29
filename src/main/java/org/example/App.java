package org.example;

import org.example.model.Product;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Product product = new Product.Builder(UUID.randomUUID().toString())
                .withProductName("Frozen carbonite")
                .withPrice(245426d)
                .build();

        System.out.println(product);
    }

}
