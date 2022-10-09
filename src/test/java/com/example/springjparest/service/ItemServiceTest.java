package com.example.springjparest.service;

import com.example.springjparest.entity.MenuItem;
import com.example.springjparest.entity.OrderItem;
import com.example.springjparest.error.EntityNotFoundException;
import com.example.springjparest.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @MockBean
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        Set<OrderItem> orderItems = new HashSet<>();

        MenuItem menuItem = new MenuItem(1L,"Espresso","Coffee", 5, orderItems);
        OrderItem orderItem1 = new OrderItem(2L,menuItem,2);
        orderItems.add(orderItem1);

        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(menuItem));

    }

    @Test
    public void whenValidItemId_thenItemFound() throws EntityNotFoundException {
        Long menuItemId = 1L;
        MenuItem found = itemService.findById(menuItemId);

        assertEquals(menuItemId,found.getItemId());
    }

    @Test
    public void whenInvalidItemId_thenItemFound() throws EntityNotFoundException {
        Long menuItemWrongId = 3L;
        Long menuItemId = 1L;
        MenuItem found = itemService.findById(menuItemId);

        assertNotEquals(found.getItemId(), menuItemWrongId);
    }
}