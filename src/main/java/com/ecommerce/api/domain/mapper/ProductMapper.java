package com.ecommerce.api.domain.mapper;

import com.ecommerce.api.domain.product.ProductEntity;
import com.ecommerce.api.domain.product.ProductRequestDTO;
import com.ecommerce.api.domain.product.ProductResponseDTO;
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
