package com.example.springjparest.service;

import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem findById(Long orderItemId) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(orderItemId);
        //Optional<OrderItem> orderItem = orderItemRepository.getById(orderItemId);
                //ispresent
        return orderItem.get();
    }

    @Override
    public OrderItem saveItem(@Validated @RequestBody OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}