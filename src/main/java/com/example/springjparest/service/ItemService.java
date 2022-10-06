package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.error.EntitiyNotFoundException;

public interface ItemService {
    MenuItem saveItem(MenuItem menuItem);

    MenuItem findById(Long itemId) throws EntitiyNotFoundException;

    boolean isItemExists(String itemName);

    MenuItem getItemById(Long itemId); //cleanup

    void deleteItemById(Long itemId) throws EntitiyNotFoundException;
}
