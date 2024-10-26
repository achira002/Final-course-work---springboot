package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.ItemCategories;

@Service
// crud operation
public interface CategoryService {
    List<ItemCategories> getAllCategories(); // view categories

    ItemCategories createCategory(ItemCategories category); // create a category

    ItemCategories getCategoryById(Long id); // view category by id

    ItemCategories updateCategory(Long id, ItemCategories category); // update a category

    void deleteCategory(Long id); // delete a category
}
