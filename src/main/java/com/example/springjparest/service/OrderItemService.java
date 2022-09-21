package com.example.springjparest.service;

import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.error.EntitiyNotFoundException;

public interface OrderItemService {

    OrderItem findById(Long itemId) throws EntitiyNotFoundException;

    OrderItem saveItem(OrderItem orderItem);
}
