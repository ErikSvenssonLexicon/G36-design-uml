package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProductOrder {

    private String id;
    private String status;
    private List<OrderItem> orderItems;
    private Address shippingAddress;

    public ProductOrder(String id, String status, List<OrderItem> orderItems, Address shippingAddress) {
        this.id = id;
        setStatus(status);
        setOrderItems(orderItems);
        setShippingAddress(shippingAddress);
    }

    public ProductOrder(String status) {
        this(UUID.randomUUID().toString(), status, new ArrayList<>(), null);
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        if(orderItems == null) orderItems = new ArrayList<>();
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        if(orderItems == null) orderItems = new ArrayList<>();
        if(orderItems.isEmpty()){
            if(this.orderItems != null){
                for(OrderItem orderItem : this.orderItems){
                    orderItem.setProductOrder(null);
                }
            }
        }else {
            for(OrderItem orderItem : orderItems){
                orderItem.setProductOrder(this);
            }
        }
        this.orderItems = orderItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void addOrderItem(OrderItem orderItem){
        if(orderItem == null) throw new IllegalArgumentException();
        if(orderItems == null) orderItems = new ArrayList<>();

        //Using contains (internally uses equals on OrderItem object)
        if(!orderItems.contains(orderItem)){
            orderItems.add(orderItem);
            orderItem.setProductOrder(this);
        }
    }

    public void removeOrderItem(OrderItem orderItem){
        if(orderItem == null) throw new IllegalArgumentException();
        if(orderItems == null) orderItems = new ArrayList<>();

        orderItems.remove(orderItem);
        orderItem.setProductOrder(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
