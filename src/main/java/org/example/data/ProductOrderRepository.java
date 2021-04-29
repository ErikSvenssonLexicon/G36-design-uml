package org.example.data;

import org.example.model.OrderItem;
import org.example.model.Product;
import org.example.model.ProductOrder;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderRepository {
    //Singleton code start

    private static final ProductOrderRepository INSTANCE;

    static {
        INSTANCE = new ProductOrderRepository();
    }

    public static ProductOrderRepository getInstance(){
        return INSTANCE;
    }

    //Singleton code end


    private final List<ProductOrder> orders;

    private ProductOrderRepository() {
        this.orders = new ArrayList<>();
    }

    public void clear(){
        orders.clear();
    }


    public ProductOrder persist(ProductOrder productOrder){
        if(!orders.contains(productOrder)){
            orders.add(productOrder);
        }
        return productOrder;
    }

    public ProductOrder findById(String id){
        for(ProductOrder order : orders){
            if(order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }

    public List<ProductOrder> findAll(){
        return new ArrayList<>(orders);
    }

    public List<ProductOrder> findByContainsProductName(String productName){
        List<ProductOrder> result = new ArrayList<>();
        for(ProductOrder productOrder : orders){
            for(OrderItem orderItem : productOrder.getOrderItems()){
                Product product = orderItem.getProduct();
                if(product != null && product.getProductName().equalsIgnoreCase(productName)){
                    result.add(productOrder);
                }
            }
        }
        return result;
    }

    public List<ProductOrder> findByStatus(String status){
        List<ProductOrder> result = new ArrayList<>();
        for(ProductOrder order : orders){
            if(order.getStatus().equalsIgnoreCase(status)){
                result.add(order);
            }
        }
        return result;
    }

    public boolean remove(ProductOrder productOrder){
        return orders.remove(productOrder);
    }
}
