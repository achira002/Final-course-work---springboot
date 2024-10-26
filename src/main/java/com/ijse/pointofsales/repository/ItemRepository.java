package com.ijse.pointofsales.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.pointofsales.entity.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

}
