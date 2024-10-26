package com.ijse.pointofsales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.pointofsales.entity.ItemStock;

@Repository
public interface StockRepository extends JpaRepository<ItemStock, Long> {

}
