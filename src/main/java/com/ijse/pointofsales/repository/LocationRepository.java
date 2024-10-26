package com.ijse.pointofsales.repository;

import com.ijse.pointofsales.entity.StockLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<StockLocation, Long> {

}
