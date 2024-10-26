package com.ijse.pointofsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pointofsales.entity.ItemCategories;
import com.ijse.pointofsales.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<ItemCategories>> getAllCategories() {
        List<ItemCategories> categories = categoryService.getAllCategories();
        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/category")
    public ResponseEntity<ItemCategories> createCategory(@RequestBody ItemCategories category) {
        ItemCategories createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ItemCategories> getCategoryById(@PathVariable Long id) {
        ItemCategories category = categoryService.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(category);
        }
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<ItemCategories> updateCategory(@PathVariable Long id, @RequestBody ItemCategories category) {
        ItemCategories createdCategory = categoryService.updateCategory(id, category);
        if (createdCategory == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(createdCategory);
        }
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
