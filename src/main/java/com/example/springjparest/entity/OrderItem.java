package com.example.springjparest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;

    @ManyToOne//(fetch = FetchType.LAZY)
    private MenuItem menuItem;
    //lazy-re tenni

    @JsonIgnore
    @ManyToMany(mappedBy="orderItems")
    private Set<MenuOrder> orders = new HashSet<>();
    private int itemQuantity;

    public OrderItem() {
    }

    public OrderItem(Long orderItemId, MenuItem menuItem, int itemQuantity) {
        this.orderItemId = orderItemId;
        this.menuItem = menuItem;
        this.itemQuantity = itemQuantity;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Set<MenuOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<MenuOrder> orders) {
        this.orders = orders;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "menuItem=" + menuItem +
                ", itemQuiantity=" + itemQuantity +
                '}';
    }
}
