package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.error.EntityNotFoundException;
import com.example.springjparest.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
    public MenuItem findById(Long itemId) throws EntityNotFoundException {
        Optional<MenuItem> item = itemRepository.findById(itemId);

        if (item.isEmpty()) {
            throw new EntityNotFoundException("Item doesn't exist.");
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

    @Override
    public void deleteItemById(Long itemId) throws EntityNotFoundException, MethodArgumentTypeMismatchException {
        Optional<MenuItem> item = itemRepository.findById(itemId);

        if (item.isEmpty()) {
            throw new EntityNotFoundException("Item doesn't exist");
        }

        itemRepository.deleteById(itemId);
    }
}
