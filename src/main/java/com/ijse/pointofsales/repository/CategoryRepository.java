package com.ijse.pointofsales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.pointofsales.entity.ItemCategories;


@Repository
public interface CategoryRepository extends JpaRepository<ItemCategories, Long> {

}