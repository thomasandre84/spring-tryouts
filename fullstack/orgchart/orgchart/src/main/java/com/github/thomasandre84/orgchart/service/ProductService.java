package com.github.thomasandre84.orgchart.service;

import com.github.thomasandre84.orgchart.model.Product;
import com.github.thomasandre84.orgchart.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        log.info("Goind to save Product: {}", product);
        Product saved = productRepository.save(product);
        return saved;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
