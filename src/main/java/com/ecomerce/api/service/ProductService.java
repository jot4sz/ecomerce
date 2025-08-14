package com.ecomerce.api.service;

import com.ecomerce.api.domain.mapper.ProductMapper;
import com.ecomerce.api.domain.product.ProductEntity;
import com.ecomerce.api.domain.product.ProductRequestDTO;
import com.ecomerce.api.domain.product.ProductResponseDTO;
import com.ecomerce.api.exception.ProductNotFoundException;
import com.ecomerce.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductResponseDTO createProduct(ProductRequestDTO data){
        return productMapper.toDTO(
                productRepository.save(
                        productMapper.toEntity(data)));
    }

    public List<ProductResponseDTO> getProducts(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> productPage = this.productRepository.findAll(pageable);
        return productPage.map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getBrand(), p.getDescription(), p.getPrice(), p.getTechnicalInfo(), p.getAvailable()))
                .stream().toList();
    }

    public ProductResponseDTO getProductsById(UUID id){
        return productMapper.toDTO(
                this.productRepository.findById(id)
                        .orElseThrow(ProductNotFoundException::new));
    }

    public ProductResponseDTO updateById(UUID id, ProductRequestDTO body) {
        ProductEntity product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        productMapper.updateProductFromDTO(body, product);
        return productMapper.toDTO(product);
    }

    public void deleteById(UUID id){
        this.productRepository.delete(
                this.productRepository.findById(id)
                        .orElseThrow(ProductNotFoundException::new));
    }
}
