package com.ndgrouops.motez.controller;

import com.ndgrouops.motez.model.Product;
import com.ndgrouops.motez.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @GetMapping("/{id}")
    public Optional<Product> getOneProduct(@PathVariable Integer id) {
        return productService.getOneProduct(id);
    }
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @GetMapping("/search")
    public ResponseEntity<?> getProductByName(@RequestParam(name = "item") String item){
        List<Product> product = productService.getProductByName(item);
        return new ResponseEntity<List<Product>>(product, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> newProduct = productService.updateProduct(product);
        return new ResponseEntity<Product>(newProduct.get(), HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
