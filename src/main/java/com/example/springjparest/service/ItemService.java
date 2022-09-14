package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;

public interface ItemService {
    MenuItem saveItem(MenuItem menuItem);

    MenuItem findById(Long itemId);

    boolean isItemExists(String itemName);

    MenuItem getItemById(Long itemId);
}
