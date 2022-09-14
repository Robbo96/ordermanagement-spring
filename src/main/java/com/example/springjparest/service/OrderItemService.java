package com.example.springjparest.service;

import com.example.springjparest.entity.OrderItem;

public interface OrderItemService {

    OrderItem findById(Long itemId);

    OrderItem saveItem(OrderItem orderItem);
}
