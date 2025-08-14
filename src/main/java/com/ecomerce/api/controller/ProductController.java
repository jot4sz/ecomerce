package com.ecomerce.api.controller;

import com.ecomerce.api.domain.product.ProductRequestDTO;
import com.ecomerce.api.domain.product.ProductResponseDTO;
import com.ecomerce.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO body){
        ProductResponseDTO newProduct = this.productService.createProduct(body);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(newProduct.id())
                .toUri();
        return ResponseEntity.created(location).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        List<ProductResponseDTO> allProducts = this.productService.getProducts(page, size);
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable UUID productId){
        ProductResponseDTO product = this.productService.getProductsById(productId);
        return ResponseEntity.ok(product);
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductResponseDTO> updateById(@PathVariable UUID productId, @RequestBody ProductRequestDTO body){
        ProductResponseDTO product = this.productService.updateById(productId, body);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID productId){
        this.productService.deleteById(productId);
        return ResponseEntity.noContent().build();
    }
}
