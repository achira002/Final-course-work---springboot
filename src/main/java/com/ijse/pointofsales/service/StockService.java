package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.ItemStock;

@Service
public interface StockService {
    List<ItemStock> getAllStock();

    ItemStock createStock(ItemStock stock);

    ItemStock getStockByItem(Long id);

    ItemStock updateStock(Long id, ItemStock stock);

    void deleteStock(Long id);
}
