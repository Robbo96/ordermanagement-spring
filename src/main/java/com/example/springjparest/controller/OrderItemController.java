package com.example.springjparest.controller;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.service.ItemService;
import com.example.springjparest.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

    private OrderItemService orderItemService;
    private ItemService itemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService, ItemService itemService) {
        this.orderItemService = orderItemService;
        this.itemService = itemService;
    }

    @PostMapping("/{menuItemId}/{quantity}")
    public OrderItem createAndSaveOrderItem(
                                            @PathVariable Long menuItemId,
                                            @PathVariable int quantity){
        MenuItem menuItem = itemService.findById(menuItemId);
        OrderItem orderItem = new OrderItem();
        orderItem.setItemQuantity(quantity);
        orderItem.setMenuItem(menuItem);

        //exception
        //csak csináljon egy orderItemet
        return orderItemService.saveItem(orderItem);
    }
}
