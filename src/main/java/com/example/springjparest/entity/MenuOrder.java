package com.example.springjparest.entity;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class MenuOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private boolean isMenuOrderComplete;
    @ManyToMany
    @JoinTable(name = "menuorder_orderitem",
            joinColumns = { @JoinColumn(name = "fk_menuorder") },
            inverseJoinColumns = { @JoinColumn(name = "fk_orderitem") })
    Set<OrderItem> orderItems = new HashSet<>();
    //private List<MenuItem> itemList = new ArrayList<>();

    public MenuOrder(Long orderId, boolean isMenuOrderComplete, Set<OrderItem> orderItems) {
        this.orderId = orderId;
        this.isMenuOrderComplete = isMenuOrderComplete;
        this.orderItems = orderItems;
    }

    public MenuOrder() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public boolean isIsMenuOrderComplete() {
        return isMenuOrderComplete;
    }

    public void setIsMenuOrderComplete(boolean orderStatus) {
        this.isMenuOrderComplete = orderStatus;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    /*
    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public Set<MenuItem> getItems() {
        return items;
    }

    public void setItems(Set<MenuItem> items) {
        this.items = items;
    }

     */

    public void addOrderItem(OrderItem item){
        orderItems.add(item);
    }
/*
    public void addItems(MenuItem item) {
        items.add(item);
    }

 */
}
