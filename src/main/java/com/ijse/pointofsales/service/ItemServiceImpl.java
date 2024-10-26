package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.Items;
import com.ijse.pointofsales.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Items createItems(Items item) {
        return itemRepository.save(item);
    }

    @Override
    public Items getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Items updateItem(Long id, Items item) {
        Items existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null) {
            return null;
        } else {
            existingItem.setName(item.getName());
            existingItem.setPrice(item.getPrice());
            existingItem.setDescription(item.getDescription());
            existingItem.setCategory(item.getCategory());
            return itemRepository.save(existingItem);
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
