package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.entity.MenuOrder;
import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.error.OrderNotFoundException;

import java.util.List;

public interface OrdersService {
    MenuOrder saveOrder(MenuOrder order);

    MenuOrder getOrderById(Long id) throws OrderNotFoundException;

    List<MenuOrder> getAllOrders();

    void deleteOrderById(Long orderId);

   MenuOrder updateOrder(Long orderId, MenuOrder menuOrder);

}
