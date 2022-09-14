package com.example.springjparest.controller;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

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
    public MenuItem getItemById(@PathVariable("id") Long itemId){
        return itemService.getItemById(itemId);
    }
}