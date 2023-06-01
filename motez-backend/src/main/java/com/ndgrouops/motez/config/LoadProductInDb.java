//package com.ndgrouops.motez.config;
//
//import com.ndgrouops.motez.model.Category;
//import com.ndgrouops.motez.model.Product;
//import com.ndgrouops.motez.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@Transactional
//public class LoadProductInDb implements CommandLineRunner {
//    @Autowired
//    ProductRepository productRepository;
//    @Override
//    public void run(String... args) throws Exception{
//        Category category1 = new Category("mike", "desc");
//
//        Product product1 = new Product("Sniker", "one of the best snikers", 20.0, "img cover", "Adidas", 3, 17, category1);
////        Product product2 = new Product();
//        List<Product> productList = Arrays.asList(product1);
//        productList = productList.stream().collect(Collectors.toList());
//
//        productRepository.saveAll(productList);
//    }
//}
