package com.example.springjparest.service;

import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.error.EntityNotFoundException;

public interface OrderItemService {

    OrderItem findById(Long itemId) throws EntityNotFoundException;

    OrderItem saveItem(OrderItem orderItem);
}
