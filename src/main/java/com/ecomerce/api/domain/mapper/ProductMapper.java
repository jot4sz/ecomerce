package com.ecomerce.api.domain.mapper;

import com.ecomerce.api.domain.product.ProductEntity;
import com.ecomerce.api.domain.product.ProductRequestDTO;
import com.ecomerce.api.domain.product.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity toEntity(ProductRequestDTO dto);

    ProductResponseDTO toDTO(ProductEntity product);

    void updateProductFromDTO(ProductRequestDTO dto, @MappingTarget ProductEntity entity);

}
