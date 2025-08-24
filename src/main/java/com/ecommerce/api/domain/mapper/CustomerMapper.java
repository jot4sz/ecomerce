package com.ecommerce.api.domain.mapper;

import com.ecommerce.api.domain.customer.CustomerEntity;
import com.ecommerce.api.domain.customer.CustomerPatchRequestDTO;
import com.ecommerce.api.domain.customer.CustomerRequestDTO;
import com.ecommerce.api.domain.customer.CustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity toEntity(CustomerRequestDTO dto);

    CustomerResponseDTO toDTO(CustomerEntity customer);

    void updatePartialCustomerFromDTO(CustomerPatchRequestDTO dto, @MappingTarget CustomerEntity entity);

}
