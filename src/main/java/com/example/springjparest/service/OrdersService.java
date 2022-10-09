package com.example.springjparest.service;

import com.example.springjparest.entity.MenuOrder;
import com.example.springjparest.error.EntityNotFoundException;

import java.util.List;

public interface OrdersService {
    MenuOrder saveOrder(MenuOrder order);

    MenuOrder getOrderById(Long id) throws EntityNotFoundException;

    List<MenuOrder> getAllOrders();

    void deleteOrderById(Long orderId);

   MenuOrder updateOrder(Long orderId, MenuOrder menuOrder);

    void deleteAllCompleteOrders(List<MenuOrder> menuOrder);
}
