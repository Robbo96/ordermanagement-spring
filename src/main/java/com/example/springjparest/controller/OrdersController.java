package com.example.springjparest.controller;

import com.example.springjparest.entity.MenuOrder;
import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.error.EntityNotFoundException;
import com.example.springjparest.service.ItemService;
import com.example.springjparest.service.OrderItemService;
import com.example.springjparest.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {

    private final OrdersService ordersService;

    private final OrderItemService orderItemService;

    @Autowired
    public OrdersController(OrdersService ordersService, OrderItemService orderItemService) {
        this.ordersService = ordersService;
        this.orderItemService = orderItemService;
    }

    @GetMapping("/orders")
    public List<MenuOrder> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public MenuOrder getOrderById(@PathVariable("id") Long orderId) throws EntityNotFoundException {
        return ordersService.getOrderById(orderId);
    }

    @PostMapping
    public MenuOrder saveOrder(@RequestBody MenuOrder order){
        return ordersService.saveOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrderById(@PathVariable("id") Long orderId) {
        ordersService.deleteOrderById(orderId);
        return "Order deleted Successfully!";
    }

    @DeleteMapping()
    public String deleteCompletedOrders() {
        List<MenuOrder> menuOrder = ordersService.getAllOrders();
        ordersService.deleteAllCompleteOrders(menuOrder);
        return "Completed orders deleted!";
    }

    @PutMapping("/{orderId}/orderItems/{orderItemId}")
    MenuOrder addItemToOrder(
            @PathVariable Long orderId,
            @PathVariable Long orderItemId

    ) throws EntityNotFoundException {
        MenuOrder menuOrder = ordersService.getOrderById(orderId);
        OrderItem orderItem = orderItemService.findById(orderItemId);
        menuOrder.addOrderItem(orderItem);
        return ordersService.saveOrder(menuOrder);

    }

    @PutMapping("/orders/{id}")
    public MenuOrder updateOrder(@PathVariable("id") Long orderId,
                                 @RequestBody MenuOrder menuOrder){
        return ordersService.updateOrder(orderId, menuOrder);
    }


}
