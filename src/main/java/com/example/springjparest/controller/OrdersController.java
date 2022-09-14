package com.example.springjparest.controller;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.entity.MenuOrder;
import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.error.OrderNotFoundException;
import com.example.springjparest.service.ItemService;
import com.example.springjparest.service.OrderItemService;
import com.example.springjparest.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService ordersService;

    private ItemService itemService;

    private OrderItemService orderItemService;

    @Autowired
    public OrdersController(OrdersService ordersService, ItemService itemService, OrderItemService orderItemService) {
        this.ordersService = ordersService;
        this.itemService = itemService;
        this.orderItemService = orderItemService;
    }

    @GetMapping("/orders")
    public List<MenuOrder> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public MenuOrder getOrderById(@PathVariable("id") Long orderId) throws OrderNotFoundException {
        return ordersService.getOrderById(orderId);
    }

    @PostMapping
    public MenuOrder saveOrder(@RequestBody MenuOrder order){
        return ordersService.saveOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrderById(@PathVariable("id") Long orderId){
        ordersService.deleteOrderById(orderId);
        return "Order deleted Successfully!!";
    }

    @PutMapping("/{orderId}/orderItems/{orderItemId}")
    MenuOrder addItemToOrder(
            @PathVariable Long orderId,
            @PathVariable Long orderItemId

    ) throws OrderNotFoundException {
        MenuOrder menuOrder = ordersService.getOrderById(orderId);
        OrderItem orderItem = orderItemService.findById(orderItemId); //ezt getOne()-ra, deprecated mar
        menuOrder.addOrderItem(orderItem);
        return ordersService.saveOrder(menuOrder);

    }

    @PutMapping("/orders/{id}")
    public MenuOrder updateOrder(@PathVariable("id") Long orderId,
                                 @RequestBody MenuOrder menuOrder){
        return ordersService.updateOrder(orderId, menuOrder);
    }

    //ez csak id helyett névvel

    //updatemap(orders/id)

}
