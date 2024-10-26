package com.ijse.pointofsales.service;

import java.util.List;


import com.ijse.pointofsales.entity.Items;

import org.springframework.stereotype.Service;

@Service // Crud operation
public interface ItemService {
    List<Items> getAllItems(); // View all items

    Items createItems(Items item); // Create a item

    Items getItemById(Long id); // Find a item by id

    Items updateItem(Long id, Items item); // Update a item

    void deleteItem(Long id); // Delete a item
}
