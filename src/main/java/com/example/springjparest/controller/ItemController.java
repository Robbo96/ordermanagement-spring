package com.example.springjparest.controller;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.error.EntitiyNotFoundException;
import com.example.springjparest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;

@RestController
@RequestMapping("/items")
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
    public MenuItem getItemById(@PathVariable("id") Long itemId) throws EntitiyNotFoundException {
        return itemService.findById(itemId);
    }

    @DeleteMapping("/{id}")
    public String deleteItemById(@PathVariable("id") Long itemId) throws EntitiyNotFoundException {
        itemService.deleteItemById(itemId);
        return "MenuItem deleted successfully!";
    }
}
