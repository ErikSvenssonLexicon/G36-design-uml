package org.example.data;

import org.example.model.OrderItem;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderItemRepository {


    private static final OrderItemRepository INSTANCE;

    static {
        INSTANCE = new OrderItemRepository();
    }

    public static OrderItemRepository getInstance() {
        return INSTANCE;
    }

    private final List<OrderItem> orderItemList;

    private OrderItemRepository(){
        orderItemList = new ArrayList<>();
    }

    public void clear(){
        orderItemList.clear();
    }

    public OrderItem persist(OrderItem orderItem){
        if(!orderItemList.contains(orderItem)){
            orderItemList.add(orderItem);
        }
        return orderItem;
    }

    public List<OrderItem> findAll(){
        return new ArrayList<>(orderItemList);
    }

    public OrderItem findById(String id){
        for(OrderItem orderItem : orderItemList){
            if(orderItem.getId().equals(id)){
                return orderItem;
            }
        }
        return null;
    }

    public List<OrderItem> findByProductId(String productId){
        List<OrderItem> result = new ArrayList<>();
        for(OrderItem orderItem : orderItemList){
            Product product = orderItem.getProduct();
            if(product != null && product.getId().equals(productId)){
                result.add(orderItem);
            }
        }
        return result;
    }

    public boolean remove(OrderItem orderItem){
        return orderItemList.remove(orderItem);
    }

}
