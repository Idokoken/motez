package com.ndgrouops.motez.controller;

import com.ndgrouops.motez.model.Category;
import com.ndgrouops.motez.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
          Category newCategory = categoryService.createCategory(category);
          return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCategory(@PathVariable Integer id) {
        Optional<Category> category = categoryService.getOneCategory(id);
        return new ResponseEntity<Category>(category.get(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Category>>  getAllCategory(){
        List<Category> allCategory =  categoryService.getAllCategory();
        return new ResponseEntity<List<Category>>(allCategory, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        Optional<Category> updatedCategory =  categoryService.updateCategory(category);
        return new ResponseEntity<Category>(updatedCategory.get(), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
