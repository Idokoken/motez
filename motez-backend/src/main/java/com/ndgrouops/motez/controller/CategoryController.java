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
//        if(Objects.nonNull(categoryService.getCategoryByName(category.getCategoryName()))){
//            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already created"), HttpStatus.CREATED);
//        }
//        categoryService.createCategory(category);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "category successfully created"), HttpStatus.CREATED);
          categoryService.createCategory(category);
          return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Optional<Category> getOneCategory(@PathVariable Integer id) {
       return categoryService.getOneCategory(id);
    }
    @GetMapping
    public ResponseEntity<List<Category>>  getAllCategory(){

        List<Category> allCategory =  categoryService.getAllCategory();
        return new ResponseEntity<List<Category>>(allCategory, HttpStatus.OK);
    }
    @PutMapping
    public Category updateCategory(Category category) {
         Optional<Category>  optCategory = categoryService.updateCategory(category);
         return optCategory.get();
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
