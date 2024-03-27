package com.example.productserviceopenapi.service;

import com.example.productserviceopenapi.model.Product;
import com.example.productserviceopenapi.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
    }


    public Product update(Long id, Product product) {
        return productRepository.findById(id).map(productToEdit -> {
            productToEdit.setName(product.getName());
            productToEdit.setPrice(product.getPrice());
            productToEdit.setQuantity(product.getQuantity());
            return productRepository.save(productToEdit);
        }).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
    }

    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Product removed: " + id;
    }

}
