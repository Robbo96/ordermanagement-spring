package com.example.springjparest.controller;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.error.EntityNotFoundException;
import com.example.springjparest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public MenuItem saveItem(@RequestBody MenuItem menuItem){
        //System.out.println(menuItem.getItemName());
        return itemService.saveItem(menuItem);
    }

    @GetMapping("/{id}")
    public MenuItem getItemById(@PathVariable("id") Long itemId) throws EntityNotFoundException {
        return itemService.findById(itemId);
    }

    @DeleteMapping("/{id}")
    public String deleteItemById(@PathVariable("id") Long itemId) throws EntityNotFoundException, MethodArgumentTypeMismatchException {
        itemService.deleteItemById(itemId);
        return "MenuItem deleted successfully!";
    }
}
