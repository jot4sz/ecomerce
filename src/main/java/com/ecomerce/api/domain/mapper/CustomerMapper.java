package com.ecomerce.api.domain.mapper;

import com.ecomerce.api.domain.customer.CustomerEntity;
import com.ecomerce.api.domain.customer.CustomerPatchRequestDTO;
import com.ecomerce.api.domain.customer.CustomerRequestDTO;
import com.ecomerce.api.domain.customer.CustomerResponseDTO;
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
