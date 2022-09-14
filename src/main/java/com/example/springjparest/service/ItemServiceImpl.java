package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
//import javax.validation.Valid;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public MenuItem saveItem(@Validated @RequestBody MenuItem menuItem) {
        return itemRepository.save(menuItem);
    }

    @Override
    public MenuItem findById(Long itemId) {
        Optional<MenuItem> item = itemRepository.findById(itemId);
        //implement isprestent
        return item.get();
    }

    @Override
    public boolean isItemExists(String itemName) {
        return itemRepository.existsByItemNameEquals(itemName);
    }

    @Override
    public MenuItem getItemById(Long itemId) {
        return itemRepository.getById(itemId);
    }
}
