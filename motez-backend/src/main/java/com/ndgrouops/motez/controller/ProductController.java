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
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);
        return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable Integer id) {
        Optional<Product> optProduct = productService.getOneProduct(id);
        return new ResponseEntity<Product>(optProduct.get(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
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
