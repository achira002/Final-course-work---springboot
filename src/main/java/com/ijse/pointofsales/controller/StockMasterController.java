package com.ijse.pointofsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pointofsales.dto.StockRequestDto;
import com.ijse.pointofsales.entity.ItemCategories;
import com.ijse.pointofsales.entity.ItemStock;
import com.ijse.pointofsales.entity.Items;
import com.ijse.pointofsales.entity.StockLocation;
import com.ijse.pointofsales.service.CategoryService;
import com.ijse.pointofsales.service.ItemService;
import com.ijse.pointofsales.service.LocationService;
import com.ijse.pointofsales.service.StockService;

@RestController
@RequestMapping("/stock")
@ControllerAdvice
@CrossOrigin(origins = "*")
public class StockMasterController {
    @Autowired
    private StockService stockService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemStock>> getAllStock() {
        List<ItemStock> stock = stockService.getAllStock();
        return ResponseEntity.ok(stock);

    }

    @PostMapping
    public ResponseEntity<ItemStock> createStock(@RequestBody StockRequestDto stockRequestDto) {
        ItemStock stock = new ItemStock();
        StockLocation location = locationService.getLocationById(stockRequestDto.getLocCode());
        stock.setLocation(location);

        Items itemCode = itemService.getItemById(stockRequestDto.getItemCode());
        stock.setItem(itemCode);

        ItemCategories itemCategory = categoryService.getCategoryById(stockRequestDto.getCatId());
        stock.setCategory(itemCategory);

        stock.setQty(stockRequestDto.getQty());

        ItemStock createdStock = stockService.createStock(stock);
        return ResponseEntity.ok(createdStock);

    }

    @GetMapping("/{itemCode}")
    public ResponseEntity<ItemStock> getStockById(@PathVariable Long id) {
        ItemStock stock = stockService.getStockByItem(id);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemStock> updateStock(@PathVariable Long id, @RequestBody ItemStock stock) {
        ItemStock exiStockMaster = stockService.updateStock(id, stock);
        if (exiStockMaster != null) {
            return ResponseEntity.ok(exiStockMaster);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
