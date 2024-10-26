package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.ItemCategories;
import com.ijse.pointofsales.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ItemCategories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ItemCategories createCategory(ItemCategories category) {
        return categoryRepository.save(category);
    }

    @Override
    public ItemCategories getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategories updateCategory(Long id, ItemCategories category) {

        ItemCategories existingCategory = categoryRepository.findById(id).orElse(null);

        if (existingCategory == null) {
            return null;
        } else {
            existingCategory.setCategoryName(category.getCategoryName());
            return categoryRepository.save(existingCategory);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
