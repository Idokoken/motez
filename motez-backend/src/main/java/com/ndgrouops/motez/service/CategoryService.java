package com.ndgrouops.motez.service;

import com.ndgrouops.motez.model.Category;
import com.ndgrouops.motez.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> getOneCategory(Integer id) {
        return categoryRepository.findById(id);
    }
    public List<Category>getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }
//    public List<Category> getCategoryByName(String catName) {
//
//        return categoryRepository.findCategoryByName(catName);
//    }
    public Optional<Category> updateCategory(Category category) {
      Optional<Category>optCategory = categoryRepository.findById(category.getId());
      if(optCategory.isPresent()) {
          Category extProduct = optCategory.get();
          extProduct.setCategoryName(category.getCategoryName());
          extProduct.setDescription(category.getDescription());
          extProduct.setImageUrl(category.getImageUrl());

          categoryRepository.save(extProduct);
          return Optional.of(extProduct);
      }
        return Optional.empty();
    }

    public void deleteCategory(Integer id) {
        Optional<Category> optCategory = categoryRepository.findById(id);
        categoryRepository.delete(optCategory.get());
    }
}
