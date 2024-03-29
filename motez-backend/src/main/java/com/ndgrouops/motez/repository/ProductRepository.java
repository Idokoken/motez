package com.ndgrouops.motez.repository;

import com.ndgrouops.motez.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
   public List<Product> getProductByName(String name);
}
