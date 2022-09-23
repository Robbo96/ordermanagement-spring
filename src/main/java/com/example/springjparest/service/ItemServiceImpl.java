package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.error.EntitiyNotFoundException;
import com.example.springjparest.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
//import javax.validation.Valid;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public MenuItem saveItem(@Validated @RequestBody MenuItem menuItem) {
        return itemRepository.save(menuItem);
    }

    @Override
    public MenuItem findById(Long itemId) throws EntitiyNotFoundException {
        Optional<MenuItem> item = itemRepository.findById(itemId);

        if (item.isEmpty()) {
            throw new EntitiyNotFoundException("Item doesn't exist.");
        }

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
