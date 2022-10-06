package com.example.springjparest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Builder
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    //@JsonIgnore
    //@ManyToMany(mappedBy="items")
    //private Set<MenuOrder> orders = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "menuItem")
    private Set<OrderItem> orderItems = new HashSet<>();

    private String itemName;
    private String itemCategory;
    private int price;



    public MenuItem(Long itemId, String itemName, String itemCategory, int price, Set<OrderItem> orderItems) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.price = price;
        this.orderItems = orderItems;
        //this.menuOrder = menuOrder;
    }

    public MenuItem() {

    }
    /*
    public Set<MenuOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<MenuOrder> orders) {
        this.orders = orders;
    }

     */

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "itemName='" + itemName + '\'' +
                ", itemCategory='" + itemCategory + '\'' +
                ", price=" + price +
                '}';
    }
}
