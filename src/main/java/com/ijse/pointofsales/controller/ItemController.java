package com.ijse.pointofsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pointofsales.dto.ItemRequestDto;
import com.ijse.pointofsales.entity.ItemCategories;
import com.ijse.pointofsales.entity.Items;
import com.ijse.pointofsales.service.CategoryService;
import com.ijse.pointofsales.service.ItemService;
//import com.ijse.pointofsales.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    // @Autowired
    // private StockService stockService;

    @GetMapping("/item")
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> items = itemService.getAllItems();
        // List<ItemRequestDto> response =
        // items.stream().map(ItemRequestDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

    @PostMapping("/item")
    public ResponseEntity<Items> createItems(@RequestBody ItemRequestDto itemRequestDto) {
        Items item = new Items();
        item.setName(itemRequestDto.getName());
        item.setPrice(itemRequestDto.getPrice());
        item.setDescription(itemRequestDto.getDescription());

        ItemCategories category = categoryService.getCategoryById(itemRequestDto.getCategoryId());
        item.setCategory(category);

        Items createdItem = itemService.createItems(item);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Items> getItemById(@PathVariable Long id) {
        Items item = itemService.getItemById(id);
        if (item == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(item);
        }
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<Items> updateItem(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto) {
        Items item = new Items();
        item.setName(itemRequestDto.getName());
        item.setPrice(itemRequestDto.getPrice());
        item.setDescription(itemRequestDto.getDescription());

        ItemCategories itemCategory = categoryService.getCategoryById(itemRequestDto.getCategoryId());
        item.setCategory(itemCategory);
        // Stock stock = stockService.getStockById(itemRequestDto.getStock());
        // item.setStock(stock);

        Items updatedItem = itemService.updateItem(id, item);

        if (updatedItem == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(updatedItem);
        }

    }

    @DeleteMapping("/item/id")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
