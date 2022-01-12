package com.github.thomasandre84.orgchart.controller;

import com.github.thomasandre84.orgchart.model.Product;
import com.github.thomasandre84.orgchart.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.github.thomasandre84.orgchart.controller.ProductController.BASE_URL;

/**
 * Rest Controller for Products.
 */
@RestController
@RequestMapping(value = BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    static final String BASE_URL = "/products";
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Get all Products.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (Exception e) {
            log.error("Error ", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Add a new Product.
     * @param product
     * @return
     */
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
        } catch (Exception e) {
            log.error("Could not add Product: {} ", product.getName(), e);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

}
