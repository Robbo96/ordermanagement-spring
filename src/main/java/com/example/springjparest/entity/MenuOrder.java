package com.example.springjparest.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MenuOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private boolean menuOrderCompleted;
    @ManyToMany
    @JoinTable(name = "menuorder_orderitem",
            joinColumns = { @JoinColumn(name = "fk_menuorder") },
            inverseJoinColumns = { @JoinColumn(name = "fk_orderitem") })
    Set<OrderItem> orderItems = new HashSet<>();
    //private List<MenuItem> itemList = new ArrayList<>();

    public MenuOrder(Long orderId, boolean isMenuOrderComplete, Set<OrderItem> orderItems) {
        this.orderId = orderId;
        this.menuOrderCompleted = isMenuOrderComplete;
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

    public boolean isMenuOrderCompleted() {
        return menuOrderCompleted;
    }

    public void setMenuOrderCompleted(boolean orderStatus) {
        this.menuOrderCompleted = orderStatus;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem item){
        orderItems.add(item);
    }

}
