package org.example.data;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    //We need to make ProductRepository a "Singleton"
    //A Singleton is an object with only one instance

    //The ONLY allowed instance of ProductRepository
    private static final ProductRepository INSTANCE;

    static {
        INSTANCE = new ProductRepository();
    }

    public static ProductRepository getInstance(){
        return INSTANCE;
    }

    private ProductRepository() {
        productList = new ArrayList<>();
    }

    //End of singleton code



    private final List<Product> productList;

    public void clear(){
        productList.clear();
    }

    public Product persist(Product product){
        if(!productList.contains(product)){
            productList.add(product);
        }
        return product;
    }

    public Product findById(String id){
        for(Product product : productList){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll(){
        return new ArrayList<>(productList);
    }

    public List<Product> findByPriceBetween(double low, double high){
        List<Product> result = new ArrayList<>();
        for(Product product : productList){
            double price = product.getPrice().doubleValue();
            if(price >= low && price < high){
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findByProductName(String productName){
        List<Product> result = new ArrayList<>();
        for(Product product : productList){
            if(product.getProductName().equalsIgnoreCase(productName.trim())){
                result.add(product);
            }
        }
        return result;
    }

    public boolean remove(Product product){
        return productList.remove(product);
    }

}
