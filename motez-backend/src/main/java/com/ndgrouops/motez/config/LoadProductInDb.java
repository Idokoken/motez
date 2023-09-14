package com.ndgrouops.motez.config;

import com.ndgrouops.motez.model.Product;
import com.ndgrouops.motez.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class LoadProductInDb implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception{

        Product product1 = new Product("Sneaker", "one of the best Addidas Sneakers","Sport Wear", "Addidas",
                20.00,4.2, 450, 300, "img cover");
//        Product product2 = new Product();
        List<Product> productList = Arrays.asList(product1);
        productList = productList.stream().collect(Collectors.toList());

        productRepository.saveAll(productList);
    }

}
