package com.example.productserviceopenapi.repository;

import com.example.productserviceopenapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
