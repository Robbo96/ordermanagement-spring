package com.example.springjparest.service;

import com.example.springjparest.entity.MenuOrder;
import com.example.springjparest.error.EntitiyNotFoundException;
import com.example.springjparest.repository.OrdersRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public MenuOrder saveOrder(@Validated @RequestBody MenuOrder order) {
        return ordersRepository.save(order);
    }

    @Override
    public MenuOrder getOrderById(@PathVariable Long orderId) throws EntitiyNotFoundException {
        Optional<MenuOrder> orders = ordersRepository.findById(orderId);

        if(orders.isEmpty()) {
            throw new EntitiyNotFoundException("Order doesn't exist.");
        }

        return orders.get();
    }

    @Override
    public List<MenuOrder> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public void deleteOrderById(Long orderId) {
        ordersRepository.deleteById(orderId);
    }

    @Override
    public MenuOrder updateOrder(Long orderId, MenuOrder menuOrder) {
        MenuOrder menuOrderDB = ordersRepository.findById(orderId).get(); //exception handling

        if(menuOrder.isMenuOrderCompleted()) {
            menuOrderDB.setMenuOrderCompleted(menuOrder.isMenuOrderCompleted());
        }
        return ordersRepository.save(menuOrderDB);
    }

    @Override
    public void deleteAllCompleteOrders(List<MenuOrder> menuOrder) {
        for (MenuOrder order : menuOrder){
            if (order.isMenuOrderCompleted()) { //typo
                ordersRepository.deleteById(order.getOrderId());
            }
        }
    }

}
