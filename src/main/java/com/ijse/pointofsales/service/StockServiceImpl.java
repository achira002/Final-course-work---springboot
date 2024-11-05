package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.ItemStock;
import com.ijse.pointofsales.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<ItemStock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public ItemStock createStock(ItemStock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public ItemStock getStockByItem(Long itemCode) {
        return stockRepository.findById(itemCode).orElse(null);
    }

    @Override
    public ItemStock updateStock(Long itemCode, ItemStock stock) {
        ItemStock existingStock = stockRepository.findById(itemCode).orElse(null);
        if (existingStock != null) {
            return stockRepository.save(stock);
        } else {
            return null;
        }
    }

    @Override
    public void deleteStock(Long itemCode) {
        stockRepository.deleteById(itemCode);
    }

}
