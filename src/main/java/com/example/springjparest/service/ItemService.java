package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.error.EntityNotFoundException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public interface ItemService {
    MenuItem saveItem(MenuItem menuItem);

    MenuItem findById(Long itemId) throws EntityNotFoundException;

    boolean isItemExists(String itemName);

    MenuItem getItemById(Long itemId); //cleanup

    void deleteItemById(Long itemId) throws EntityNotFoundException, MethodArgumentTypeMismatchException;
}
