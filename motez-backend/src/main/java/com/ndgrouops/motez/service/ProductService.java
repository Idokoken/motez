package com.ndgrouops.motez.service;

import com.ndgrouops.motez.model.Product;
import com.ndgrouops.motez.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Optional<Product> getOneProduct(Integer id) {
        return productRepository.findById(id);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getProductByName(String name) {
        return productRepository.getProductByName(name);
    }
    public Optional<Product> updateProduct(Product product){
        Optional<Product> optProduct = productRepository.findById(product.getProductId());
        if(optProduct.isPresent()) {
            Product existingProduct = optProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription((product.getDescription()));
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImgUrl(product.getImgUrl());

            productRepository.save(existingProduct);

            return Optional.of(existingProduct);
        }
        return Optional.empty();
    }
    public void deleteProduct(Integer id) {
        Optional<Product> OptProduct = productRepository.findById(id);
        productRepository.delete(OptProduct.get());
    }

}
